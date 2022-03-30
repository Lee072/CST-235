package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import beans.Order;

public class OrdersDataService implements DataAccessInterface{
	
	

	ResultSet rs;
	Connection c;
	Statement stmt;
	String dURL = "jdbc:mysql://localhost:3306/testapp";
	String user = "root";
	String pass = "root";

	
	@Override
	public List<Order> findAll() {
	
		try {
			c = DriverManager.getConnection(dURL, user, pass);
			System.out.println("Success!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("YOU CODED SOMETING WORNG BUDDY");
		} finally {
			rs.close();
			stmt.close();
			c.close();
		}
	}

}
