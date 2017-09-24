package com.jobportal.controllers.CommonController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.models.RegistrationModel;
import com.jobportal.services.common.LoginService;

import static java.lang.System.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegistrationModel result;
		try {
			String email_id = request.getParameter("signinEmail");
			String password = request.getParameter("signinPassword");
			
			RegistrationModel loginModel = new RegistrationModel();
			loginModel.setEmail_id(email_id);
			loginModel.setPassword(password);
			
			LoginService loginService = new LoginService();
			 result = loginService.authenticateUser(loginModel);
			
			
			if(result != null) {
				HttpSession session = request.getSession();
				session.setAttribute("email_id", result.getEmail_id());
				session.setAttribute("username", result.getFirst_name()+" "+result.getLast_name());

				if(result.getMember_type().equals("Applicant")) {
					session.setAttribute("member_type", "Applicant");
					RequestDispatcher dispatcher = request.getRequestDispatcher("user_home_page.jsp");
					dispatcher.include(request, response);
				}
				else {
					session.setAttribute("member_type", "Employer");
					RequestDispatcher dispatcher = request.getRequestDispatcher("employer_home_page.jsp");
					dispatcher.include(request, response);
				}

			}else {
				response.sendRedirect("error.jsp");
			}	
		}
		catch (Exception e) {
			out.println("Error Occurred");
		}
	}

}
