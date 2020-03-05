package com.revature.myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.User;

import logic.UserLogic;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName=request.getParameter("currentUserName");
		String newUserName=request.getParameter("changeToUserName");
		String passWord=request.getParameter("passWord");

	
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			UserLogic logic = new UserLogic();
			User user;
			user = logic.getUserByUserNameAndPassword(userName, passWord);

		
			user.setUserName(newUserName);
			boolean success = logic.updateUserInfo(user);
			if(!success) {
				response.sendError(response.SC_NOT_MODIFIED, "Wrong username or password");
			}
			out.print("<h1>Old Username:"+userName
			+"<br> New Username "+user.getUserName()+"<br> Update to database:"+success);
			
			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
