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
import com.jobportal.services.user.EducationService;

/**
 * Servlet implementation class Education
 */
@WebServlet("/Education")
public class Education extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user_profile2.jsp";
    private static String LIST_USER = "/user_profile_display.jsp";
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EducationModel edumodel = new EducationModel();
		HttpSession session = request.getSession();
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
        }
       
		
	}

}
