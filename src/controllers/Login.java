package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.LoginService;

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
		
		try {
			String email_id = request.getParameter("signinEmail");
			String password = request.getParameter("signinPassword");
			
			LoginService loginService = new LoginService();
			boolean result = loginService.authenticateUser(email_id,password);
			
			if(result) {
				request.setAttribute("email_id", email_id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
				dispatcher.include(request, response);
			}
			else{
				// Redirection
				return;
			}	
		}
		catch (Exception e) {
			out.println("Error Occurred");
		}
	}

}
