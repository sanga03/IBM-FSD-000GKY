package com.example;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp2.BasicDataSource;
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
