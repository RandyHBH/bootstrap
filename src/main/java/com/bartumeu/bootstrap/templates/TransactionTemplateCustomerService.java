package com.bartumeu.bootstrap.templates;

import com.bartumeu.bootstrap.BaseCustomerService;
import com.bartumeu.bootstrap.Customer;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class TransactionTemplateCustomerService extends BaseCustomerService {

	private final TransactionTemplate transactionTemplate;

	public TransactionTemplateCustomerService(DataSource dataSource, TransactionTemplate transactionTemplate) {
		super(dataSource);
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public Collection<Customer> save(String... names) {
		return this.transactionTemplate.execute(status -> super.save(names));
	}

	@Override
	public Customer findById(Long id) {
		return transactionTemplate.execute(status -> super.findById(id));
	}

	@Override
	public Collection<Customer> findAll() {
		return transactionTemplate.execute(status -> super.findAll());
	}
}
