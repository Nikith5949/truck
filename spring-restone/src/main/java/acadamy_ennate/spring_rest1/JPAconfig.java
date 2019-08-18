package acadamy_ennate.spring_rest1;


import java.util.Properties;

import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;

import org.hibernate.boot.model.relational.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAconfig {

	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean emf= new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("acadamy_ennate.spring_rest1.entity");
		Properties prop=new Properties();
		prop.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		prop.put("hibernate.hbm2ddl.auto","validate");
		prop.put("hibernate.show_sql","true");
		emf.setJpaProperties(prop);
	return emf;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/hibe");
		ds.setUsername("Nikith");
		ds.setPassword("");
		return  ds;
		
		
	}
	@Bean
	public PlatformTransactionManager txManager(EntityManagerFactory emf) {
		JpaTransactionManager txm=new JpaTransactionManager(emf);
		return txm;
		
	}
}
