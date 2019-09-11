package com.customerMVC.Config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = "com.customerMVC")
@EnableTransactionManagement
@EnableWebMvc
public class CustomerConfig {

	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		myDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/javadatabase");
		myDataSource.setUser("root");
		myDataSource.setPassword("mysql");
		try {
			myDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myDataSource.setMaxIdleTime(30000);
		myDataSource.setMinPoolSize(10);
		myDataSource.setMaxPoolSize(20);
		return myDataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessFactory = new LocalSessionFactoryBean();
		sessFactory.setDataSource(myDataSource());
		sessFactory.setPackagesToScan("com.customerMVC.Entity");
		sessFactory.setHibernateProperties(getProps());
		return sessFactory;
	}

	private Properties getProps() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager myTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

}
