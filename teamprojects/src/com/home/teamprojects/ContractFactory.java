package com.home.teamprojects;

public class ContractFactory {

	public IContract createContract(String type, Integer id)
	{
		IContract contract= null;
		if(type.equals("default"))
			contract = new CContract(id);
		else//default
			contract = new CContract(id);
		
		return contract;
	}
}


