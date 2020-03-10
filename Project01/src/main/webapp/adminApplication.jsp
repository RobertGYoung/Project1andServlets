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
        <!--  session vars:	session.setAttribute("currentUser", emp);
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
		session.setAttribute("isAdmin", isAdmin);  -->
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <style>
        body{
            background-color: grey;
        }
    </style>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <body>
 <div class="container-fluid p-0"> 

      <div class="row bg-dark p-5 text-light">
      
        <div col="col-sm-5 mx-auto  justify-content-center">
             <h1>Company Reimbursement System </h1>
   		<span><a href="index.jsp"><button class="col-sm-2 mx-1 m-2 p-2 float-sm-right btn btn-lg btn-danger rounded-lg"> Log Out</button></a></span>
          <h5 class="text-info">Welcome ${name} ${lname} | <span class="text-warning"> Administrator</span>
          </h5>
        </div>
     
   <div class=" container-fluid"> 
        
              <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                  <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="request-tab" data-toggle="tab" href="#request" role="tab" aria-controls="request" aria-selected="false">Employees</a>
                </li>
             
                <li class="nav-item">
                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false">Request History</a>
                  </li>
              
               
              </ul>
             
            
            

<div class="tab-content" id="myTabContent">                  <!--                                                    -->
    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
        <header><h1>HOME</h1>
        </header><hr>
        <div class="bg-light p-5 rounded-lg">
       <p class="m-5 text-dark">The above tabs allow you to see all employees, search for an employee and their associated requests, view history of all requests, see all pending requests to approve or deny.</p>
    </div>      </div>
    
    
                                                            <!--                                                    -->
    <div class="tab-pane fade" id="request" role="tabpanel" aria-labelledby="request-tab">
        <header><h1>Employees</h1></header><hr>
		
	<div >
		<div>
		<input type="text" placeholder="Employee Name" name="search"/>
		<input type="submit" class="btn btn-primary"/>
		</div>
			List of all employees:
				<table class="table table-dark table-striped table-sm">
                                 <% EmpLogic empLogic = new EmpLogic();
                                 for(Employee emp: empLogic.getAllUEmployees()){
                                	
                                	 %>   
                                	        <tr>
                    	 <th scope="row"><%= emp.getEmployeeId() %></th>
                          <td><%= emp.getName()%></td>
                          <td><%=emp.getLastName() %></td>
                          <td><%=emp.getStreetAddress() %></td>
                          <td><%= emp.getCity()%></td>
                          <td><%= emp.getState()%></td>
                           <td><%=emp.getZip() %></td>
                          <td><%=emp.getCountry() %></td>
                          <td><%=emp.getIsAdmin() %></td>
                          <td><%= emp.getEmail()%></td>
                   
                          
                          
                          <td><button type="submit" class="btn btn-primary">Details</button>
                        </tr>	                                                              
                                 <%} %>
   							</table>
			
			</div>
                  </div>                          	                <!--                                                    -->
   

         <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
        <header><h1>Request History</h1>
        </header><hr>
    

        <!--  acordian - has form elements in it-->
        <div class="accordion" id="accordionExample">
                   <div class="card">
              <div class="card-header" id="headingOne">
                <h2 class="mb-0">
                  <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    All Requests
                  </button>
                </h2>
              </div>
          
              <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body text-dark">
                List of all Requests:
               
			<table class="table table-hover bg-light table-sm table-striped">
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
                                 for(Request req: reqLogic.getAllRequests()){
                                	
                                	 %>   
                                	        <tr class="border">
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
                </div>
              </div>
            <div class="card">
              <div class="card-header" id="headingTwo">
                <h2 class="mb-0">
                  <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
	                    Pending Requests
                  </button>
                </h2>
              </div>
              <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo" data-parent="#accordionExample">
                <div class="card-body">
<table class="table table-hover bg-light">
                    <thead>
                        <tr >
                        	<th scope="col">Request ID</th>
                        	<th scope="col">Created By</th>
                        	<th scope="col">Requested Amount</th>
                            <th scope="col">Vendor</th>
                            <th scope="col">Bank #</th>
                            <th scope="col">Routing #</th>
                            <th scope="col">Created On</th>
                           
                           
                        </tr>
                    </thead>
 
                                 <% 
                                 for(Request req: reqLogic.getAllPendingRequests()){
                                	
                                	 %>   
                                	       <tr class="border">
                    	 <th scope="row"><%= req.getRequestId() %></th>
                          <td><%= req.getCreatedBy()%></td>
                          <td><%=req.getRequestedAmount() %></td>
                          <td><%=req.getVendor() %></td>
                           <td><%=req.getBankNumber() %></td>
                          <td><%=req.getRoutingNumber() %></td>
                          <td><%=req.getCreatedOn() %></td>
                         
                          
                          
                          		
                          <td> <form action="ARS"><button type="submit" class="btn btn-primary" value ="<%=req.getRequestId()%>" name="details">:)</button></form></td>
                 		  <td> <form action="RRS"><button type="submit" class="btn btn-danger" value ="<%=req.getRequestId()%>" name="details">X</button></form></td>
                          
                        </tr>	                                                              
                                 <%} %>
   							</table>               
   							 </div>
              </div>
            </div>
            <div class="card">
              <div class="card-header" id="headingThree">
                <h2 class="mb-0">
                  <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    Resolved Requests
                  </button>
                </h2>
              </div>
              <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                       <div class="card-body">
<table class="table table-hover bg-light">
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
 
                                 <% 
                                 for(Request req: reqLogic.getAllResolvedRequests()){
                                	
                                	 %>   
                                	        <tr class="border">
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
              </div>
            </div>
          </div>
    
    
    </div>
      
  </div>
                                                             <!--                                                    -->
</div> 



</div> 
</div>
</body>
</html>
       
