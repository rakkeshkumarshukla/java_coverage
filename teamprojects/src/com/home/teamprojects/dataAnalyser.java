package com.home.teamprojects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dataAnalyser {
	
	CustomerFactory customerFactory = new CustomerFactory();
    ContractFactory contractFactory = new ContractFactory();
    GeozoneFactory geozoneFactory = new GeozoneFactory();
    TeamFactory teamFactory = new TeamFactory();
    ProjectFactory projectFactory = new ProjectFactory();
    ContractsContainer contracts = new ContractsContainer();
    GeozonesContainer geozones = new GeozonesContainer();
    final String default_type = "default";
    
	public boolean init(String[] lines)
	{
		for (String str_line : lines) {
			try
			{
	        	StringTokenizer st1 = new StringTokenizer(str_line,",");
	        	//customerId,contractId,geozone,teamcode,projectcode,buildduration
	        	
	        	ICustomer customer = customerFactory.createCustomer(default_type, st1.nextToken()) ;
	        	
	        	Integer contractId = Integer.valueOf(st1.nextToken());
	        	
	        	IContract contract = contractFactory.createContract(default_type, contractId);
	        	
	        	String geozoneId = (st1.nextToken());
	        	
	        	IGeozone geozone  =  geozoneFactory.createGeozone(default_type, geozoneId) ; 
	        	
	        	ITeam team =  teamFactory.createTeam(default_type, st1.nextToken());
	        	
	        	String projectCode = st1.nextToken();
	        	String buildDuration = st1.nextToken();
	        	if (buildDuration != null && buildDuration.length() > 0 && buildDuration.charAt(buildDuration.length() - 1) == 's') {
	        		buildDuration = buildDuration.substring(0, buildDuration.length() - 1);
	            }
	            
	            
	            
	        	IProject project = projectFactory.createProject(default_type, projectCode, Integer.valueOf(buildDuration)) ;//  new CProject(projectCode,Integer.valueOf(buildDuration));
	        	 
	        	//
	        	contracts.addCustomer(contractId, customer);
			
	        	geozones.addCustomerAndProject(geozoneId, customer, project);
			
	        	
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
	public void printContractsCustomerCounts()
	{
		contracts.printContractsCustomerCounts();
	}
	public void printGeozonesCustomerCountsNamesAndBuildTimes()
	{
		geozones.printGeozonesCustomerCountsNamesAndBuildTimes();
	}
	
}
