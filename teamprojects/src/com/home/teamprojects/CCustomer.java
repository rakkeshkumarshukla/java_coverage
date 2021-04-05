/**
 * 
 */
package com.home.teamprojects;

/**
 * @author rakeshshukla
 *
 */
public class CCustomer implements ICustomer {

	private String m_customerId;
	CCustomer(String customerId)
	{
		m_customerId=customerId;
	}
	public String getCustomerId()
	{
		return m_customerId;
	}
}
