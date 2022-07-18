package mas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mas.connection.ConnManager;
import mas.model.Umrah;

public class UmrahDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	String date, time, chapter, venue;
	String slotID;
	
	//insert new umrah slot
	public void addUmrah(Umrah bean) {
		slotID = bean.getSlotID();
		date = bean.getDate();
		time = bean.getTime();
		chapter = bean.getChapter();
		venue = bean.getVenue();
		
		try {
			//call getConnection() method
			con = ConnManager.getConnection();
			
			//3. create statement for slot
			//stmt = con.createStatement();
			ps = con.prepareStatement("INSERT INTO slot (id, slotID, slotTime, slotDate) VALUES (?, ?, ?, ?)");
			ps.setInt(1, bean.getSlot().getId());
			ps.setString(2, slotID);
			ps.setString(3, time);
			ps.setString(4, date);
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement
			ps = con.prepareStatement("INSERT into umrah(slotID, date, time, chapter, venue) VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, slotID);
			ps.setString(2, date);
			ps.setString(3, time);
			ps.setString(4, chapter);
			ps.setString(5, venue);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get all Umrah class
	public static List<Umrah> getAllUmrah(){
		List<Umrah> umslots = new ArrayList<Umrah>();
		try {
			//call getConnection() method
			con = ConnManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("SELECT * FROM umrah order by slotID");
			
			while(rs.next()) {
				Umrah um = new Umrah();
				um.setSlotID(rs.getString("slotID"));
				um.setDate(rs.getString("date"));
				um.setTime(rs.getString("time"));
				um.setChapter(rs.getString("chapter"));
				um.setVenue(rs.getString("venue"));
				umslots.add(um);
			}
			//5. close connection
			con.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return umslots;
	}
	
	//get umrah by slotid
	public static Umrah getUmrahById(String slotID) {
		Umrah um = new Umrah();
		try {
			//call getConnection() method
			con = ConnManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("SELECT * FROM umrah where slotID=?");
			ps.setString(1, slotID);
			//4. execute query
			rs = ps.executeQuery();
			
			if(rs.next()) {
				um.setSlotID(rs.getString("slotID"));
				um.setDate(rs.getString("date"));
				um.setTime(rs.getString("time"));
				um.setChapter(rs.getString("chapter"));
				um.setVenue(rs.getString("venue"));
			}
			//5. close connection
			con.close();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return um;
	}
	
	//update jumaat
	public void updateUmrah(Umrah bean) {
		slotID = bean.getSlotID();
		date = bean.getDate();
		time = bean.getTime();
		chapter = bean.getChapter();
		venue = bean.getVenue();
		
		try {
			//call getConnection() method 
			con = ConnManager.getConnection();
			//3. create statement for slot
			ps = con.prepareStatement("UPDATE slot SET slotTime=?, slotDate=? WHERE slotID=?");
			ps.setString(1, time);
			ps.setString(2, date);
			ps.setString(3, slotID);
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement
			ps = con.prepareStatement("UPDATE umrah SET date=?, time=?, chapter=?, venue=? WHERE slotID=?");
			ps.setString(1, date);
			ps.setString(2, time);
			ps.setString(3, chapter);
			ps.setString(4, venue);
			ps.setString(5, slotID);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			System.out.println("Slot with id " + slotID + " was successfully updated");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete jumaat
		public void deleteUmrah(String slotID) {
			try {
				//call getConnection() 
				con = ConnManager.getConnection();

				//3. create statement 
				ps=con.prepareStatement("DELETE from slot where slotID=?");
				ps.setString(1, slotID);
				
				//4. execute query
				ps.executeUpdate();
				
				//3. create statement 
				ps=con.prepareStatement("DELETE from umrah where slotID=?");
				ps.setString(1, slotID);
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
