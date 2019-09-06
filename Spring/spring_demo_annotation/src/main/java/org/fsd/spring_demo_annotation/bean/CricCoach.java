package org.fsd.spring_demo_annotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricCoach implements Coach {

	@Value(value = "RCB")
	private String TeamName;
	@Value(value = "CHInnaswamy Stadium")
	private String loc;

	public CricCoach() {
		super();
	}

	public CricCoach(String teamName, String loc) {
		super();
		TeamName = teamName;
		this.loc = loc;
	}

	public String getTeamName() {
		return TeamName;
	}

	@Override
	public String toString() {
		return "CricCoach [TeamName=" + TeamName + ", loc=" + loc + "]";
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getWorkoutPlan() {
		// TODO Auto-generated method stub
		return "get a run at 6:00 AM";
	}

	public String getPlan() {
		// TODO Auto-generated method stub
		return null;
	}

}
