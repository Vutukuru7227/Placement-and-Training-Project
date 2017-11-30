package com.jobportal.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.models.ApplicationModel;
import com.jobportal.services.employee.JobPostingService;

/**
 * Servlet implementation class ViewJobs
 */
@WebServlet("/ViewJobs")
public class ViewJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewJobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		JobPostingService service = new JobPostingService();
		ArrayList<ApplicationModel> appliedList = new ArrayList<>();
		
		appliedList = service.viewSpecificJobPosted(Integer.parseInt(request.getParameter("job_id")));
		request.setAttribute("appliedList", appliedList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view_applied_list.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
