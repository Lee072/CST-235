package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

@RequestScoped
@Path("/orders")
public class OrdersRestService {
	@Inject
	OrdersBusinessInterface service;

	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getOrdersAsJson() {
		service.getOrders();
		return List<Order>;
	}
	
	@GET
	@Path("getxml")
	@Produces(MediaType.APPLICATION_XML)
	Class<Order[]> getOrdersAsXml(){
		service.getOrders();
		
		return Order[];
	}
	

}
