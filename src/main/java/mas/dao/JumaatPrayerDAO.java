package mas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mas.connection.ConnManager;
import mas.model.JumaatPrayer;

public class JumaatPrayerDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement ps = null;
	String slotID;
	String date, time;
	String khutbahTitle;
	
	//add jumaat_prayer
		public void addJumaatPrayer(JumaatPrayer bean) {
			
			//get jumaat_prayer
			slotID = bean.getSlotID();
			date = bean.getDate();
			khutbahTitle = bean.getKhutbahTitle();
			time = "N/A";
			
			
			try {
				//call getConnection() method from ConnectionManager class
				con = ConnManager.getConnection();
				
				
				
				//3. create statement for jumaat_prayer
				//stmt = con.createStatement();
				ps = con.prepareStatement("INSERT INTO jumaat_prayer (slotID, date, khutbahTitle) VALUES (?, ?, ?)");
				ps.setString(1, slotID);
				ps.setString(2, date);
				ps.setString(3, khutbahTitle);
				
				//4. execute query
				ps.executeUpdate();
				
				
				//5.close connection
				con.close();
				 
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//get product by id
		public static JumaatPrayer getJumaatPrayerByID(String slotID) {
			JumaatPrayer jumaatPrayer = new JumaatPrayer();
			
			try {
				//call getConnection() method from ConnectionManager class
				con = ConnManager.getConnection();
				
				//3. create statement
				//stmt = con.createStatement();
				String sql = "SELECT * FROM jumaat_prayer WHERE slotID=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, slotID);
				
				//4. execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					jumaatPrayer.setSlotID(rs.getString("slotID"));
					jumaatPrayer.setDate(rs.getString("date"));
					jumaatPrayer.setKhutbahTitle(rs.getString("khutbahTitle"));
				}
				
				//5.close connection
				//con.close();
				 
			}catch(Exception e) {
				e.printStackTrace();
			}
			return jumaatPrayer;
		}
			
		
		
		//get all product
		public static List<JumaatPrayer> getAllJumaatPrayer(){
			List<JumaatPrayer> jumaatPrayers = new ArrayList<JumaatPrayer>();
			
			try {
				//call getConnection() method from ConnectionManager class
				con = ConnManager.getConnection();
				
				//3. create statement
				//stmt = con.createStatement();
				String sql = "SELECT * FROM jumaat_prayer ORDER BY slotID";
				stmt = con.createStatement();
							
				//4. execute query
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					JumaatPrayer jumaatPrayer = new JumaatPrayer();
					jumaatPrayer.setSlotID(rs.getString("slotID"));
					jumaatPrayer.setDate(rs.getString("date"));
					jumaatPrayer.setKhutbahTitle(rs.getString("khutbahTitle"));
					jumaatPrayers.add(jumaatPrayer);
				}
				
				//5.close connection
				con.close();
				 
			}catch(Exception e) {
				e.printStackTrace();
			}
			return jumaatPrayers;
			
			
		}
		
		
		//update jumaat
		public void updateJumaatPrayer(JumaatPrayer bean) {
			
			//get product
			slotID = bean.getSlotID();
			date = bean.getDate();
			khutbahTitle = bean.getKhutbahTitle();
			
			try {
				//call getConnection() method from ConnectionManager class
				con = ConnManager.getConnection();
				
				//3. create statement for jumaat_prayer
				//stmt = con.createStatement();
				ps = con.prepareStatement("UPDATE jumaat_prayer SET date=?, khutbahTitle=? WHERE slotID=?");
				ps.setString(1, date);
				ps.setString(2, khutbahTitle);
				ps.setString(3, slotID);
				
				//4. execute query
				ps.executeUpdate();
				
				//5.close connection
				con.close();
				System.out.println("Slot with id " + slotID + " was successfully updated");
				 
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//delete product
		public void deleteJumaatPrayer(String slotID) {
			
			try {
				//call getConnection() method from ConnectionManager class
				con = ConnManager.getConnection();
				
				//3. create statement 
				ps=con.prepareStatement("DELETE from slot where slotID=?");
				ps.setString(1, slotID);
				
				//4. execute query
				ps.executeUpdate();
				
				//3. create statement 
				ps=con.prepareStatement("DELETE from jumaat_prayer where slotID=?");
				ps.setString(1, slotID);
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				System.out.println("Slot with id " + slotID + " was successfully deleted");
				 
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
}
