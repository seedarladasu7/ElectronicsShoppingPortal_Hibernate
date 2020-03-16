package com.portal.shopping.electronics.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	@Autowired
	DataSource dataSource;

	@Bean
	@Primary
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan("com.portal.shopping.electronics.entity");
		sessionFactoryBean.setHibernateProperties(getHibernateConfiguration());
		return sessionFactoryBean;
	}

	private Properties getHibernateConfiguration() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager() throws IOException, ClassNotFoundException {
		HibernateTransactionManager txName = new HibernateTransactionManager();
		txName.setSessionFactory(sessionFactoryBean().getObject());
		// txName.setDataSource(dataSource);
		return txName;
	}

}
