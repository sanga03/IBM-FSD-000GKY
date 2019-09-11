package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller("/student")
public class StudentCotroller {
	@Autowired
	StudentDoa dao; 
	@GetMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("student",new Student());
		model.addAttribute("sea",new Sea());
		return "student-form";
	}
	
	@PostMapping("/performProcess")
	public String processForm(@ModelAttribute("student") Student student,Model model) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("application-config.xml");
//		StudentDoa doa = context.getBean("studentDoa",StudentDoa.class);
		dao.createStudent(student);
		List<Student> slist=dao.getStudent();
		for(Student s:slist) {
			System.out.println(s);
		}
		model.addAttribute("slist",slist);
		return "process-student";
	}
	
	@PostMapping("/search")
	public String searchForm(@ModelAttribute("sea") Sea sea,Model model) {
		System.out.println("--a"+sea.getStype());
		if(sea.getStype().equals("NAME") ){
			System.out.println("--name");
			List<Student> slist=dao.searchName(sea.getSname());
			model.addAttribute("slist",slist);
		}else if(sea.getStype().equals("Lang")) {
			List<Student> slist=dao.searchEmail(sea.getSname());
			model.addAttribute("slist",slist);		
		}
		return "process-student";
	}
}
