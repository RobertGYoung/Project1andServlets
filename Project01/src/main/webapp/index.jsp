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
    <%request.getSession().invalidate();
    %>
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
    <div class="col text-light"><h1 style="text-shadow:-5px 5px 30px black">Welcome</h1>
   
    </div>

    <div class="col-sm-6 px-5 shadow-lg rounded-lg bg-dark">
    
      <div class="m-5 border border-dark p-2 rounded-lg bg-light shadow">
   	<h3>Current Employees</h3><div class=""><a href="login.jsp"><button class=" btn btn-primary btn-lg m-2">Login</button></a></div> 
    </div>
     <div class="m-5 border border-dark p-2 rounded-lg bg-warning">
    <h3>Are You New Here?</h3><a href="register.jsp"><button class="btn btn-success btn-lg m-2 ">Register</button></a></div>

	
    </div>

    <div class="col"></div>

</div>



</div> 




</body>
</html>