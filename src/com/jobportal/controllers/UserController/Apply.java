package com.jobportal.controllers.UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int job_id = Integer.parseInt(request.getAttribute("job_id").toString());
		String user_id = request.getAttribute("user_id").toString();
		
		ApplicationModel model = new ApplicationModel();
		model.setJob_id(job_id);
		model.setUser_id(user_id);
		
		ApplyService applyService = new ApplyService();
		boolean result = applyService.Apply(model);
		if(result){
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_home_page.jsp");
			dispatcher.include(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.include(request, response);
		}
		
		
	}

}
