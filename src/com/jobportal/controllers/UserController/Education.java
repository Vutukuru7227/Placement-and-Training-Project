package com.jobportal.controllers.UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.models.EducationModel;
import com.jobportal.models.WorkExperienceModel;
import com.jobportal.services.user.EducationService;

/**
 * Servlet implementation class Education
 */
@WebServlet("/Education")
public class Education extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private EducationService eduservice;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Education() {
        super();
        // TODO Auto-generated constructor stub
        eduservice = new EducationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		//System.out.println(request.getParameter("user_id"));
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String email_id = (String) session.getAttribute("email_id");
        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            try {
            	eduservice.deleteEducation(userId);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            forward = "/user_profile.jsp";
            try {
				request.setAttribute("education", eduservice.getEducationDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
        } else if (action.equalsIgnoreCase("edit")){
            forward = "/user_education.jsp";
            int userId = Integer.parseInt(request.getParameter("userId"));
            EducationModel edumodel = null;
			try {
				edumodel = eduservice.editEducation(userId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            request.setAttribute("edumodel", edumodel);
        }else if (action.equalsIgnoreCase("listEducation")){
            forward = "/user_profile.jsp";
            try {
				request.setAttribute("education", eduservice.getEducationDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }  else {
            forward = "/user_education.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EducationModel edumodel = new EducationModel();
		HttpSession session = request.getSession();
		String email_id = (String) session.getAttribute("email_id");
		edumodel.setEmail_id((String) session.getAttribute("email_id"));
		edumodel.setInstitution(request.getParameter("institution"));
		edumodel.setLevel(request.getParameter("level"));
		edumodel.setGpa(request.getParameter("gpa"));
		edumodel.setMajor(request.getParameter("major"));
		edumodel.setEdu_from(request.getParameter("edu_from"));
		edumodel.setEdu_to(request.getParameter("edu_to"));
		
		String userid = request.getParameter("user_id");
        if(userid == null || userid.isEmpty())
        {
            try {
				eduservice.addEducation(edumodel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else
        {
        	edumodel.setUser_id(Integer.parseInt(userid));
            try {
            	eduservice.updateEducation(edumodel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        RequestDispatcher view = request.getRequestDispatcher("/user_profile.jsp");
        try {
			request.setAttribute("education", eduservice.getEducationDetails(email_id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
       
		
	}

}
