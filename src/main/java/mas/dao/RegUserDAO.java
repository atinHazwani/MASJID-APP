package mas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mas.connection.ConnManager;
import mas.model.RegUser;

public class RegUserDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement ps = null;
	String userID;
	String userName;
	String userEmail;
	String userPhone;
	String userAddress;
	
	//add product
	public void addRegUser(RegUser bean) {
		
		//get RegUser
		userID = bean.getUserID();
		userName = bean.getUserName();
		userEmail = bean.getUserEmail();
		userPhone = bean.getUserPhone();
		userAddress = bean.getUserAddress();
		try {
			//call getConnection() method from ConnectionManager class
			con = mas.connection.ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "INSERT INTO reguser (userID, userName, userEmail, userPhone, userAddress) VALUES (?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, userName);
			ps.setString(3, userEmail);
			ps.setString(4, userPhone);
			ps.setString(5, userAddress);
			
			//4. execute query
			ps.executeUpdate();
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get product by id
	public static RegUser getRegUserByID(String userID) {
		RegUser user = new RegUser();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "SELECT * FROM reguser WHERE userID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				user.setUserID(rs.getString("userID"));
				user.setUserName(rs.getString("userName"));
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserPhone(rs.getString("userPhone"));
				user.setUserAddress(rs.getString("userAddress"));
			}
			
			//5.close connection
			//con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
		
	
	
	//get all product
	public static List<RegUser> getAllRegUsers(){
		List<RegUser> users = new ArrayList<RegUser>();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "SELECT * FROM reguser ORDER BY userID";
			stmt = con.createStatement();
						
			//4. execute query
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				RegUser user = new RegUser();
				user.setUserID(rs.getString("userID"));
				user.setUserName(rs.getString("userName"));
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserPhone(rs.getString("userPhone"));
				user.setUserAddress(rs.getString("userAddress"));
				users.add(user);
			}
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
		
		
	}
	
	
	//update product
	public void updateRegUser(RegUser bean) {
		
		//get product
		userID = bean.getUserID();
		userName = bean.getUserName();
		userEmail = bean.getUserEmail();
		userPhone = bean.getUserPhone();
		userAddress = bean.getUserAddress();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "UPDATE reguser SET userName=?, userEmail=?, userPhone=?, userAddress=? WHERE userID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userEmail);
			ps.setString(3, userPhone);
			ps.setString(4, userAddress);
			ps.setString(5, userID);		
			
			//4. execute query
			ps.executeUpdate();
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete product
	public void deleteRegUser(String userID) {
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql1 = "DELETE FROM reguser WHERE userID=?";
			//String sql2 = "DELETE FROM useracc WHERE userID=?";
			ps = con.prepareStatement(sql1);
			ps.setString(1, userID);
			
			//4. execute query
			ps.executeUpdate();
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
