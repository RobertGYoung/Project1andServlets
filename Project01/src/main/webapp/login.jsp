
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

  <div class="row bg-dark p-5 text-success">
        <div col="col-sm-2"></div>
        <div col="col-8 mx-auto">
          <h1>Company Reimbursment System</h1>
        </div>
        <div col="col-sm-2"></div>
    
    </div>
<div class="row  justify-content-center pt-5">
    <div class="col"><h1 class="text-light" style="text-shadow: 5px 5px 10px black">Login</h1>
    
    </div>

    <div class="col-sm-8 border border-dark p-5 rounded-lg bg-info shadow">
        <form action="LUS" method="post">
            <div class="form-group row mx-sm-3">
              <label for="email" class="col-sm-2 col-form-label mr-4"><h5>Email</h5></label>
              <div class="col-sm-7">
                <input type="text" class="form-control " placeholder="Enter your email here" id="email" name="email" required
                data-bv-notempty-message="The email is required">
              </div>
            </div>
            <div class="form-group row mx-sm-3">
              <label for="inputPassword" class="col-sm-2 col-form-label mr-4"><h5>Password</h5></label>
              <div class="col-sm-7">
                <input type="password" class="form-control" placeholder="Enter a password" id="inputPassword" name="password" required
                data-bv-notempty-message="The username is required">
              </div>
             <%@ include file="error.jsp"
             %>
             <%if((String)request.getSession().getAttribute("success")=="0"){ %>
             <div style="color:red"><h6 class="ml-5">You do not administrator privileges</h6></div>
             <%} %>
            </div>
            <span class="invisible">xxxxxxxxxxxxxxxx</span>
     <div class="btn-group btn-group-toggle mx-sm-5 " data-toggle="buttons">
       <label class="btn btn-secondary text-success font-weight-bold active mr-3" for="userRadio">
                <input  type="radio" name="loginRadios" id="userRadio" value="employee" autocomplete="off" checked>
              
                  As Employee
                </label>
            
                <label class=" btn btn-secondary font-weight-bold text-warning" for="adminRadio">
                <input  type="radio" name="loginRadios" id="adminRadio" value="admin" autocomplete="off">
              
                  As Administrator
                </label>
               </div>
              
             <input type="submit" class=" float-sm-right btn btn-success border mt-5 border-light" value="Login"/>

          </form><span class="float-sm-left "><a href="index.jsp"><button class="btn btn-primary mb-2 mt-1 mr-5 border border-light">Go Back</button></a></span>

    </div>

    <div class="col"></div>

</div>



</div> 




</body>
</html>