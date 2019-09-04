package com.fsd.Instructor_one_to_one_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fsd.Instructor_one_to_one_hibernate.model.Instructor;
import com.fsd.Instructor_one_to_one_hibernate.model.Instructor_detail;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Instructor_detail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
		
			
			Instructor tempInstructor = 
					new Instructor("hari",  "sangu4403@gmail.com");
			
			Instructor_detail tempInstructorDetail =
					new Instructor_detail(
							"http://www.youtube.com",
							"batmiton");		
	
//			
//// one to one
//			// associate the objects
//			tempInstructor.setInstructor_detail(tempInstructorDetail);
//			
//			// start a transaction
//			session.beginTransaction();
//			
//			// save the instructor
//			//
//			// Note: this will ALSO save the details object
//			// because of CascadeType.ALL
//			//
//			System.out.println("Saving instructor: " + tempInstructor);
//			session.save(tempInstructor);					
//			
//			// commit transaction
//			session.getTransaction().commit();
// one to one bi derect
			tempInstructorDetail.setInstructor(tempInstructor);
			session.beginTransaction();
			
		
			System.out.println("Saving instructor: " + tempInstructorDetail);
			session.save(tempInstructorDetail);					
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
// delete 
//	session.beginTransaction();
//			
//			// save the instructor
//			//
//			// Note: this will ALSO save the details object
//			// because of CascadeType.ALL
//			//
//		session.remove(tempInstructorDetail);			
//			
//			// commit transaction
//			session.getTransaction().commit();
//			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
    }
}
