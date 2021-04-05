/**
 * 
 */
package com.home.teamprojects;

import java.util.Iterator;

/**
 * @author rakeshshukla
 *
 */
public interface IGeozone {
	boolean AddCustomer(ICustomer a_customer);
	boolean AddProject(IProject a_project);
	Integer GetUniqueCustomerIdCount();
	double GetAverageBuildDuration();
	Iterator GetUniqueCustomerIdList();
	
}
