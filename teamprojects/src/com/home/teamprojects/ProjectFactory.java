package com.home.teamprojects;

public class ProjectFactory {

	public IProject createProject(String type, String id, Integer buildDuration)
	{
		IProject project= null;
		if(type.equals("default"))
			project = new CProject(id,buildDuration);
		else//default
			project = new CProject(id,buildDuration);
		
		return project;
	}
}
