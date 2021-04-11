package com.home.teamprojects;

public class CustomerFactory {
	public ICustomer createCustomer(String type, String id)
	{
		ICustomer customer= null;
		if(type.equals("default"))
			customer = new CCustomer(id);
		else//default
			customer = new CCustomer(id);
		
		return customer;
	}
	

}
