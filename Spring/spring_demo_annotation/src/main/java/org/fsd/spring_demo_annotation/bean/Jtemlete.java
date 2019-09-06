package org.fsd.spring_demo_annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Jtemlete extends JdbcTemplate{

	@Autowired
	private DataSource dataSource;
	{
		System.out.println(dataSource);
	}

	private javax.sql.DataSource ds=dataSource;
	public Jtemlete(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public Jtemlete() {
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

	
}
