package business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;
import beans.Orders;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {
	
	List<Order> orders;
	private String orderNumber;
	private String productName;
	private double price;
	private int quantity;

    /**
     * Default constructor. 
     */
    public OrdersBusinessService(String orderNumber, String productName, double price, int quantity) {
        // TODO Auto-generated constructor stub
    	this.orderNumber = orderNumber;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
   	 System.out.println("Hello, from the OrdersBusinessService");
    }

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrders(List<Orders> orders) {
		// TODO Auto-generated method stub
		
	}

}
