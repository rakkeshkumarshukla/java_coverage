package com.home.teamprojects;

import java.util.Map;
/**
 * {@summary} 
 * abstracting processing of output after data parsing and aggregations are 
 * complete.
 *
 */

public interface IprocessOutputgeoZonewise {
	void processoutput(Map<String,IGeozone> map_geozones);

}