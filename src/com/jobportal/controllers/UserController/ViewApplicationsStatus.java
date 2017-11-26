package com.jobportal.controllers.UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.services.user.ViewApplicationsStatusService;

/**
 * Servlet implementation class ViewApplicationsStatus
 */
@WebServlet("/ViewApplicationsStatus")
public class ViewApplicationsStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ViewApplicationsStatusService applications;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewApplicationsStatus() {
        super();
        applications = new ViewApplicationsStatusService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email_id = request.getParameter("email_id");
		
		try {
			request.setAttribute("applications", applications.getApplications(email_id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/view_applications.jsp");
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
