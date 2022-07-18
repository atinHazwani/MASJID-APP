package mas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mas.connection.ConnManager;
import mas.model.UserAcc;

public class UserAccDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement ps = null;
	String userID;
	String password;
	String role;
	
	//login users
	public String authenticateUser(UserAcc bean){
	    userID = bean.getUserID();
	    password = bean.getPassword();
	 
	    String userIDDB = "";
	    String passwordDB = "";
	    String roleDB = "";
	 
	    try{
	        con = ConnManager.getConnection();
	        stmt = con.createStatement();
	        rs = stmt.executeQuery("SELECT userID, password, role FROM useracc");
	 
	        while(rs.next()){
	        	userIDDB = rs.getString("userID");
	            passwordDB = rs.getString("password");
	            roleDB = rs.getString("role");
	 
	            if(userID.equals(userIDDB) && password.equals(passwordDB) && roleDB.equals("admin"))
	            return "Admin_Role";
	            else if(userID.equals(userIDDB) && password.equals(passwordDB) && roleDB.equals("user"))
	            return "User_Role";
	        }
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
	    return "Invalid user credentials";
	}
	
	//Register users (tak termasuk admin)
	public String registerUser(UserAcc bean)
    {
        String userID = bean.getUserID();
        String username = bean.getUsername();
        String password = bean.getPassword();
        String role = bean.getRole();
        
        Connection con = null;
        PreparedStatement preparedStatement = null;   
        
        try
        {
            con = ConnManager.getConnection();
            
            String query = "insert into userAcc(userID, username, password, role) values (?,?,?,?)"; //Insert user details into the table 'userAcc'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, role);
            
            int i= preparedStatement.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
	
	
	
	
	
	
	//add user
	public void addUserAcc(UserAcc bean) {
		
		//get RegUser
		userID = bean.getUserID();
		password = bean.getPassword();
		role = bean.getRole();

		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("INSERT INTO useracc (userID, password, role) VALUES (?, ?, ?)");
			ps.setString(1, userID);
			ps.setString(2, password);
			ps.setString(3, role);
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement
			ps = con.prepareStatement("INSERT INTO reguser (userID, userName, userEmail, userPhone, userAddress) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, userID);
			ps.setString(2, bean.getReguser().getUserName());
			ps.setString(3, bean.getReguser().getUserEmail());
			ps.setString(4, bean.getReguser().getUserPhone());
			ps.setString(5, bean.getReguser().getUserAddress());
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement
			ps = con.prepareStatement("INSERT INTO admin (userID, adminName, adminEmail, adminPhone) VALUES (?, ?, ?, ?)");
			ps.setString(1, userID);
			ps.setString(2, bean.getAdmin().getAdminName());
			ps.setString(3, bean.getAdmin().getAdminEmail());
			ps.setString(4, bean.getAdmin().getAdminPhone());
			
			//4. execute query
			ps.executeUpdate();
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get product by id
	public static UserAcc getUserAccByID(String userID) {
		UserAcc userAcc = new UserAcc();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "SELECT * FROM useracc WHERE userID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				userAcc.setUserID(rs.getString("userID"));
				userAcc.setPassword(rs.getString("password"));
				userAcc.setRole(rs.getString("role"));
			}
			
			//5.close connection
			//con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userAcc;
	}
	
	//get id only
		public static UserAcc getUserAccID(String userID) {
			UserAcc userAcc = new UserAcc();
			
			try {
				//call getConnection() method from ConnectionManager class
				con = ConnManager.getConnection();
				
				//3. create statement
				//stmt = con.createStatement();
				String sql = "SELECT userID FROM useracc WHERE userID=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, userID);
				
				//4. execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					userAcc.setUserID(rs.getString("userID"));
				}
				
				//5.close connection
				//con.close();
				 
			}catch(Exception e) {
				e.printStackTrace();
			}
			return userAcc;
		}
	
	
	//get all product
	public static List<UserAcc> getAllUserAcc(){
		List<UserAcc> users = new ArrayList<UserAcc>();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "SELECT * FROM useracc ORDER BY userID";
			stmt = con.createStatement();
						
			//4. execute query
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				UserAcc user = new UserAcc();
				user.setUserID(rs.getString("userID"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				users.add(user);
			}
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
		
		
	}
	
	
	//update user
	public void updateUserAcc(UserAcc bean) {
		
		//get product
		userID = bean.getUserID();
		password = bean.getPassword();
		role = bean.getRole();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("UPDATE useracc SET password=?, role=? WHERE userID=?");
			ps.setString(1, password);
			ps.setString(2, role);
			ps.setString(3, userID);		
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement
			ps = con.prepareStatement("UPDATE reguser SET userName=?, userEmail=?, userPhone=?, userAddress=? WHERE userID=?");
			ps.setString(1, bean.getReguser().getUserName());
			ps.setString(2, bean.getReguser().getUserEmail());
			ps.setString(3, bean.getReguser().getUserPhone());
			ps.setString(4, bean.getReguser().getUserAddress());
			ps.setString(5, userID);		
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement
			ps = con.prepareStatement("UPDATE admin SET adminName=?, adminEmail=?, adminPhone=? WHERE userID=?");
			ps.setString(1, bean.getAdmin().getAdminName());
			ps.setString(2, bean.getAdmin().getAdminEmail());
			ps.setString(3, bean.getAdmin().getAdminPhone());
			ps.setString(4, userID);		
			
			//4. execute query
			ps.executeUpdate();
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete user
	public void deleteUserAcc(String userID) {
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("DELETE FROM useracc WHERE userID=?");
			ps.setString(1, userID);
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement
			ps = con.prepareStatement("DELETE FROM reguser WHERE userID=?");
			ps.setString(1, userID);
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement
			ps = con.prepareStatement("DELETE FROM admin WHERE userID=?");
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
