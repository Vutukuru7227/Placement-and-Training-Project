package com.jobportal.controllers.UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.models.GeneralInfoModel;
import com.jobportal.services.user.GeneralInfoService;

/**
 * Servlet implementation class GeneralInfo
 */
@WebServlet("/GeneralInfo")
public class GeneralInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GeneralInfoService general;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneralInfo() {
        super();
        // TODO Auto-generated constructor stub
        general = new GeneralInfoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		//System.out.println(request.getParameter("user_id"));
        String action = request.getParameter("action");
        //String model = request.getParameter("model");
        HttpSession session = request.getSession();
		String email_id = (String) session.getAttribute("email_id");
		
		//if(model.equalsIgnoreCase("general")){
		
        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            try {
            	general.deleteGeneralInfo(userId);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            forward = "/user_account.jsp";
            try {
				request.setAttribute("general", general.getGeneralDetails(email_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
        } else if (action.equalsIgnoreCase("edit")){
            forward = "/user_general.jsp";
            int userId = Integer.parseInt(request.getParameter("userId"));
            GeneralInfoModel generalmodel = new GeneralInfoModel();
			try {
				generalmodel = general.editGeneralInfo(userId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            request.setAttribute("generalmodel", generalmodel);
        }else {
            forward = "/user_general.jsp";
        }
        
//		}

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GeneralInfoModel generalmodel = new GeneralInfoModel();
		HttpSession session = request.getSession();
		String email_id = (String) session.getAttribute("email_id");
		generalmodel.setEmail_id((String) session.getAttribute("email_id"));
		generalmodel.setAddress(request.getParameter("address"));
		generalmodel.setPhone_no(request.getParameter("phone_no"));
		generalmodel.setZip_code(request.getParameter("zip_code"));
		
		String userid = request.getParameter("user_id");
        if(userid == null || userid.isEmpty())
        {
            try {
            	general.addGeneralInfo(generalmodel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else
        {
        	generalmodel.setUser_id(Integer.parseInt(userid));
            try {
            	general.updateGeneralInfo(generalmodel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        RequestDispatcher view = request.getRequestDispatcher("/user_account.jsp");
        try {
			request.setAttribute("general", general.getGeneralDetails(email_id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
       
		
	}


}
