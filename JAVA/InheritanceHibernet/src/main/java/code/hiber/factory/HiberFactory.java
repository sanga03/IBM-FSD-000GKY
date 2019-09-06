package code.hiber.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberFactory {

	private static SessionFactory sessionFactory=null;
	private static Session session=null;
	static {
		sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static Session getSession() {
		session = sessionFactory.getCurrentSession();
		return session;
	}
	
}
