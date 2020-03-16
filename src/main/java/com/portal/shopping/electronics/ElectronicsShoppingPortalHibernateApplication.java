package com.portal.shopping.electronics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ElectronicsShoppingPortalHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicsShoppingPortalHibernateApplication.class, args);
	}

}
