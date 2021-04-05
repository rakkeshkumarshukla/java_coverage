package com.home.teamprojects;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class teamprojects {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
        List<String> lines = new ArrayList<String>();
        String lineNew;

        while (input.hasNextLine()) {
            lineNew = input.nextLine();
            if (lineNew.isEmpty()) {
                break;
            }
            lines.add(lineNew);
        }
      
		Map<Integer,IContract> map_contracts= new HashMap<Integer,IContract>();
		Map<String,IGeozone> map_geozones= new HashMap<String,IGeozone>();

		for (String str_line : lines) {
			try
			{
	        	StringTokenizer st1 = new StringTokenizer(str_line,",");
	        	//customerId,contractId,geozone,teamcode,projectcode,buildduration
	        	
	        	ICustomer customer = new CCustomer(st1.nextToken()); 
	        	Integer contractId = Integer.valueOf(st1.nextToken());
	        	IContract contract = new CContract(contractId);
	        	String geozoneId = (st1.nextToken());
	        	IGeozone geozone  =  new CGeozone(geozoneId);
	        	ITeam team = new CTeam(st1.nextToken());
	        	String projectCode = st1.nextToken();
	        	String buildDuration = st1.nextToken();
	        	if (buildDuration != null && buildDuration.length() > 0 && buildDuration.charAt(buildDuration.length() - 1) == 's') {
	        		buildDuration = buildDuration.substring(0, buildDuration.length() - 1);
	            }
	            
	            
	            
	        	IProject project = new CProject(projectCode,Integer.valueOf(buildDuration));
	        	 
	        	//
	        	if(map_contracts.containsKey(contractId))
	        	{
	        		map_contracts.get(contractId).AddCustomer(customer);
	        	}
	        	else
	        	{
	        		contract.AddCustomer(customer);
	        		map_contracts.put(contractId, contract);
	        	}
	        	//
	        	//geozones
	        	if(map_geozones.containsKey(geozoneId))
	        	{
	        		map_geozones.get(geozoneId).AddCustomer(customer);
	        		map_geozones.get(geozoneId).AddProject(project);
	        	}
	        	else
	        	{
	        		geozone.AddCustomer(customer);
	        		geozone.AddProject(project);
	        		
	        		map_geozones.put(geozoneId, geozone);
	        	}
			}
			catch(Exception e)
			{
				//TODO instead of try catch; error handling to be done 
				//for each input of CSV 
				System.out.println("input format is incorrect.");
				System.out.println("correct format for a line is customerId,contractId,geozone,teamcode,projectcode,buildduration");
				System.out.println("customerId should be integer");
				System.out.println("contractId should be integer");
				System.out.println("geozone should be alphanumeric");
				System.out.println("teamcode should be alphanumeric");
				System.out.println("projectcode should be alphanumeric");
				System.out.println("buildduration should be in format as Integer+s. example 3443s\n\n");
						
			}
        }
		//TODO printing output to be abstracted in interfaces
        for (Map.Entry<Integer,IContract> entry : map_contracts.entrySet())
            System.out.println("contractId = " + entry.getKey() +
                             ", unique customerIds = " + entry.getValue().GetUniqueCustomerIdCount());
		
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
