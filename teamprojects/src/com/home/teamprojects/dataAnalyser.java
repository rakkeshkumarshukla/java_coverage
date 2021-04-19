package com.home.teamprojects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * {@summary} 
 * take data as array  of input lines.
 * checks format and count of data points in each line
 * set up of factories for each data point
 * aggregates data on contract and geozone
 * emits outout 
 *
 */
public class dataAnalyser {
	
	CustomerFactory customerFactory = new CustomerFactory();
    ContractFactory contractFactory = new ContractFactory();
    GeozoneFactory geozoneFactory = new GeozoneFactory();
    TeamFactory teamFactory = new TeamFactory();
    ProjectFactory projectFactory = new ProjectFactory();
    ContractsContainer contracts = new ContractsContainer();
    GeozonesContainer geozones = new GeozonesContainer();
    final Integer numberofFieldsinaLine = 6;
    final String CSVDelimiter = ",";
    final Integer indexCustomerId = 0;
    final Integer indexContractId = 1;
    final Integer indexgeoZone = 2;
    final Integer indexteamCode = 3;
    final Integer indexprojectCode = 4;
    final Integer indexbuildDuration= 5;
    //these can be part of config 
    final String default_type = "default";
    final String regexCustomerId = "\\d{1,9}";
    final String regexContractId = "\\d{1,9}";
    final String regexGeozone = "\\p{Lower}\\p{Lower}_\\p{Lower}\\p{Lower}\\p{Lower}\\p{Lower}";
    final String regexteamCode =  "[a-zA-Z]+\\d{0,10}";
    final String regexprojectCode =  "[a-zA-Z]+";
    final String regexbuildDuration =  "\\d{1,9}";
    
    List<List<String>> line_items = new ArrayList<List<String>>();
    
    public boolean init(String[] lines)
    {
    	if(parse(lines))
    	{
    		if(loadData())
    			return true;
    	}
    	return false;
    }
    
    public void emitOutput()
    {
    	contracts.printContractsCustomerCounts();
    	geozones.printGeozonesCustomerCountsNamesAndBuildTimes();
    }
	public boolean parse(String[] lines)
	{
		for (String str_line : lines) {
			try
			{
				String fields[] = str_line.split(CSVDelimiter);
			    if (fields.length != numberofFieldsinaLine){
			    	
			    	System.out.println("incomlete line item");
			    	return false;
			    }
			    List<String> singleLineItems = new ArrayList<String>();
			    
			    
	        	StringTokenizer st1 = new StringTokenizer(str_line,",");
	        
	        	
	        	singleLineItems.add(st1.nextToken());	
	        	singleLineItems.add(st1.nextToken());
	        	singleLineItems.add(st1.nextToken());
	        	singleLineItems.add(st1.nextToken());
	        	singleLineItems.add(st1.nextToken());
	        	singleLineItems.add(st1.nextToken());
	        
	        	line_items.add(singleLineItems);
			
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
				System.out.println("input format is incorrect.");
				System.out.println("correct format for a line is customerId,contractId,geozone,teamcode,projectcode,buildduration");
				System.out.println("customerId should be integer");
				System.out.println("contractId should be integer");
				System.out.println("geozone should be alphanumeric");
				System.out.println("teamcode should be alphanumeric");
				System.out.println("projectcode should be alphanumeric");
				System.out.println("buildduration should be in format as Integer+s. example 3443s\n\n");
				return false;	
			}
		}
		return true;
        
	}
	public boolean loadData()
	{
	
		for(List<String> aLineofData : line_items) {
				
			try
			{
				
	        	//customerId,contractId,geozone,teamcode,projectcode,buildduration
				String strCustomerId = aLineofData.get(indexCustomerId);
				
				boolean isValidCustomer = strCustomerId.matches(regexCustomerId);
				if(!isValidCustomer)
				{
					System.out.println("invalid format of customer id");
					return false;
				}
				    	
	        	ICustomer customer = customerFactory.createCustomer(default_type, strCustomerId) ;
	        	     
	        	String strContractId = aLineofData.get(indexContractId);
	        	boolean isValidContract = strContractId.matches(regexContractId);
				if(!isValidContract)
				{
					System.out.println("invalid format of contract id");
					return false;
				}
				
	        	Integer contractId = Integer.valueOf(strContractId);
	        	
	        	IContract contract = contractFactory.createContract(default_type, contractId);
	        
	        	String geozoneId = (aLineofData.get(indexgeoZone));
	        	
	        	boolean isValidGeozone = geozoneId.matches(regexGeozone);
				if(!isValidGeozone)
				{
					System.out.println("invalid format of geozone id");
					return false;
				}
	        	
	        	
	        	IGeozone geozone  =  geozoneFactory.createGeozone(default_type, geozoneId) ; 
	        	
	        	String strteamCode = aLineofData.get(indexteamCode);
	        	
	        	boolean isValidteamCode = strteamCode.matches(regexteamCode);
				if(!isValidteamCode)
				{
					System.out.println("invalid format of teamcode");
					return false;
				}
				
	        		
	        	ITeam team =  teamFactory.createTeam(default_type, strteamCode);
	        	
	        	
	        	String strprojectCode = aLineofData.get(indexprojectCode);
	        	boolean isValidprojectCode = strprojectCode.matches(regexprojectCode);
				if(!isValidprojectCode)
				{
					System.out.println("invalid format of projectcode");
					return false;
				}
	        	
	        	
	        	
	        	
	        	String buildDuration = aLineofData.get(indexbuildDuration);
	        	
	        	if (buildDuration != null && buildDuration.length() > 0 && buildDuration.charAt(buildDuration.length() - 1) == 's') {
	        		buildDuration = buildDuration.substring(0, buildDuration.length() - 1);
	        	 }
	                  
	        	boolean isValidBuildDuration = buildDuration.matches(regexbuildDuration);
				if(!isValidBuildDuration)
				{
					System.out.println("invalid format of buildduration");
					return false;
				}
	        	
	        	
	        	
	        	IProject project = projectFactory.createProject(default_type, strprojectCode, Integer.valueOf(buildDuration)) ;//  new CProject(projectCode,Integer.valueOf(buildDuration));
	        	 
	        	contracts.addCustomer(contractId, customer);
			
	        	geozones.addCustomerAndProject(geozoneId, customer, project);
	   
			}
			catch(Exception e)
			{
				
				System.out.println(e.toString());
				System.out.println("input format is incorrect.");
				System.out.println("correct format for a line is customerId,contractId,geozone,teamcode,projectcode,buildduration");
				System.out.println("customerId should be integer");
				System.out.println("contractId should be integer");
				System.out.println("geozone should be alphanumeric");
				System.out.println("teamcode should be alphanumeric");
				System.out.println("projectcode should be alphanumeric");
				System.out.println("buildduration should be in format as Integer+s. example 3443s\n\n");
				return false;	
			}
		}
		return true;
        
	}
	
	public Integer getGeozoneUniqueCustomerIds(String geozoneId)
	{
		return geozones.getGeozoneUniqueCustomerIds(geozoneId);
	}
	public double getGeozoneAverageBuildTime(String geozoneId)
	{
		return geozones.getGeozoneAverageBuildTime(geozoneId);
	}
	public Integer GetContractsUniqueCustomerCounts(Integer contractId)
	{
		return contracts.GetContractsUniqueCustomerCounts(contractId);
	}
	
	
}
