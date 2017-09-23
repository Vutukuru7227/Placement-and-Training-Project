package com.jobportal.controllers.CommonController;

import java.io.IOException;
import static java.lang.System.out;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.models.RegistrationModel;
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
			RegistrationModel registerationModel = new RegistrationModel();
			
			
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email_id = request.getParameter("signupEmail");
			String password = request.getParameter("signupPassword");
			String member_type = request.getParameter("member_type");
			String type = "";
			
			if(member_type.equals("0")) {
				type = "Applicant";
			}
			else {
				type = "Employer";
			}
			
			registerationModel.setFirst_name(firstname);
			registerationModel.setLast_name(lastname);
			registerationModel.setEmail_id(email_id);
			registerationModel.setPassword(password);
			registerationModel.setMember_type(type);
			
			
			RegistrationService registrationService = new RegistrationService();
			boolean result = registrationService.registerUser(registerationModel);
			
			if(result) {
				response.sendRedirect("success.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
