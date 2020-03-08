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
		
	
			EmpLogic logic =new EmpLogic();
			Employee emp = new Employee();
			emp.setEmail(email);
			emp.setName(name);
			emp.setLastName(lname);
			emp.setPassWord(password);
			boolean success = logic.insertUser(emp);
			out.print("<h1>Successful Registration- Database upload is: "+success+"</h1>");
			if(success) {
				LoggerClass.mainLogger.trace("Employee "+emp.getName()+" registered successfully");
			}
			out.print("<br><br><br>");
			out.print("<form action='/Project01/login.jsp'><input type=submit value='Go to Login'/></form></body></html>");
		
	}
	
	
	
	
	
}
