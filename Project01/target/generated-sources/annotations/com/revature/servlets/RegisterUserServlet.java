package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.logging.LoggerClass;
import com.revature.logic.EmpLogic;
import com.revature.pojo.Employee;

/**
 * Servlet implementation class RegisterUserServlet
 */
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	doProcess(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String name=request.getParameter("name");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String validatePassword=request.getParameter("validatePassword");
		LoggerClass.mainLogger.trace("Checking password against database for "+name);

	
			EmpLogic logic =new EmpLogic();
			Employee emp = new Employee();
			emp.setEmail(email);
			emp.setName(name);
			emp.setLastName(lname);
			emp.setPassWord(password);
			boolean success = logic.insertUser(emp);
		
			if(success) {
				LoggerClass.mainLogger.trace("Employee "+emp.getName()+" registered successfully");
			}
			out.print("<!DOCTYPE html>\r\n" + 
					"\r\n" + 
					"<html>\r\n" + 
					"    <head>\r\n" + 
					"        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
					"\r\n" + 
					"    </head>\r\n" + 
					"    <style>\r\n" + 
					"        body{\r\n" + 
					"            background-color: grey;\r\n" + 
					"        }\r\n" + 
					"    </style>\r\n" + 
					"<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\r\n" + 
					"<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n" + 
					"<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\r\n" + 
					"    <body>\r\n" + 
					" <div class=\"container p-0\"> \r\n" + 
					"\r\n" + 
					"      <div class=\"row bg-dark p-5 text-light\">\r\n" + 
					"      \r\n" + 
					"        <div col=\"col-sm-5 mx-auto  justify-content-center\">\r\n" + 
					"             <h1>Company Reimbursement System </h1>\r\n" + 
					"   		<br><h1>Your Registration was successful: "+success+"</h1><span><a href=\"index.jsp\"><button class=\"col-sm-2 mx-1 m-2 p-2 float-sm-right btn btn-lg btn-success rounded-lg\">Go to Login</button></a></span>\r\n" + 
			
					"        </div>");
		
		
	}
	
	
	
	
	
}
