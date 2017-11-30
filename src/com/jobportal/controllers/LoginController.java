package com.jobportal.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.models.EmployerModel;
import com.jobportal.models.JobSeekerModel;
import com.jobportal.services.DBMngr;
import static java.lang.System.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String member_type;
		try {
			String email_id = request.getParameter("signinEmail");
			String password = request.getParameter("signinPassword");
			
			DBMngr loginService = new DBMngr();
			member_type = loginService.authenticateUserandSpecifyType(email_id, password);
			
			if(member_type == null) {
				response.sendRedirect("error.jsp");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("email_id", email_id);
				
				if(member_type.equals("Employer")) {
					EmployerModel result = new EmployerModel();
					result = loginService.getEmployerDetails(email_id);
					
					if(result == null) {
						response.sendRedirect("error.jsp");
					}
					else {
						session.setAttribute("username", result.getFirst_name()+" "+result.getLast_name());
						session.setAttribute("member_type", "Employer");
						RequestDispatcher dispatcher = request.getRequestDispatcher("employer_home_page.jsp");
						dispatcher.include(request, response);
					}
				}else {
					JobSeekerModel result = new JobSeekerModel();
					
					result = loginService.getJobSeekerDetails(email_id);
					
					if(result == null) {
						response.sendRedirect("error.jsp");
					}
					else {
						session.setAttribute("username", result.getFirst_name()+" "+result.getLast_name());
						session.setAttribute("member_type", "Applicant");
						RequestDispatcher dispatcher = request.getRequestDispatcher("user_home_page.jsp");
						dispatcher.include(request, response);
					}
				}
			}	
		}
		catch (Exception e) {
			out.println("Error Occurred");
		}
	}

}
