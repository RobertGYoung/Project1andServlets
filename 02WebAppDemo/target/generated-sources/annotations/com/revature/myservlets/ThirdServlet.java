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
 * Servlet implementation class ThirdServlet
 */
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		User user = new User();
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		
		user.setUserName(userName);
		user.setPassword(passWord);
		UserLogic userLogic = new UserLogic();
		
		out.print("<h1>New username is "+user.getUserName()+" and password is "+user.getPassword()+"<br> User upload to database:"+userLogic.insertUser(user));
	}

}
