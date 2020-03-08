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

    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-8 mx-auto">
          <h1>Company Reimbursement System</h1>
          <h3 class="ml-5"> You've Success Fully Updated Your Info, ${name} ${lname}!</h3>
        </div>
        <div class="col-sm-2"></div>
    
    </div>
<div class="row  justify-content-center pt-5">

    <div class="col"><h1>Current Info</h1>
		
   
    </div>

    <div class="col-sm-8 border border-dark p-3 rounded-lg bg-info">
    	<div class="bg-light p-3 rounded-lg" >
		<table class="ml-5">
		<tr><th  ><u><h3>YOUR INFO</h3></u></th><tr>
		<tr><td><u><strong>Name:</strong></u></td><td>${name}</td><tr>
		<tr><td><u><strong>Last Name:</strong></u></td><td>${lname}</td><tr>
		<tr><td><u><strong>Email:</strong></u></td><td>${email}</td><tr>
		<tr><td><u><strong>Street Address:</strong></u></td><td>${street}</td><tr>
		<tr><td><u><strong>City:</strong></u></td><td>${city}</td><tr>
		<tr><td><u><strong>State:</strong></u></td><td>${state}</td><tr>
		<tr><td><u><strong>ZIP:</strong></u></td><td>${zip}</td><tr>
		</table>
		</div>
		<a href="application.jsp"><button class="btn btn-lg btn-success m-5 rounded-lg border-dark"  >Back to Main Page</button></a>
    </div>
	
    <div class="col"></div>

</div>



</div> 

</body>
</html>