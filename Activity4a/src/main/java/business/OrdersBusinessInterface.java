package business;

import java.util.List;

import javax.ejb.Local;

import beans.Order;
import beans.Orders;

@Local
public interface OrdersBusinessInterface 
{

	public static void test()
	{
		
		
	}
	
	public List<Order> getOrders();
	
	public void setOrders(List<Orders> orders);
}
