package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/student")
public class StudentCotroller {
	@Autowired
	StudentDoa dao; 
	@GetMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("student",new Student());
		return "student-form";
	}
	
	@PostMapping("/performProcess")
	public String processForm(@ModelAttribute("student") Student student,Model model) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("application-config.xml");
//		StudentDoa doa = context.getBean("studentDoa",StudentDoa.class);
		dao.createStudent(student);
		List<Student> slist=dao.getStudent();
		model.addAttribute(slist);
		return "process-student";
	}
}
