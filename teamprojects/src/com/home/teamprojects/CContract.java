/**
 * 
 */
package com.home.teamprojects;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rakeshshukla
 *
 */
public class CContract implements IContract {
	private Integer m_contractId;
	private Set<ICustomer> m_customers = new HashSet<ICustomer>();
	public void AddCustomer(ICustomer a_customer)
	{
		m_customers.add(a_customer);
		//return true;
	}
	CContract(Integer contractId)
	{
		m_contractId = contractId;
	}
	public Integer GetUniqueCustomerIdCount()
	{
		return m_customers.size();
	}
	public int hashCode(){
	    
	    return (m_contractId);
	}
	@Override
	public boolean equals(Object c)
	{
	  if (c == null) return false; 
	  CContract o = (CContract)c;
    if (this.m_contractId.equals(o.m_contractId) ) return true;
    return false;
	}

}
