package com.jobportal.controllers.UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.models.ApplicationModel;
import com.jobportal.services.user.ApplyService;

/**
 * Servlet implementation class Apply
 */
@WebServlet("/Apply")
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String email_id = (String) session.getAttribute("email_id");
        
        int job_id = Integer.parseInt(request.getParameter("job_id"));
		//System.out.println("Job ID"+job_id);
		//System.out.println("emailID"+email_id);
		ApplicationModel model = new ApplicationModel();
		model.setJob_id(job_id);
		model.setEmail_id(email_id);
		
		ApplyService applyService = new ApplyService();
		boolean result = applyService.Apply(model);
		if(result){
			RequestDispatcher dispatcher = request.getRequestDispatcher("apply_success.jsp");
			dispatcher.include(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//int job_id = Integer.parseInt(request.getAttribute("job_id").toString());
		
		
	}

}
