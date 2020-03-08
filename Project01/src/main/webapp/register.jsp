<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

    <div class="row bg-dark p-5 text-success">
        <div col="col-sm-2"></div>
        <div col="col-8 mx-auto">
          <h1>Company Reimbursment System</h1>
        </div>
        <div col="col-sm-2"></div>
    
    </div>
<div class="row  justify-content-center pt-5">
    <div class="col"><h1>Register</h1>
    
    </div>

    <div class="col-sm-8 border border-dark p-5 rounded-lg bg-info">
        <form action="RUS">
          <div class="form-group row mx-sm-3">
              <label for="name" class="col-sm-2 col-form-label"><h5>First Name</h5></label>
                 <div class="col-sm-7 ml-4">
                  <input type="text" class="form-control " id="name" name="name">
              </div>
         </div>
            <div class="form-group row mx-sm-3">
              <label for="lname" class="col-sm-2 col-form-label"><h5>Last Name</h5></label>
              <div class="col-sm-7 ml-4">
                <input type="text" class="form-control " id="lname" name="lname">
              </div>
              </div>
     
            <div class="form-group row mx-sm-3">
              <label for="email" class="col-sm-2 col-form-label"><h5>Enter Your Email</h5></label>
              <div class="col-sm-7 ml-4">
                <input type="text" class="form-control " id="email" name="email">
              </div>
            </div>

            <div class="form-group row mx-sm-3">
              <label for="inputPassword" class="col-sm-2 col-form-label"><h6>Create Password</h6></label>
              <div class="col-sm-7 ml-4">
                <input type="password" class="form-control" name="password" id="inputPassword">
              </div>
             
            </div><div class="form-group row mx-sm-3">
              <label for="validatePassword" class="col-sm-2 col-form-label"><h5>Re-Enter Password</h5></label>
              <div class="col-sm-7 ml-4">
                <input type="password" class="form-control" name="validatePassword" id="validatePassword">
              </div>
             
            </div>
            <input type="submit" class="btn-primary" value="register"/>

          </form>

    </div>

    <div class="col"></div>

</div>



</div> 


<script>
document.getElementById("submitButton").addEventListener("click",function(){
    console.log("submit button has been clicked");

});

</script>

</body>
</html>