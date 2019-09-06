package org.fsd.spring_demo_maven.bean;

public class PracticeTimes {
	private String time, am;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getTimings() {
		return "Start at " + time + am;
	}
}
