package com.revature.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
@XmlRootElement(name="student")
public class Student {

	String stuName;
	String stuCity;
	int stuId;
	
	@XmlElement
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	@XmlElement

	public String getStuCity() {
		return stuCity;
	}
	
	public void setStuCity(String stuCity) {
		this.stuCity = stuCity;
	}
	@XmlAttribute
	public int getStuId() {
		return stuId;
	}
	
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	
	
}
