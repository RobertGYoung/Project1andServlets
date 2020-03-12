<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<% if(response.getStatus() >= 500){ %>
<font color="red"><h6 class="ml-5">Wrong email or password</h6> </font><br>

<%} %> 
<% if(response.getStatus() == 200){ %>
<p style="color:green"><p>

<%} %> 


