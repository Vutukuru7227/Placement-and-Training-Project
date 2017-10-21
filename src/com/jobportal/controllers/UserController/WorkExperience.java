package com.jobportal.controllers.UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.models.WorkExperienceModel;
import com.jobportal.services.user.WorkExperienceService;

/**
 * Servlet implementation class WorkExperience
 */
@WebServlet("/WorkExperience")
public class WorkExperience extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private WorkExperienceService workservice;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkExperience() {
        super();
        // TODO Auto-generated constructor stub
        workservice = new WorkExperienceService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("user_id"));
            try {
            	workservice.deleteWorkex(userId);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            forward = "/user_profile.jsp";
            try {
				request.setAttribute("workex", workservice.getWorkexDetails());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
        } else if (action.equalsIgnoreCase("edit")){
            forward = "/user_workex.jsp";
            int userId = Integer.parseInt(request.getParameter("user_id"));
            WorkExperienceModel workmodel = null;
			try {
				workmodel = workservice.editWorkex(userId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            request.setAttribute("workmodel", workmodel);
        }else if (action.equalsIgnoreCase("listWorkExperience")){
            forward = "/user_profile.jsp";
            try {
				request.setAttribute("workex", workservice.getWorkexDetails());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }  else {
            forward = "/user_workex.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorkExperienceModel workmodel = new WorkExperienceModel();
		HttpSession session = request.getSession();
		workmodel.setEmail_id((String) session.getAttribute("email_id"));
		workmodel.setTitle(request.getParameter("title"));
		workmodel.setOrganization_name(request.getParameter("organization_name"));
		workmodel.setLocation(request.getParameter("location"));
		workmodel.setExp_from(request.getParameter("exp_from"));
		workmodel.setExp_to(request.getParameter("exp_to"));
		workmodel.setAchievements(request.getParameter("achievements"));
		
		String userid = request.getParameter("user_id");
        if(userid == null || userid.isEmpty())
        {
            try {
            	workservice.addWorkex(workmodel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else
        {
        	workmodel.setUser_id(Integer.parseInt(userid));
            try {
            	workservice.updateWorkex(workmodel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        RequestDispatcher view = request.getRequestDispatcher("/user_profile.jsp");
        try {
			request.setAttribute("workex", workservice.getWorkexDetails());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
       
		
	}

}
