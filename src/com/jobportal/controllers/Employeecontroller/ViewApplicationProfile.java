package com.jobportal.controllers.Employeecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.services.employee.ViewApplicationProfileService;


/**
 * Servlet implementation class ViewApplicationProfile
 */
@WebServlet("/ViewApplicationProfile")
public class ViewApplicationProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ViewApplicationProfileService profileservice;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewApplicationProfile() {
        super();
        // TODO Auto-generated constructor stub
        profileservice = new ViewApplicationProfileService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email_id = request.getParameter("email_id");
		 try {
				request.setAttribute("profile", profileservice.getProfileDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		    RequestDispatcher view = request.getRequestDispatcher("/view_application_profile.jsp");
	        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
