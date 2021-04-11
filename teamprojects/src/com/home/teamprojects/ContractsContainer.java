package com.home.teamprojects;

import java.util.HashMap;
import java.util.Map;

public class ContractsContainer {
	
	Map<Integer,IContract> map_contracts= new HashMap<Integer,IContract>();
	boolean addCustomer(Integer contractId, ICustomer customer)
	{
		//
    	if(map_contracts.containsKey(contractId))
    	{
    		map_contracts.get(contractId).AddCustomer(customer);
    	}
    	else
    	{
    		IContract contract = new CContract(contractId);
    		
    		contract.AddCustomer(customer);
    		map_contracts.put(contractId, contract);
    	}
    	return true;
    	//
	}
	Integer GetContractsUniqueCustomerCounts(Integer contractId)
	{
		if(map_contracts.containsKey(contractId))
    	{
    		return map_contracts.get(contractId).GetUniqueCustomerIdCount();
    	}
    	else
    	{
    		return -1;
    	} 
	}
	void printContractsCustomerCounts()
	{
		  for (Map.Entry<Integer,IContract> entry : map_contracts.entrySet())
	            System.out.println("contractId = " + entry.getKey() +
	                             ", unique customerIds = " + entry.getValue().GetUniqueCustomerIdCount());
	}

}
