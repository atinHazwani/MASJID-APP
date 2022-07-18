package mas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mas.connection.ConnManager;
import mas.model.BookedSlot;

public class BookedSlotDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement ps = null;
	int bookID;
	String slotID;
	String userID;
	String bookDate;
	
	//add product
	public void addBookedSlot(BookedSlot bean) {
		
		//get RegUser
		bookID = bean.getBookID();
		slotID = bean.getSlotID();
		userID = bean.getUserID();
		bookDate = bean.getBookDate();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = mas.connection.ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "INSERT INTO bookedslot (slotID, userID, bookDate) VALUES (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, slotID);
			ps.setString(2, userID);
			ps.setString(3, bookDate);
			
			//4. execute query
			ps.executeUpdate();
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get product by id
	public static BookedSlot getBookedSlotByID(int bookID) {
		BookedSlot bookedSlot = new BookedSlot();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "SELECT * FROM bookedslot WHERE bookID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookID);
			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				bookedSlot.setBookID(rs.getInt("bookID"));
				bookedSlot.setSlotID(rs.getString("slotID"));
				bookedSlot.setUserID(rs.getString("userID"));
				bookedSlot.setBookDate(rs.getString("bookDate"));

			}
			
			//5.close connection
			//con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookedSlot;
	}
		
	
	
	//get all product
	public static List<BookedSlot> getAllBookedSlot(){
		List<BookedSlot> bookedSlots = new ArrayList<BookedSlot>();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "SELECT * FROM bookedSlot ORDER BY bookID";
			stmt = con.createStatement();
						
			//4. execute query
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BookedSlot bookedSlot = new BookedSlot();
				bookedSlot.setBookID(rs.getInt("bookID"));
				bookedSlot.setSlotID(rs.getString("slotID"));
				bookedSlot.setUserID(rs.getString("userID"));
				bookedSlot.setBookDate(rs.getString("bookDate"));
				bookedSlots.add(bookedSlot);
			}
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookedSlots;
		
		
	}
	
	
	//update product
	public void updateBookedSlot(BookedSlot bean) {
		
		//get product
		bookID = bean.getBookID();
		slotID = bean.getSlotID();
		userID = bean.getUserID();
		bookDate = bean.getBookDate();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql = "UPDATE bookedslot SET bookID=?, slotID=?, userID=?, feedbackDesc=? WHERE feedbackID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, slotID);
			ps.setString(2, userID);
			ps.setString(3, bookDate);
			ps.setInt(5, bookID);		
			
			//4. execute query
			ps.executeUpdate();
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete product
	public void deleteBookedSlot(int bookID) {
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnManager.getConnection();
			
			//3. create statement
			//stmt = con.createStatement();
			String sql1 = "DELETE FROM bookedslot WHERE bookID=?";
			//String sql2 = "DELETE FROM useracc WHERE userID=?";
			ps = con.prepareStatement(sql1);
			ps.setInt(1, bookID);
			
			//4. execute query
			ps.executeUpdate();
			
			//5.close connection
			con.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
