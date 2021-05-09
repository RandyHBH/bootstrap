package com.bartumeu.bootstrap.templates;

import com.bartumeu.bootstrap.CustomerService;
import com.bartumeu.bootstrap.DataSourceUtils;
import com.bartumeu.bootstrap.Demo;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

public class Application {
	public static void main(String[] args) {
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(H2).build();
		DataSource initializeDataSource = DataSourceUtils.initializeDdl(dataSource);

		PlatformTransactionManager transactionManager = new DataSourceTransactionManager(initializeDataSource);
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

		CustomerService customerService = new TransactionTemplateCustomerService(initializeDataSource, transactionTemplate);

		Demo.workWithCustomerService(Application.class, customerService);
	}
}
