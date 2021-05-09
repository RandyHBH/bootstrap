package com.bartumeu.bootstrap.context;

import com.bartumeu.bootstrap.CustomerService;
import com.bartumeu.bootstrap.DataSourceConfiguration;
import com.bartumeu.bootstrap.Demo;
import com.bartumeu.bootstrap.SpringUtils;
import com.bartumeu.bootstrap.templates.TransactionTemplateCustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfiguration.class)
public class Application {

	public static void main(String[] args) {

		ApplicationContext ac = SpringUtils.run(Application.class, "prod");

		CustomerService cs = ac.getBean(CustomerService.class);
		Demo.workWithCustomerService(Application.class, cs);
	}

	@Bean
	PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
		return new TransactionTemplate(transactionManager);
	}

	@Bean
	TransactionTemplateCustomerService customerService(DataSource dataSource, TransactionTemplate transactionTemplate) {
		return new TransactionTemplateCustomerService(dataSource, transactionTemplate);
	}
}
