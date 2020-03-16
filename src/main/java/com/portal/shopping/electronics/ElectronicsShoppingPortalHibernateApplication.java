package com.portal.shopping.electronics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = {"com.portal.shopping.electronics.entity"})
@EnableJpaRepositories(basePackages = {"com.portal.shopping.electronics.repository"})
public class ElectronicsShoppingPortalHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicsShoppingPortalHibernateApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.portal.shopping.electronics")).build();
	}

}