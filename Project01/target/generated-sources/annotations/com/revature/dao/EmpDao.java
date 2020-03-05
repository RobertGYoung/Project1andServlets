package com.revature.dao;

import java.util.Set;

import com.revature.pojo.Employee;


public interface EmpDao{
    Employee getEmpById(int id);
    Set<Employee> getAllEmps();
   	Employee getEmpByEmailAndPassword(String username, String password);
    boolean insertEmp(Employee emp);
    boolean updateEmpInfo(Employee emp);
    
}

