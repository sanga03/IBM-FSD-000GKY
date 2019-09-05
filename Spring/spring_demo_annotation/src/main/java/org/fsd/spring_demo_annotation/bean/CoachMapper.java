package org.fsd.spring_demo_annotation.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CoachMapper implements RowMapper<CricCoach> {

	public CricCoach mapRow(ResultSet rs, int rowNum) throws SQLException {
		CricCoach coach= new CricCoach();
		coach.setTeamName(rs.getString(2));
		coach.setLoc(rs.getString(3));
		return coach;
	}
	

}
