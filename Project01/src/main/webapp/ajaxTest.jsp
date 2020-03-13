<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
<head>  
<meta content="text/html; charset=utf-8">  
<title>AJAX JSON API TEST THROUGH XMLHttpRequest</title>  
<script type="application/javascript">  
function load()  
{  
    alert('inside load');
   var url = "http://localhost:8081/Project01/rest/requests/1001";//use any url that have json data  
   var request;  
   if(window.XMLHttpRequest){    
    request=new XMLHttpRequest();//for Chrome, mozilla etc  
   }    
   else if(window.ActiveXObject){    
    request=new ActiveXObject("Microsoft.XMLHTTP");//for IE only  
   }    
   request.onreadystatechange  = function(){  
      if (request.readyState == 4  )  
      {  
       /* var jsonObj = JSON.parse(request.responseText);//JSON.parse() returns JSON object  
        document.getElementById("date").innerHTML =  jsonObj.stuName;  
        document.getElementById("time").innerHTML = jsonObj.stuCity;  */
        
    	  var jsonObj = JSON.parse(request.responseText);//JSON.parse() returns JSON object  
          document.getElementById("date").innerHTML =  jsonObj[0].requestId;  
          document.getElementById("time").innerHTML = jsonObj[1].requestId;  
      }  
   }  
   request.open("GET", url, true);  
   request.send();  
}  
</script>  
</head>  
<body>  
Date: <span id="date"></span><br/>  
Time: <span id="time"></span><br/>  
<button type="button" onclick="load()">Load Information</button>  
</body>  
</html> 