package com.jobportal.controllers.UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.models.SkillsModel;
import com.jobportal.services.user.SkillsService;

/**
 * Servlet implementation class Skills
 */
@WebServlet("/Skills")
public class Skills extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SkillsService skills;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Skills() {
        super();
        // TODO Auto-generated constructor stub
        skills = new SkillsService();
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
            	skills.deleteSkill(userId);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            forward = "/user_profile.jsp";
            try {
				request.setAttribute("skills", skills.getSkillDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
        } else if (action.equalsIgnoreCase("edit")){
            forward = "/user_skills.jsp";
            int userId = Integer.parseInt(request.getParameter("userId"));
            SkillsModel skillmodel = null;
			try {
				skillmodel = skills.editSkill(userId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            request.setAttribute("skillmodel", skillmodel);
        }else if (action.equalsIgnoreCase("listSkills")){
            forward = "/user_profile.jsp";
            try {
				request.setAttribute("skills", skills.getSkillDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }  else {
            forward = "/user_skills.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SkillsModel skillmodel = new SkillsModel();
		HttpSession session = request.getSession();
		String email_id = (String) session.getAttribute("email_id");
		skillmodel.setEmail_id((String) session.getAttribute("email_id"));
		skillmodel.setCategory(request.getParameter("category"));
		skillmodel.setSkill(request.getParameter("skill"));
		
		
		String userid = request.getParameter("user_id");
        if(userid == null || userid.isEmpty())
        {
            try {
				skills.addSkill(skillmodel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else
        {
        	skillmodel.setUser_id(Integer.parseInt(userid));
            try {
            	skills.updateSkill(skillmodel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        RequestDispatcher view = request.getRequestDispatcher("/user_profile.jsp");
        try {
			request.setAttribute("skills", skills.getSkillDetails(email_id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
       
		
	}
}
