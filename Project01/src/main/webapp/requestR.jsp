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
          <h5 class="text-info"><span class="text-success"> Request a Reimbursement</span> ${name} ${lname} | <span class="text-warning"> EmployeeID:${employeeId }</span>
          </h5>
        </div>
     
    
    </div>

<div class="col-sm-8 border mx-auto border-dark p-3 mt-5 rounded-lg bg-light text-center ">
<h2 class="text-light bg-dark rounded-lg shadow-lg p-2" > <span class="float-sm-left "><a href="application.jsp"><button class="btn btn-primary mb-2 mr-5">Go Back</button></a></span>Make a Request</h2>
<form action="SRS">
  <div class="row">
   <div class="col">
      <input type="text" class="form-control" name="vendor" placeholder="Vendor " required>
    </div>
    <div class="col">
      <input type="number" min="0" class="form-control" name="spentAmount" placeholder="Amount Spent" required>
    </div>
    <div class="col">
      <input type="number" min="0" class="form-control" name="requestedAmount" placeholder="Amount Requested" required>
    </div>
  </div>
  <div class="row">
   <div class="col mt-3">
      <textarea class="form-control" name="reason" placeholder="Please provide details and reasons for expenditure" rows=3 maxlength=300></textarea>
    </div>
   
  </div>
  <div class="row mt-3">
  
   <div class="col">
      <input type="number" class="form-control" name="bankNumber" placeholder="Bank Account #" max="99999999" required>
    </div>
    <div class="col">
      <input type="number" class="form-control" name="routingNumber" placeholder="Routing #" max="99999999" required>
    </div>
  
  </div>
  <div class="row">
   <div class="col text-center">
  
    <input type="submit" class="btn m-3 btn-lg btn-success " value="Submit"/>
    </div>
  </div>
</form>

</div>


</div> 

</body>
</html>