package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student= new Student();
		student.setName(rs.getString(2));
		student.setLname(rs.getString(3));
		student.setCountry(rs.getString(4));
		student.setLang(rs.getString(5));
	return student;
	}
	

}
