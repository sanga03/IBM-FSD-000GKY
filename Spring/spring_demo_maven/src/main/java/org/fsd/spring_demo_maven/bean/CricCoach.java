package org.fsd.spring_demo_maven.bean;

public class CricCoach implements Coach{
private String name;
private String TeamName;
private String Loc;
	
public String getTeamName() {
	return TeamName;
}
public void setTeamName(String teamName) {
	TeamName = teamName;
}
public String getLoc() {
	return Loc;
}
public void setLoc(String loc) {
	Loc = loc;
}
private PracticeTimes practiceTimes;
	public String getWorkoutPlan() {
		// TODO Auto-generated method stub
		return getTeamName()+"\nRest Whole Day";
	}
	public String getTimings() {
		return practiceTimes.getTimings()+" in "+getLoc();
	}
	public String getName() {
		return name;
	}
	public  void getCric() {
		System.out.println("init called");
	}
	public void overCric() {
		System.out.println("destroy cric");
	}
	
	public PracticeTimes getPracticeTimes() {
		return practiceTimes;
	}
	public void setPracticeTimes(PracticeTimes practiceTimes) {
		this.practiceTimes = practiceTimes;
	}
	@Override
	public String toString() {
		return "CricCoach [name=" + name + "]";
	}
	public CricCoach(String name) {
		super();
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
