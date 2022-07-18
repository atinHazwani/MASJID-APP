package mas.connection;

import java.sql.*;

public class ConnManager {
	private static Connection con;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://b42a15d01d4796:ec8863af@us-cdbr-east-05.cleardb.net/heroku_ead4a1c4196b72b?reconnect=true";
    private static final String DB_USER = "b42a15d01d4796";
    private static final String DB_PASSWORD = "ec8863af";
    
    public static Connection getConnection() {

        try {
        	//1. load the driver
            Class.forName(DB_DRIVER);

            try {
            	//2. create connection
                con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
                System.out.println("connected");

            }

            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
}
