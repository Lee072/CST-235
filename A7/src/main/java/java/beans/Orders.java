package beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "Orders")
@ApplicationScoped
public class Orders 
{

	private List<Order> ordersList = new ArrayList<>();
	
	public Orders() 
	{
		ordersList.add(new Order("1", "Leaf", 10.00, 16));


	}


	public List<Order> getOrdersList() {

		
		return ordersList;
	}

	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}
}

