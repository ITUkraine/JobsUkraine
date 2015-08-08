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
	Environment env;

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("emf");
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] { "ua.com.jobsukraine.entity" });
		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaPropertyMap(hibernateProperties());
		return emf;
	}



	@Bean
	public PlatformTransactionManager transactionManager(
			final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager(
				emf);
		return transactionManager;
	}
    

	
	public Map<String, String> hibernateProperties() {
		Map<String, String> hibPro = new HashMap<>();
		hibPro.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
		hibPro.put("hibernate.dialect",	env.getProperty("hibernate.dialect"));
		hibPro.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return hibPro;
	}

}