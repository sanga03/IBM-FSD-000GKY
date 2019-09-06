package org.fsd.spring_demo_annotation.bean;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CricCoachDoa {
@Autowired
Jtemlete jtemplate ;

	public CricCoachDoa(Jtemlete jtemplate) {
	super();
	this.jtemplate = jtemplate;
}

	public CricCoachDoa() {
		super();
	}

	public Jtemlete getJtemplate() {
	return jtemplate;
}

public void setJtemplate(Jtemlete jtemplate) {
	this.jtemplate = jtemplate;
}

	public void createCricCoach(CricCoach coach) {
		String query = "insert into criccoach (teamname,loc) values(?,?)";
		Object obj[]= {coach.getTeamName(),coach.getLoc()};
		jtemplate.update(query,obj);
		System.out.println("inseted succeess");
		
	}

	public  List<CricCoach> getCricCoach() {
		String query="select * from criccoach";
		return jtemplate.query(query ,new CoachMapper());
		
				
	}


}
