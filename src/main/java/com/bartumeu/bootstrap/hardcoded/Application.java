package com.bartumeu.bootstrap.hardcoded;

import com.bartumeu.bootstrap.Demo;

public class Application {
	public static void main(String[] args) {
		DevelopmentOnlyCustomerService customerService = new DevelopmentOnlyCustomerService();
		Demo.workWithCustomerService(Application.class, customerService);
	}
}
