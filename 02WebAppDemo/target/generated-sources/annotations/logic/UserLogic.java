package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.connection.SingletonConnection;
import com.revature.dao.UserDao;
import com.revature.pojo.User;

public class UserLogic implements UserDao{

	public User getUserById(int id) {
		try {
			Connection conn = SingletonConnection.getInstance().getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM servlettest WHERE USERID = 1");
			while (rs.next()) {
				return pullUserFromResultSet(rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private User pullUserFromResultSet(ResultSet rs) throws SQLException {

		User user = new User();
		user.setId(rs.getInt("USERID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setUserName(rs.getString("USERNAME"));

		return user;

	}
	
	public User getUserByUserNameAndPassword(String username, String password) {
		try {
			Connection conn = SingletonConnection.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM servlettest WHERE USERNAME =? AND PASSWORD=?");
			ps.setString(1,username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return pullUserFromResultSet(rs);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Set<User> getAllUsers(){
		try {
		Connection conn = SingletonConnection.getInstance().getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM servlettest");
		Set<User>allUsers = new HashSet<User>();
		while(rs.next()) {
			User user = pullUserFromResultSet(rs);
			allUsers.add(user);
		}
		return allUsers;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean insertUser(User user) {
		try {
			Connection conn = SingletonConnection.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO servlettest (USERNAME,PASSWORD) VALUES (?,?)");
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getPassword());
			
			int i = ps.executeUpdate();
			if(i==1) {
				return true;
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateUserInfo(User user) {
		//update pojo then execute
		Connection conn=null;
		try {
			 conn = SingletonConnection.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE servlettest SET USERNAME=?,PASSWORD=? WHERE USERID=?");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getId());

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
