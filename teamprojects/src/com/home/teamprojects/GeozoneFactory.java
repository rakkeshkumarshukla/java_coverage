package com.home.teamprojects;

public class GeozoneFactory {

	public IGeozone createGeozone(String type, String id)
	{
		IGeozone geozone= null;
		if(type.equals("default"))
			geozone = new CGeozone(id);
		else//default
			geozone = new CGeozone(id);
		
		return geozone;
	}
}
