package business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

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
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;

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
	
	public void sendOrder(Order order) throws SQLException {
		// Send a Message for an Order
		try {
			Connection connection = (Connection) connectionFactory.createConnection();
		Session  session = ((javax.jms.Connection) connection).createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer messageProducer = session.createProducer((Destination) queue);
		TextMessage message1 = session.createTextMessage();
		message1.setText("This is test message");
		messageProducer.send(message1);
		connection.close();} catch (JMSException e) {e.printStackTrace();
		}
		
	}

}
