<%@page import="com.revature.logic.EmpLogic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page isELIgnored="false"%>  
        
   
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

    <div class="col">

   
    </div>

    <div class="col-sm-8 border border-dark p-3 rounded-lg bg-info"><span class="float-sm-left "><a href="application.jsp"><button class="btn btn-primary mb-2 mr-5">Go Back</button></a></span>
   		<form action="UUS">
   		<br><br>
   	<div class="form-group">
    <label for="email"> Email: </label>
    <input type="email" class="form-control" id="email" placeholder="${email}" name="email" aria-describedby="email">
   
  </div>
  <div class="form-group">
    <label for="firstName">First Name:</label>
    <input type="text" class="form-control" placeholder="${name}"name="name" id="firsName">
  </div>
    <div class="form-group">
    <label for="lastName">Last Name:</label>
    <input type="text" class="form-control" name="lastName" placeholder=" ${lname }" id="lastName">
  </div>
    <div class="form-group">
    <label for="street">Street Address:</label>
    <input type="text" class="form-control" name="street" placeholder= "${street}" id="street">
  </div>
    <div class="form-group">
    <label for="city"><strong>City:</strong></label>
    <input type="text" class="form-control" placeholder= "${city}" name="city" id="city">
  </div>
    <div class="form-group">
    <label for="state">State: </label>
    <input type="text" class="form-control" name="state" placeholder="${state}" id="state">
  </div>
    <div class="form-group">
    <label for="zip">Zip:</label>
    <input type="text" class="form-control" name="zip" placeholder=" ${zip}"id="zip">
  </div>
   <div class="form-group">
    <label for="zip">Country:</label> 
    <input type="text" class="form-control" name="country" placeholder=" ${country} " id="country">
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
   		</form>
    </div>

    <div class="col"></div>

</div>



</div> 

</body>
</html>