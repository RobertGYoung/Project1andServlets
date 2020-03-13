<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page isELIgnored="false"%>
         <%@ page import="	java.sql.Connection,
	java.sql.PreparedStatement,
	java.sql.ResultSet,
	java.sql.SQLException,
	java.sql.Statement,
	 java.util.HashSet,
	java.util.Set,
	java.util.*,
	com.revature.connection.SingletonConnection,
	com.revature.dao.EmpDao,
	com.revature.logic.RequestLogic,
		com.revature.logic.EmpLogic,
	
com.revature.logging.LoggerClass,
com.revature.pojo.Request,
 com.revature.pojo.Employee" %>  
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <style>
        body{
            background-color: lightgrey;
        }
    </style>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <body>
 <div class="container"> 

    <div class="row bg-dark p-5 text-light">
      
        <div col="col-sm-5 mx-auto  justify-content-center">
             <h1>Company Reimbursement System </h1>
   		<span><a href="index.jsp"><button class="col-sm-2 mx-1 m-2 p-2 float-sm-right btn btn-lg btn-danger rounded-lg"> Log Out</button></a></span>
          <h5 class="text-info"><span class="text-success"> Request a Reimbursement</span> ${name} ${lname} | <span class="text-warning"> EmployeeID:${employeeId }</span>
          </h5>
        </div>
     
    
    </div>
<div class="row  justify-content-center pt-5">

    <div class="col"><h1 class="bg-info p-2 rounded-lg border border-light ">${name}'s Request History</h1>

   
    </div>

    <div class="col-sm-8 border border-dark p-3 rounded-lg bg-light">
    <span class="float-sm-left "><a href="application.jsp"><button class="btn btn-primary mb-2 mr-5 ">Go Back</button></a></span>
   		<table class="table table-dark table-striped table-sm p-3 rounded-lg">
   		 <thead>
                        <tr >
                        	<th scope="col">Request ID</th>
                        	<th scope="col">Created By</th>
                        	<th scope="col">Requested Amount</th>
                            <th scope="col">Vendor</th>
                            <th scope="col">Bank #</th>
                            <th scope="col">Routing #</th>
                            <th scope="col">Created On</th>
                            <th scope="col">Modified BY</th>
                            <th scope="col">Status</th>
                        </tr>
                    </thead>
                                 <% RequestLogic reqLogic = new RequestLogic();
                                 int employeeId= Integer.parseInt((String)request.getSession().getAttribute("employeeId"));
                                 for(Request req: reqLogic.getRequestsByEmployeeId(employeeId)){
                                	
                                	 %>   
                                	        <tr>
                    	 <th scope="row"><%= req.getRequestId() %></th>
                          <td><%= req.getCreatedBy()%></td>
                          <td><%=req.getRequestedAmount() %></td>
                          <td><%=req.getVendor() %></td>
                           <td><%=req.getBankNumber() %></td>
                          <td><%=req.getRoutingNumber() %></td>
                          <td><%=req.getCreatedOn() %></td>
                          <td><%= req.getModifiedBy()%></td>
                          <td><%= req.getIsApproved()%></td>
                   
                          
                          
             
                        </tr>	                                                              
                                 <%} %>
   							</table>
    </div>

    <div class="col"></div>

</div>



</div> 

</body>
</html>