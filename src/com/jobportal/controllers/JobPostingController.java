package com.jobportal.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.System.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.Joinable;

import com.jobportal.models.JobPostModel;
import com.jobportal.services.DBMngr;
/**
 * Servlet implementation class JobPosting
 */
@WebServlet("/JobPosting")
public class JobPostingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobPostingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		out.println("Reached here with emp id "+request.getParameter("emp_id"));
		DBMngr jobListingService = new DBMngr();
		ArrayList<JobPostModel> jobs = new ArrayList<JobPostModel>();
		
		try {
			jobs = jobListingService.getJobIds(request.getParameter("emp_id").toString());
			request.setAttribute("jobsPosted", jobs);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("jobs_posted.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String job_title = request.getParameter("job_title");
		String job_description = request.getParameter("job_description");
		String company = request.getParameter("company");
		String location = request.getParameter("location");
		String application_deadline = request.getParameter("application_deadline");
		String emp_id = request.getParameter("emp_id");
		out.println(job_title);
		out.println(job_description);
		out.println(application_deadline);
		try {
			Date deadline = null;
			deadline = new SimpleDateFormat("YYYY-MM-DD").parse(application_deadline);
			
			
			JobPostModel jobPostModel = new JobPostModel();
			jobPostModel.setJob_title(job_title);
			jobPostModel.setJob_description(job_description);
			jobPostModel.setDeadline(deadline);
			jobPostModel.setCompany(company);
			jobPostModel.setLocation(location);
			jobPostModel.setEmp_id(emp_id);
			DBMngr jobPostingService = new DBMngr();
			boolean result = jobPostingService.postJob(jobPostModel);
			PrintWriter out = response.getWriter();
			if(result) {
				//TODO: Need a success page for this action
				response.sendRedirect("job_post_success.jsp");
			}
			else {
				out.println("Please retry later");
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

}
