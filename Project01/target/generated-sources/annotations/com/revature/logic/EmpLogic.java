package com.revature.logic;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.HashSet;
	import java.util.Set;

	import com.revature.connection.SingletonConnection;
	import com.revature.dao.EmpDao;
import com.revature.logging.LoggerClass;
import com.revature.pojo.Employee;

	public class EmpLogic {

		public Employee getEmployeeById(int id) {
			try {
				Connection conn = SingletonConnection.getInstance().getConnection();

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEEID ="+id);
				while (rs.next()) {
					return pullEmpFromResultSet(rs);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		private Employee pullEmpFromResultSet(ResultSet rs) throws SQLException {

			Employee emp = new Employee();
			emp.setEmployeeId(rs.getString("EMPLOYEEID"));
			emp.setName(rs.getString("NAME"));
			emp.setLastName(rs.getString("LASTNAME"));
			emp.setEmail(rs.getString("EMAIL"));
			emp.setCountry(rs.getString("COUNTRY"));
			emp.setStreetAddress(rs.getString("STREET"));
			emp.setCity(rs.getString("CITY"));
			emp.setZip(rs.getString("ZIP"));
			emp.setState(rs.getString("STATE"));
			emp.setPassWord(rs.getString("LOGINPASS"));
			emp.setIsAdmin(rs.getInt("ISADMIN"));
			return emp;

		}
		
		public Employee getEmpByEmailAndPassword(String email, String password) {
			try {
				Connection conn = SingletonConnection.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMAIL =? AND LOGINPASS=?");
				ps.setString(1, email);
				ps.setString(2, password);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					System.out.println("found");
					LoggerClass.mainLogger.trace("Pulling Employees in pojo..");
					return pullEmpFromResultSet(rs);
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Set<Employee> getAllUEmployees(){
			try {
			Connection conn = SingletonConnection.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
			Set<Employee>allEmployees = new HashSet<Employee>();
			while(rs.next()) {
				Employee emp = pullEmpFromResultSet(rs);
				allEmployees.add(emp);
			}
			return allEmployees;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		public boolean insertUser(Employee emp) {
			try {
				Connection conn = SingletonConnection.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEES (EMAIL,LOGINPASS,NAME,LASTNAME) VALUES (?,?,?,?)");
				ps.setString(1,emp.getEmail());
				ps.setString(2,emp.getPassWord());
				ps.setString(3,emp.getName());
				ps.setString(4,emp.getLastName());

				int i = ps.executeUpdate();
				if(i==1) {
					return true;
				}
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean updateEmployeeInfo(Employee emp) {
			//update pojo then execute
			Connection conn=null;
			try {
				 conn = SingletonConnection.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEES SET NAME=?,LASTNAME=?,EMAIL=?,STREET=?,CITY=?,STATE=?,COUNTRY=?,ZIP=? WHERE EMPLOYEEID=?");
				ps.setString(1, emp.getName());
				ps.setString(2, emp.getLastName());
				ps.setString(3, emp.getEmail());
				ps.setString(4, emp.getStreetAddress());
				ps.setString(5, emp.getCity());
				ps.setString(6, emp.getState());
				ps.setString(7, emp.getCountry());
				ps.setString(8, emp.getZip());
				ps.setInt(9, Integer.parseInt(emp.getEmployeeId()));

				int i = ps.executeUpdate();
				
				if(i==1) {
					return true;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
				return false;
			
		}

}
