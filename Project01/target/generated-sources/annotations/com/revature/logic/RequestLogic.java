package com.revature.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.connection.SingletonConnection;
import com.revature.dao.RequestDao;
import com.revature.pojo.Employee;
import com.revature.pojo.Request;

public class RequestLogic implements RequestDao {
	public boolean approvePendingRequest(int requestId, String name) {
		Connection conn=null;
		try {
			 conn = SingletonConnection.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE RREQUESTS SET ISAPPROVED=1, MODIFIEDBY=? WHERE REQUESTID=?");
			ps.setString(1, name);

			ps.setInt(2, requestId);
			

			int i = ps.executeUpdate();
			
			if(i==1) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
			return false;
		
	}
	public boolean denyPendingRequest(int requestId,String name) {
		Connection conn=null;
		try {
			 conn = SingletonConnection.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE RREQUESTS SET ISAPPROVED=0, MODIFIEDBY=? WHERE REQUESTID=?");
			ps.setString(1, name);

			ps.setInt(2, requestId);
			

			int i = ps.executeUpdate();
			
			if(i==1) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
			return false;
		
	}
	
	public Request getMostRecentRequest() {
		try {
			Connection conn = SingletonConnection.getInstance().getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RREQUESTS WHERE CREATEDON = (SELECT MAX (CREATEDON) FROM RREQUESTS)");
					
			while (rs.next()) {
				return pullReqFromResultSet(rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public Request getRequestByRequestId(int rId) {
		try {
			Connection conn = SingletonConnection.getInstance().getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RREQUESTS WHERE REIMBURSMENTID ="+rId);
			while (rs.next()) {
				return pullReqFromResultSet(rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public Set<Request> getRequestsByEmployeeId(int employeeId){
		try {
			Connection conn = SingletonConnection.getInstance().getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RREQUESTS WHERE EMPLOYEEID ="+employeeId);
			Set<Request>employeeRequests = new HashSet<Request>();
			while(rs.next()) {
				Request req = pullReqFromResultSet(rs);
				employeeRequests.add(req);
			}
			return employeeRequests;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;

	
	}
	 public Set<Request> getAllPendingRequests(){
	    	try {
				Connection conn = SingletonConnection.getInstance().getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM  RREQUESTS WHERE ISAPPROVED IS NULL");
				Set<Request>allRequests = new HashSet<Request>();
				while(rs.next()) {
					Request req = pullReqFromResultSet(rs);
					allRequests.add(req);
				}
				return allRequests;
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return null;
	    }
	 public Set<Request> getAllResolvedRequests(){
	    	try {
				Connection conn = SingletonConnection.getInstance().getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM  RREQUESTS WHERE ISAPPROVED = 1 OR ISAPPROVED = 0");
				Set<Request>allRequests = new HashSet<Request>();
				while(rs.next()) {
					Request req = pullReqFromResultSet(rs);
					allRequests.add(req);
				}
				return allRequests;
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return null;
	    }
    public Set<Request> getAllRequests(){
    	try {
			Connection conn = SingletonConnection.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM  RREQUESTS");
			Set<Request>allRequests = new HashSet<Request>();
			while(rs.next()) {
				Request req = pullReqFromResultSet(rs);
				allRequests.add(req);
			}
			return allRequests;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
    }
	private Request pullReqFromResultSet(ResultSet rs) throws SQLException {

		Request req = new Request();
		req.setEmployeeId(rs.getInt("EMPLOYEEID"));
		req.setRequestId(rs.getInt("REQUESTID"));
		req.setIsApproved(rs.getInt("ISAPPROVED"));
		req.setSpentAmount(rs.getInt("SPENTAMOUNT"));
		req.setRequestedAmount(rs.getInt("REIMBURSMENTAMOUNT"));
		req.setVendor(rs.getString("VENDOR"));
		req.setBankNumber(rs.getInt("BANKNUMBER"));
		req.setRoutingNumber(rs.getInt("ROUTINGNUMBER"));
		req.setCreatedBy(rs.getString("CREATEDBY"));
		req.setCreatedOn(rs.getString("CREATEDON"));
		req.setModifiedBy(rs.getString("MODIFIEDBY"));

		return req;

	}
    public boolean insertRequest(Request req, Employee emp) {
    	try {
			Connection conn = SingletonConnection.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO RREQUESTS (EMPLOYEEID, REASON,SPENTAMOUNT, REIMBURSMENTAMOUNT,VENDOR, BANKNUMBER, ROUTINGNUMBER, CREATEDBY) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1,emp.getEmployeeId());
			ps.setString(2,req.getReason());
			ps.setInt(3,req.getSpentAmount());
			ps.setInt(4,req.getRequestedAmount());
			ps.setString(5,req.getVendor());
			ps.setInt(6,req.getBankNumber());
			ps.setInt(7,req.getRoutingNumber());
			ps.setString(8,req.getCreatedBy());


			

			int i = ps.executeUpdate();
			if(i==1) {
				return true;
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    boolean updateRequestInfo(Request emp) {
    	
    }

}
