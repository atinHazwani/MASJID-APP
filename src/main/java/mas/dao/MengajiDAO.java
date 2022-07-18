package mas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mas.connection.ConnManager;
import mas.model.Mengaji;

public class MengajiDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	String date, time, guruname, venue;
	String slotID;
	
	//insert new mengaji slot
	public void addMengaji(Mengaji bean) {
		slotID = bean.getSlotID();
		date = bean.getDate();
		time = bean.getTime();
		guruname = bean.getGuruname();
		venue = bean.getVenue();
		
		try {
			//call getConnection() method
			con = ConnManager.getConnection();
			
			//3. create statement for slot
			//stmt = con.createStatement();
			ps = con.prepareStatement("INSERT INTO slot (id, slotID, slotTime, slotDate) VALUES(?, ?, ?, ?)");
			ps.setInt(1, bean.getSlot().getId());
			ps.setString(1, slotID);
			ps.setString(2, time);
			ps.setString(3, date);
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement
			ps = con.prepareStatement("INSERT into mengaji (slotID, date, time, guruname, venue) VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, slotID);
			ps.setString(2, date);
			ps.setString(3, time);
			ps.setString(4, guruname);
			ps.setString(5, venue);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	//get all Mengaji Class
	public static List<Mengaji> getAllMengaji(){
		List<Mengaji> mcslots = new ArrayList<Mengaji>();
		try {
			//call getConnection() method
			con = ConnManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("SELECT * FROM mengaji order by slotID");
			
			while(rs.next()) {
				Mengaji mc = new Mengaji();
				mc.setSlotID(rs.getString("slotID"));
				mc.setDate(rs.getString("date"));
				mc.setTime(rs.getString("time"));
				mc.setGuruname(rs.getString("guruname"));
				mc.setVenue(rs.getString("venue"));
				mcslots.add(mc);
			}
			//5. close connection
			con.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return mcslots;
	}
	
	//get mengaji by slotid
	public static Mengaji getMengajiById(String slotID) {
		Mengaji mc = new Mengaji();
		try {
			//call getConnection() method
			con = ConnManager.getConnection();
			//3. create statement
			ps=con.prepareStatement("SELECT * FROM mengaji where slotID=?");
			ps.setString(1, slotID);
			//4. execute query
			rs = ps.executeQuery();
			
			if(rs.next()) {
				mc.setSlotID(rs.getString("slotID"));
				mc.setDate(rs.getString("date"));
				mc.setTime(rs.getString("time"));
				mc.setGuruname(rs.getString("guruname"));
				mc.setVenue(rs.getString("venue"));
			}
			//5. close connection
			con.close();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return mc;
	}
	
	//update jumaat
	public void updateMengaji(Mengaji bean) {
		slotID = bean.getSlotID();
		date = bean.getDate();
		time = bean.getTime();
		guruname = bean.getGuruname();
		venue = bean.getVenue();
		
		try {
			//call getConnection() method 
			con = ConnManager.getConnection();
			
			//3. create statement for slot
			//stmt = con.createStatement();
			ps = con.prepareStatement("UPDATE slot SET slotTime=?, slotDate=? WHERE slotID=?");
			ps.setString(1, time);
			ps.setString(2, date);
			ps.setString(3, slotID);
			
			//4. execute query
			ps.executeUpdate();
			
			
			//3. create statement
			ps = con.prepareStatement("UPDATE mengaji SET date=?, time=?, guruname=?, venue=? WHERE slotID=?");
			ps.setString(1, date);
			ps.setString(2, time);
			ps.setString(3, guruname);
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
		
	//delete mengaji
	public void deleteMengaji(String slotID) {
		try {
			//call getConnection() 
			con = ConnManager.getConnection();
			
			//3. create statement 
			ps=con.prepareStatement("DELETE from slot where slotID=?");
			ps.setString(1, slotID);
			
			//4. execute query
			ps.executeUpdate();
			
			//3. create statement 
			ps=con.prepareStatement("DELETE from mengaji where slotID=?");
			ps.setString(1, slotID);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			System.out.println("Slot with id " + slotID + " was successfully deleted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}
