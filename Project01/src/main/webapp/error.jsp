<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<% if(response.getStatus() >= 500){ %>
<font color="red" class="text-center ml-5"><h6 class="ml-5">Wrong email or password or session has ended</h6> </font><br>

<%} %> 
<% if(response.getStatus() == 200){ %>
<p style="color:green"><p>

<%} %> 


