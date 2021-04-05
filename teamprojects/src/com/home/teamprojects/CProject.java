/**
 * 
 */
package com.home.teamprojects;

/**
 * @author rakeshshukla
 *
 */
public class CProject implements IProject {

	private String m_projectCode;
	private Integer m_buildDuration;
	CProject(String code, Integer buildDuration)
	{
		m_projectCode=code;
		m_buildDuration=buildDuration;
		
	}
	public Integer getBuildDuration()
	{
		return m_buildDuration;
	}
}
