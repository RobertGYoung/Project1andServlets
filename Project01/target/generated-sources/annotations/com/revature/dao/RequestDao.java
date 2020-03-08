package com.revature.dao;

import java.util.Set;

import com.revature.pojo.Request;

public interface RequestDao {
	Request getRequestByRequestId(int rId);
	Set<Request> getRequestsByEmployeeId(int employeeId);
    Set<Request> getAllRequests();
    boolean insertRequest(Request emp);
    boolean updateRequestInfo(Request emp);
}
