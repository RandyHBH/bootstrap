package com.bartumeu.bootstrap.basicdi;

import com.bartumeu.bootstrap.CustomerService;
import com.bartumeu.bootstrap.DataSourceUtils;
import com.bartumeu.bootstrap.Demo;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

public class Application {
	public static void main(String[] args) {
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(H2).build();
		DataSource initializeDataSource = DataSourceUtils.initializeDdl(dataSource);
		CustomerService customerService = new DataSourceCustomerService(initializeDataSource);
		Demo.workWithCustomerService(Application.class, customerService);
	}
}
