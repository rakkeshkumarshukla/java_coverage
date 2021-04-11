package com.home.teamprojects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GeozonesContainer {
	Map<String,IGeozone> map_geozones= new HashMap<String,IGeozone>();
	boolean addCustomerAndProject(String geozoneId, ICustomer customer, IProject project )
	{
		//
		//geozones
    	if(map_geozones.containsKey(geozoneId))
    	{
    		map_geozones.get(geozoneId).AddCustomer(customer);
    		map_geozones.get(geozoneId).AddProject(project);
    	}
    	else
    	{
    		IGeozone geozone  =  new CGeozone(geozoneId);
    		geozone.AddCustomer(customer);
    		geozone.AddProject(project);
    		
    		map_geozones.put(geozoneId, geozone);
    	}
    	return true;
    	//
	}
	Integer getGeozoneUniqueCustomerIds(String geozoneId)
	{
		if(map_geozones.containsKey(geozoneId))
    	{
    		return map_geozones.get(geozoneId).GetUniqueCustomerIdCount();
    		
    	}
    	else
    	{
    		return -1;
    	}
	}
	double getGeozoneAverageBuildTime(String geozoneId)
	{
		if(map_geozones.containsKey(geozoneId))
    	{
    		return map_geozones.get(geozoneId).GetAverageBuildDuration();
    		
    	}
    	else
    	{
    		return -1;
    	}
	}
	void printGeozonesCustomerCountsNamesAndBuildTimes()
	{
		 for (Map.Entry<String,IGeozone> entry : map_geozones.entrySet())
	        {
	            System.out.println("geozone = " + entry.getKey());
	            System.out.println("----------------------------------");
	            
	            System.out.println("unique customerIds = " + entry.getValue().GetUniqueCustomerIdCount());
	            
	            System.out.println("average buildduration = " + entry.getValue().GetAverageBuildDuration());
	            
	            String geozone = entry.getKey();
	            Iterator<ICustomer> itr = entry.getValue().GetUniqueCustomerIdList();
	            System.out.print("list of unique customerIds = ");
	            while(itr.hasNext())
	            {
	            	 System.out.print(itr.next().getCustomerId() + ", ");
	            }
	            System.out.println();
	            System.out.println("----------------------------------");
	            
	        }
	}


}
