package org.fsd.spring_demo_annotation;

import java.util.List;

import org.fsd.spring_demo_annotation.bean.Coach;
import org.fsd.spring_demo_annotation.bean.CoachConfig;
import org.fsd.spring_demo_annotation.bean.CricCoach;
import org.fsd.spring_demo_annotation.bean.CricCoachDoa;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoachConfig.class);
		CricCoach coach = context.getBean("cricCoach", CricCoach.class);
		System.out.println(coach.getWorkoutPlan());
		CricCoachDoa coachDoa = context.getBean("cricCoachDoa", CricCoachDoa.class);
		coachDoa.createCricCoach(coach);
	List<CricCoach> clist= coachDoa.getCricCoach();
	for(CricCoach c:clist) {
		System.out.println(c);
 	}
	
	}
}
