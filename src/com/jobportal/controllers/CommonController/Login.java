package com.jobportal.controllers.CommonController;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
			out.print(result.getEmail_id());
			
			if(result != null) {
				//HttpSession session = request.getSession();
				request.setAttribute("username", result.getFirst_name() + " "+result.getLast_name());
				request.setAttribute("email_id", email_id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
				dispatcher.include(request, response);
			}	
		}
		catch (Exception e) {
			out.println("Error Occurred");
		}
	}

}
