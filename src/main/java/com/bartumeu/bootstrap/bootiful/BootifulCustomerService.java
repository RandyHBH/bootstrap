package com.bartumeu.bootstrap.bootiful;

import com.bartumeu.bootstrap.enable.TransactionalCustomerService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class BootifulCustomerService extends TransactionalCustomerService {

	BootifulCustomerService(DataSource dataSource) {
		super(dataSource);
	}

}
