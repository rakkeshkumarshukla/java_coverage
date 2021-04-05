/**
 * 
 */
package com.home.teamprojects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author rakeshshukla
 *
 */
public class CGeozone implements IGeozone {

	private String m_geozoneId;
	private Set<ICustomer> m_customers = new HashSet<ICustomer>();
	private List<IProject> m_projects = new ArrayList<IProject>();
	private List<Integer> m_buildTimes = new ArrayList<Integer>();
	CGeozone(String geozoneId )
	{
		m_geozoneId = geozoneId;
	}
	public boolean AddCustomer(ICustomer a_customer)
	{
		m_customers.add(a_customer);
		return true;
	}
	public boolean AddProject(IProject a_project)
	{
		m_projects.add(a_project);
		m_buildTimes.add(a_project.getBuildDuration());
		return true;
	}
	public Integer GetUniqueCustomerIdCount()
	{
		return m_customers.size();
	}
	
	
	public double GetAverageBuildDuration()
	{
		IntSummaryStatistics summaryStats = m_buildTimes.stream()
			      .mapToInt((a) -> a)
			      .summaryStatistics();
		return summaryStats.getAverage();
			     // System.out.println("Average of a List = "+summaryStats.getAverage());
	}
	public Iterator<ICustomer> GetUniqueCustomerIdList()
	{
		
		return m_customers.iterator();
	}
	
	
}
