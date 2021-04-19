package com.home.teamprojects;

import java.util.HashMap;
import java.util.Map;

public class ContractsContainer {
	
	Map<Integer,IContract> map_contracts= new HashMap<Integer,IContract>();
	IprocessOutputContractwise processoutput ;
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
		processoutput = new CprintProcessOutputContractWise();//TODO , replace by factory method
		processoutput.processoutput(map_contracts);//TODO, Iterator pattern to be used
		  
	}

}
