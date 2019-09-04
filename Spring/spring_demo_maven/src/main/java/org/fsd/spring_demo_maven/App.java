package org.fsd.spring_demo_maven;

import org.fsd.spring_demo_maven.bean.BaseBallCoach;
import org.fsd.spring_demo_maven.bean.Coach;
import org.fsd.spring_demo_maven.bean.CricCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Coach coach = context.getBean("theCoach", CricCoach.class);
		Coach baseCoach = context.getBean("theBaseCoach",BaseBallCoach.class);
		System.out.println(baseCoach.getWorkoutPlan());
		System.out.println(coach.getWorkoutPlan());

	}
}
