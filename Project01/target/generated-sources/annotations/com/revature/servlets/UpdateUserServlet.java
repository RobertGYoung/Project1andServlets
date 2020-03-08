package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.logic.EmpLogic;
import com.revature.pojo.Employee;

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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		EmpLogic logic = new EmpLogic();
		Employee emp = (Employee) request.getSession().getAttribute("emp");
		
		System.out.println("Suppose to be something1:"+emp.getEmail());
		String email=request.getParameter("email");
		String oldEmail= (String) request.getSession().getAttribute("email");
		
		System.out.println(oldEmail);
		System.out.println("Anything?"+email);
		if(email.isEmpty()) {
			email=oldEmail;
			System.out.println("Swapped!");
		}emp.setEmail(email);
		
		
		System.out.println("Suppose to be something2:"+emp.getEmail());
		String street=request.getParameter("street");
		String oldStreet= (String) request.getSession().getAttribute("street");
		System.out.println("Suppose to be something3:"+street);

		if(street.isEmpty()) {
			street=oldStreet;
		}
		emp.setStreetAddress(street);

		String name=request.getParameter("name");
		String oldName= (String) request.getSession().getAttribute("name");
		System.out.println("New Name should be here:"+name);
		System.out.println("Old name here:"+ oldName);
		if(name.isEmpty()) {
			name=oldName;
		}			
		emp.setName(name);

		String lname=request.getParameter("lname");
		String oldLastName= (String) request.getSession().getAttribute("lname");
		if(lname==null) {
			lname=oldLastName;
		}
		emp.setLastName(lname);

		String city=request.getParameter("city");
		String oldCity= (String) request.getSession().getAttribute("city");
		if(city.isEmpty()) {
			city=oldCity;
		}
		emp.setCity(city);

		String state=request.getParameter("state");
		String oldState= (String) request.getSession().getAttribute("state");
		if(state.isEmpty()) {
			state=oldState;
		}		
		emp.setState(state);

		String zip=request.getParameter("zip");
		String oldZip= (String) request.getSession().getAttribute("zip");
		if(zip.isEmpty()) {
			zip=oldZip;
		}		
		emp.setZip(zip);

		String country=request.getParameter("country");
		String oldCountry= (String) request.getSession().getAttribute("country");
		if(country.isEmpty()) {
			country=oldCountry;
		}
		emp.setCountry(country);
		
		boolean success = logic.updateEmployeeInfo(emp);
		if(success) {
		

			session.setAttribute("emp", emp);
			session.setAttribute("email", emp.getEmail());
			session.setAttribute("name",emp.getName() );
			session.setAttribute("lname", emp.getLastName());
			session.setAttribute("country", emp.getCountry());
			session.setAttribute("street", street);
			session.setAttribute("city", emp.getCity());
			session.setAttribute("zip", emp.getZip());
			session.setAttribute("state", emp.getState());
			System.out.println("Successful Uppdate");
			request.getRequestDispatcher("completedUpdate.jsp").forward(request, response);
		}
		else {System.out.println("nothing updated");
		
	}

	}}
