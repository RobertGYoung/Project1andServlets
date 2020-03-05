package com.revature.logic;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.revature.pojo.Student;

@Path("/students")
public class RestXmlService {
@GET 
@Path("/{id}")
@Produces(MediaType.APPLICATION_XML)
	public Student getStudentDetails(@PathParam("id") int stuId) {
		
		Student stu =new Student();
		stu.setStuCity("Philly");
		stu.setStuId(stuId);
		stu.setStuName("Frank");
		return stu;
	}
	
}
