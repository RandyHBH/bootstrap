package com.bartumeu.bootstrap.enable;

import com.bartumeu.bootstrap.BaseCustomerService;
import com.bartumeu.bootstrap.Customer;
import com.bartumeu.bootstrap.templates.TransactionTemplateCustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Collection;

@Service
@Transactional
public class TransactionalCustomerService extends BaseCustomerService {

	public TransactionalCustomerService(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public Collection<Customer> save(String... names) {
		return super.save(names);
	}

	@Override
	public Customer findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Collection<Customer> findAll() {
		return super.findAll();
	}
}
