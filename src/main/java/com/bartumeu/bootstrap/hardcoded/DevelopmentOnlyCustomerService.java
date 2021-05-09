package com.bartumeu.bootstrap.hardcoded;

import com.bartumeu.bootstrap.BaseCustomerService;
import com.bartumeu.bootstrap.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

public class DevelopmentOnlyCustomerService extends BaseCustomerService {

	public DevelopmentOnlyCustomerService() {
		super(setupDataSource());
	}

	private static DataSource setupDataSource() {
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(H2).build();
		return DataSourceUtils.initializeDdl(dataSource);
	}


}
