package com.jobportal.controllers.CommonController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.models.EmployerModel;
import com.jobportal.models.JobSeekerModel;
import com.jobportal.services.common.RegistrationService;

/**
 * Servlet implementation class registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			RegistrationService registrationService = new RegistrationService();

			String member_type = request.getParameter("member_type");
			
			if(member_type.equals("0")) {
				JobSeekerModel jobSeekerModel = new JobSeekerModel();
				
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String email_id = request.getParameter("signupEmail");
				String password = request.getParameter("signupPassword");
				String type = "Applicant";
				
				jobSeekerModel.setFirst_name(firstname);
				jobSeekerModel.setLast_name(lastname);
				jobSeekerModel.setEmail_id(email_id);
				jobSeekerModel.setPassword(password);
				jobSeekerModel.setMember_type(type);
				
				boolean result = registrationService.registerUser(jobSeekerModel);
				
				if(result) {
					response.sendRedirect("success.jsp");
				}else {
					response.sendRedirect("error.jsp");
				}
			}
			
			else {
				EmployerModel employerModel = new EmployerModel();
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String email_id = request.getParameter("signupEmail");
				String password = request.getParameter("signupPassword");
				String type = "Employer";
				
				employerModel.setFirst_name(firstname);
				employerModel.setLast_name(lastname);
				employerModel.setEmail_id(email_id);
				employerModel.setPassword(password);
				employerModel.setMember_type(type);
				
				boolean result = registrationService.registerUser(employerModel);
				
				if(result) {
					response.sendRedirect("success.jsp");
				}else {
					response.sendRedirect("error.jsp");
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
