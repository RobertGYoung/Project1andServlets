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
 * Servlet implementation class LoginUserServlet
 */
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

	
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String radioType=request.getParameter("loginRadios");
		EmpLogic logic = new EmpLogic();
		Employee emp= logic.getEmpByEmailAndPassword(email, password);
		LoggerClass.mainLogger.trace("Employee instance initiated for: "+emp.getName());
		String name= emp.getName();
		String employeeId = emp.getEmployeeId();
		String country = emp.getCountry();
		String street = emp.getStreetAddress();
		String city = emp.getCity();
		String zip = emp.getZip();
		String state = emp.getState();
		String lname= emp.getLastName();
		int isAdmin = emp.getIsAdmin();
		System.out.println("IsAdmin:"+isAdmin);
				
		HttpSession session = request.getSession();
		session.setAttribute("emp", emp);
		session.setAttribute("email", email);
		session.setAttribute("name",name );
		session.setAttribute("lname", lname);
		session.setAttribute("employeeId", employeeId);
		session.setAttribute("country", country);
		session.setAttribute("street", street);
		session.setAttribute("city", city);
		session.setAttribute("zip", zip);
		session.setAttribute("state", state);
		session.setAttribute("password", password);
		session.setAttribute("isAdmin", isAdmin);
		LoggerClass.mainLogger.trace("Session Attributes declared");





		

		if(radioType.equals("employee")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("application.jsp");
		dispatcher.forward(request, response);
		LoggerClass.mainLogger.trace(name+"Logged in as Employee");

		}
		else if(radioType.equals("admin")
				&&isAdmin==1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminApplication.jsp");
			dispatcher.forward(request, response);
			LoggerClass.mainLogger.trace(name+"Logged in as Employee");
			
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			LoggerClass.mainLogger.trace("Log in failed");

		}
		
	}
}
