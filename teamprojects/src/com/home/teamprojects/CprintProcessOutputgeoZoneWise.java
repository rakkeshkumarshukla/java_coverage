package com.home.teamprojects;

import java.util.Iterator;
import java.util.Map;

/**
 * {@summary} 
 * abstracting processing of output after data parsing and aggregations are 
 * complete.
 * CprintProcessOutputgeoZoneWise will specialize IprocessOutputgeoZonewise for 
 * printing on console
 *
 */
public class CprintProcessOutputgeoZoneWise  implements IprocessOutputgeoZonewise{
	
	@Override
	public void processoutput(Map<String,IGeozone> map_geozones)
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
