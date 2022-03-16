package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.MyTimerService;
import beans.User;
import business.OrdersBusinessInterface;

@ManagedBean(name="FormController")
@ViewScoped
public class FormController 
{
	
	MyTimerService timer;
	@Inject
	OrdersBusinessInterface service;
	
	public OrdersBusinessInterface getService() {
		return service;
	}

	public String onSubmit(User user)
	{
		OrdersBusinessInterface.test();
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getRequestMap().put("User", user);
		
		timer.setTimer(10000);
		
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) 
 {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getFlash().put("User", user);
		
		return "TestResponse.xhtml";
		

 }
}