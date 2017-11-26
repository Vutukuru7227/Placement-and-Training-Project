package com.jobportal.controllers.Employeecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.services.employee.ApplicationStatusService;
import com.jobportal.services.user.EducationService;
import com.jobportal.services.user.GeneralInfoService;
import com.jobportal.services.user.SkillsService;
import com.jobportal.services.user.WorkExperienceService;

/**
 * Servlet implementation class ViewApplicationProfile
 */
@WebServlet("/ViewApplicationProfile")
public class ViewApplicationProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EducationService eduservice;   
	private GeneralInfoService general;
	private WorkExperienceService workservice;
	private SkillsService skills;
	private ApplicationStatusService statuservice;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewApplicationProfile() {
        super();
        // TODO Auto-generated constructor stub
        eduservice = new EducationService();
        general = new GeneralInfoService();
        workservice = new WorkExperienceService();
        skills = new SkillsService();
        statuservice = new ApplicationStatusService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email_id = request.getParameter("email_id");
		System.out.println(email_id);
		HttpSession session = request.getSession();
        String emp_id = (String) session.getAttribute("email_id");
		String status = request.getParameter("status");
		 try {
				request.setAttribute("education", eduservice.getEducationDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 try {
				request.setAttribute("general", general.getGeneralDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 try {
				request.setAttribute("workex", workservice.getWorkexDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 try {
				request.setAttribute("skills", skills.getSkillDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 try {
				statuservice.changeApplicationStatus(status, emp_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 try {
				request.setAttribute("status", statuservice.getApplicationStatus(emp_id));
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