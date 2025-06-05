package mgmtsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
 
public class TravelDatabaseConnector{
 
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tourismdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
 
    // JDBC variables for opening, closing, and managing the database connection
    private static Connection connection;
 
    // Constructor to initialize the database connection
    public TravelDatabaseConnector() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // Establish the database connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately in a real-world application
        }
    }
    public void userInput(String name, String desc)
    { //("goa","beach");
    	String query="INSERT INTO destinations (destinations.name,destinations.description) VALUES (?,?)";
    	try {
    	PreparedStatement preparedStatement=connection.prepareStatement(query);
		//ps.setString(1, id);
    	//preparedStatement.setString(2);
    	
    		preparedStatement.setString(1,name);
    		preparedStatement.setString(2, desc);
			preparedStatement.executeUpdate();
			
			//getDestinationInfo();
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    // Method to retrieve destination information from the database
//    public void deletion(int del_id) {
//        try {
//            // Prepare SQL statement
//            String sql = "update destinations set param=... where col_name=...";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            //ps=c.prepareStatement(query);
//            preparedStatement.setString(1,int value);
//        }
//    }
    public void getDestinationInfo() {
        try {
            // Prepare SQL statement
            String sql = "SELECT * FROM destinations";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //ps=c.prepareStatement(query);
            //preparedStatement.setString(1, "%"+desc+"%");
			//rs=preparedStatement.executeQuery();
            //preparedStatement.setInt(1,1);
 
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
 
            // Process the results
            while (resultSet.next()) {
                 int id = resultSet.getInt("id");
                //int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                //String name = resultSet.getString(2);
                String description = resultSet.getString("description");
                //String description = resultSet.getString(3);
                // Print or use the retrieved information as needed
                System.out.println("Destination ID: " + id);
                System.out.println("Destination Name: " + name);
                System.out.println("Description: " + description);
            }
 
            // Close resources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately in a real-world application
        }
    }
 
    // Method to close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately in a real-world application
        }
    }
 
    public static void main(String[] args) {
        // Example usage
        TravelDatabaseConnector connector = new TravelDatabaseConnector();
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        String desc=sc.next();
        connector.userInput(name,desc);
        connector.getDestinationInfo();
        connector.closeConnection();
    }
}
