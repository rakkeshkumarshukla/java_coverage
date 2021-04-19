package com.home.teamprojects;

import java.util.Map;

/**
 * {@summary} 
 * abstracting processing of output after data parsing and aggregations are 
 * complete.
 *
 */

public interface IprocessOutputContractwise {
	
	void processoutput(Map<Integer,IContract> map_contracts);

}





