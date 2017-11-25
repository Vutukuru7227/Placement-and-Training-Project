package com.jobportal.controllers.UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.services.user.JobListingsService;

/**
 * Servlet implementation class JobListings
 */
@WebServlet("/JobListings")
public class JobListings extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobListingsService joblistservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobListings() {
        super();
        joblistservice = new JobListingsService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		try {
			request.setAttribute("searchresults", joblistservice.getJobListings(keyword));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/job_listing.jsp");
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
