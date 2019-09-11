package com.example;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class StudentDoa {
@Autowired
Jtemlete jtemplate ;

	public StudentDoa(Jtemlete jtemplate) {
	super();
	this.jtemplate = jtemplate;
}

	public StudentDoa() {
		super();
	}

	public Jtemlete getJtemplate() {
	return jtemplate;
}

public void setJtemplate(Jtemlete jtemplate) {
	this.jtemplate = jtemplate;
}

	public void createStudent(Student student) {
		String query = "insert into student (name,lname,country,lang) values(?,?,?,?)";
		Object obj[]= {student.getName(),student.getLname(),student.getCountry(),student.getLang()};
		jtemplate.update(query,obj);
		System.out.println("inseted succeess");
		
	}

	public  List<Student> getStudent() {
		String query="select * from student";
		return jtemplate.query(query ,new StudentMapper());
				
	}
	public List<Student> searchName(String name) {
		System.out.println(name);
		String query="select * from student where name like '%"+name+"%' or lname like '%"+name+"%'";
//		Object obj[]= {name};
		return jtemplate.query(query, new StudentMapper());
	}

	public List<Student> searchEmail(String lang){
		String query="select * from student where lang like '%"+lang+"%'";
//		Object obj[]= {lang};
		return jtemplate.query(query, new StudentMapper());
	}
}
