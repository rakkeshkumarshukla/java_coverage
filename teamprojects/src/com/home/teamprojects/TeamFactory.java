package com.home.teamprojects;

public class TeamFactory {
	
	public ITeam createTeam(String type, String code)
	{
		ITeam team= null;
		if(type.equals("default"))
			team = new CTeam(code);
		else//default
			team = new CTeam(code);
		
		return team;
	}

}
