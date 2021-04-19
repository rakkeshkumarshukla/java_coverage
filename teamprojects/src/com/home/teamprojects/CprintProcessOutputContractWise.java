package com.home.teamprojects;

import java.util.Map;

/**
 * {@summary} 
 * abstracting processing of output after data parsing and aggregations are 
 * complete.
 * CprintProcessOutputContractWise will specialize IprocessOutputContractwise for 
 * printing on console
 *
 */


public class CprintProcessOutputContractWise implements IprocessOutputContractwise{

	@Override
	public void processoutput(Map<Integer, IContract> map_contracts) {
		 for (Map.Entry<Integer,IContract> entry : map_contracts.entrySet())
	            System.out.println("contractId = " + entry.getKey() +
	                             ", unique customerIds = " + entry.getValue().GetUniqueCustomerIdCount());
		
	}
	

}
