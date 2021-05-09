package com.bartumeu.bootstrap.basicdi;

import com.bartumeu.bootstrap.BaseCustomerService;

import javax.sql.DataSource;

public class DataSourceCustomerService extends BaseCustomerService {

	public DataSourceCustomerService(DataSource dataSource) {
		super(dataSource);
	}
}
