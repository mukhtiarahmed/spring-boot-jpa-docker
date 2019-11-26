package com.siroi.assignment.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author Mukhtiar Ahmed
 */
@Configuration
public class DatabaseConfig {

  @Autowired
  private Environment environment;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(environment.getProperty("spring.datasource.url"));
    dataSource.setUsername(environment.getProperty("spring.datasource.username"));
    dataSource.setPassword(environment.getProperty("spring.datasource.password"));
    return dataSource;

  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    EntityManagerFactory factory = entityManagerFactory();
    return new JpaTransactionManager(factory);
  }

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(Boolean.TRUE);
    vendorAdapter.setShowSql(Boolean.TRUE);
    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL9Dialect");
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("com.siroi.assignment");
    factory.setDataSource(dataSource());
    factory.afterPropertiesSet();
    factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
    return factory.getObject();
  }

  @Bean
  public HibernateExceptionTranslator hibernateExceptionTranslator() {
    return new HibernateExceptionTranslator();
  }
}
