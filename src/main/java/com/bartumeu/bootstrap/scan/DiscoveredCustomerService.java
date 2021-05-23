package com.bartumeu.bootstrap.scan;

import com.bartumeu.bootstrap.templates.TransactionTemplateCustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Service
public class DiscoveredCustomerService extends TransactionTemplateCustomerService {

	public DiscoveredCustomerService(DataSource dataSource, TransactionTemplate transactionTemplate) {
		super(dataSource, transactionTemplate);
	}
}
