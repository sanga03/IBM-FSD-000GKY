package org.fsd.spring_demo_annotation.bean;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DataSource extends BasicDataSource{

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

}
