package org.fsd.spring_demo_annotation.bean;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DataSource extends BasicDataSource{

//@Value("jdbc:mysql://localhost:3306/javadatabase")
//String url;
//@Value("root")
//String username;
//@Value("mysql")
//String password;
//@Value("com.mysql.jdbc.Driver")
//String driverClassName;
//{
//	System.out.println(url);
//}

@PostConstruct
public void DataSourceCreate() {
	
	setUrl("jdbc:mysql://localhost:3306/javadatabase");
	setUsername("root");
	setPassword("mysql");
	setDriverClassName("com.mysql.jdbc.Driver");

System.out.println(getUrl());
}

public DataSource() {
	super();
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDriverClassName() {
	return driverClassName;
}
public void setDriverClassName(String driverClassName) {
	this.driverClassName = driverClassName;
}

}
