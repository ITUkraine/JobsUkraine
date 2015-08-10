package ua.com.jobsukraine.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ua.com.jobsukraine.repository")
@PropertySource("classpath:app.properties")
public class JPAConfig {

	@Autowired
	Environment environment;

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		driverManagerDataSource.setUrl(environment.getProperty("jdbc.url"));
		driverManagerDataSource.setUsername(environment.getProperty("jdbc.user"));
		driverManagerDataSource.setPassword(environment.getProperty("jdbc.pass"));
		return driverManagerDataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setPersistenceUnitName("localContainerEntityManagerFactoryBean");
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setPackagesToScan(new String[] { "ua.com.jobsukraine.entity" });
		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		localContainerEntityManagerFactoryBean.setJpaPropertyMap(hibernateProperties());
		return localContainerEntityManagerFactoryBean;
	}



	@Bean
	public PlatformTransactionManager transactionManager(
			final EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager(
				entityManagerFactory);
		return transactionManager;
	}
    

	
	public Map<String, String> hibernateProperties() {
		Map<String, String> hibernateProperties = new HashMap<>();
		hibernateProperties.put("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.put("hibernate.dialect",	environment.getProperty("hibernate.dialect"));
		hibernateProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		hibernateProperties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		hibernateProperties.put("hibernate.enable_lazy_load_no_trans", environment.getProperty("hibernate.enable_lazy_load_no_trans"));
		return hibernateProperties;
	}

}