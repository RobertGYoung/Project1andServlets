<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page isELIgnored="false"%>  
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
 <div class="container p-0"> 

      <div class="row bg-dark p-5 text-light">
      
        <div col="col-sm-5 mx-auto  justify-content-center">
             <h1>Company Reimbursement System </h1>
   		<span><a href="index.jsp"><button class="col-sm-2 mx-1 m-2 p-2 float-sm-right btn btn-lg btn-danger rounded-lg"> Log Out</button></a></span>
          <h5 class="text-info">Welcome ${name} ${lname} | <span class="text-warning"> EmployeeID:${employeeId }</span>
          </h5>
        </div>
     
    
    </div>
<div class="row pt-5">

    <div class="col">

   
    </div>
	
    <div class="col-sm-8 border mx-auto border-dark p-3 rounded-lg bg-light "><div class="ml-5"><div class="ml-5">
   		<a href="requestR.jsp"><button class="col-sm-2 mx-3 p-1 ml-4 btn btn-lg btn-dark rounded-lg p5"> Make Request</button></a> 
   		<a href="viewRequests.jsp"><button class="col-sm-2 mx-2 p-1 btn btn-lg btn-dark rounded-lg p5"> View History</button>	</a> 
   		<a href="updateInfo.jsp"><button class="col-sm-2 mx-3 p-1  btn btn-lg btn-dark rounded-lg p5"> Update Info</button>	</a> 
   		    </div></div></div>
   		    

    <div class="col"></div>

</div>



</div> 

</body>
</html>