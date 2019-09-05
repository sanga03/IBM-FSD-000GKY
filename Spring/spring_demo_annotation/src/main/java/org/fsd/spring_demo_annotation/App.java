package org.fsd.spring_demo_annotation;

import org.fsd.spring_demo_annotation.bean.CricCoach;
import org.fsd.spring_demo_annotation.bean.CricCoachDoa;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CricCoach coach = context.getBean("cricCoach", CricCoach.class);
		System.out.println(coach.getWorkoutPlan());
		CricCoachDoa coachDoa = context.getBean("cricCoachDoa", CricCoachDoa.class);
		coachDoa.createCricCoach(coach);
	}
}
