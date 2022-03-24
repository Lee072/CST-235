package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.MyTimerService;
import beans.User;
import business.OrdersBusinessInterface;

@SuppressWarnings("deprecation")
@ManagedBean(name="FormController")
@ViewScoped
public class FormController 
{
	String dURL = "jdbc:mysql://localhost:3306/testapp";
	String user = "root";
	String pass = "root";
	ResultSet rs;
	Connection c;
	Statement stmt;
	
	MyTimerService timer;
	@Inject
	OrdersBusinessInterface service;
	
	public OrdersBusinessInterface getService() {
		return service;
	}

	public String onSubmit(User user) throws SQLException
	{
		OrdersBusinessInterface.test();
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getRequestMap().put("User", user);
		
		timer.setTimer(10000);
		
		getAllOrders();
		
		insertOrder();
		
		getAllOrders();
		
		return "TestResponse.xhtml";
		
		
	}
	
	private void insertOrder() throws SQLException {
		// TODO Auto-generated method stub
		c = DriverManager.getConnection(dURL, user, pass);
		rs = stmt.executeQuery("Insert into testapp.orders('001122334455', 'This was inserted new', 25.00, 100)");
	}

	public String onFlash(User user) 
		{
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getFlash().put("User", user);
		
		return "TestResponse.xhtml";
		

 		}
	public void getAllOrders() throws SQLException
	{
		
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
	
			
		rs = stmt.executeQuery("select * from testapp.orders" );
		
		while(rs.next()) {
			
			System.out.println("id: " + rs.getInt("ID") + " Product Name: " + rs.getString("PRODUCT_NAME") + " Price: " + rs.getFloat("PRICE"));
		}
	}
	

	

	
}