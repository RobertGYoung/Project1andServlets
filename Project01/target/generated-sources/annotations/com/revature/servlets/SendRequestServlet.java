package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.logging.LoggerClass;
import com.revature.logic.EmpLogic;
import com.revature.logic.RequestLogic;
import com.revature.pojo.Employee;
import com.revature.pojo.Request;
import com.sun.org.apache.xml.internal.serialize.Printer;

/**
 * Servlet implementation class SendRequestServlet
 */
public class SendRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Employee emp = (Employee) request.getSession().getAttribute("emp");
		Request req = new Request();
		RequestLogic logic =new RequestLogic();
		String vendor=request.getParameter("vendor");
		String spentAmount=request.getParameter("spentAmount");
		String requestedAmount=request.getParameter("requestedAmount");
		String reason=request.getParameter("reason");
		String bankNumber=request.getParameter("bankNumber");
		String routingNumber=request.getParameter("routingNumber");
		String employeeId=emp.getEmployeeId();
		
		
		req.setEmployeeId(Integer.parseInt(employeeId));
		req.setVendor(vendor);
		req.setSpentAmount(Integer.parseInt(spentAmount));
		req.setRequestedAmount(Integer.parseInt(requestedAmount));
		req.setReason(reason);
		req.setBankNumber(Integer.parseInt(bankNumber));
		req.setRoutingNumber(Integer.parseInt(routingNumber));
		req.setCreatedBy(emp.getName()+" ID: "+employeeId);
		LoggerClass.mainLogger.trace("Request pojo updated for newly created request");


			boolean success = logic.insertRequest(req,emp);
			
			if(success) {
				LoggerClass.mainLogger.trace("Employee "+emp.getName()+" submitted successfully");
			}
			out.print(
					"<!DOCTYPE html>\r\n" + 
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
					"        <div col=\"col-sm-5 mx-auto  justify-content-center\">\r\n"+ 
					"             <h1>Company Reimbursement System </h1>\r\n" + 
					"   		<span><a href=\"/Project01/application.jsp\"><button class=\"col-sm-2 mx-1 m-2 p-2 float-sm-right btn btn-lg btn-success rounded-lg\"> Back to Main Menu</button></a></span>\r\n" + 
					"          <h5 class=\"text-info\"><h1>Successful Submission- Your Request Will Be Processed Soon | <span class=\"text-warning\"> EmployeeID:"+ employeeId+ "</span>\r\n" + 
					"          </h5>\r\n" + 
					"        </div>\r\n" + 
					"     \r\n" + 
					"    \r\n" + 
					"    </div>");
			
	}
}
