package br.com.cs.rs.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.cs.rs.repository", entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
public class PersistenceConfig {

    private static final String JNDI_JAVA_DATASOURCES = "java:jboss/datasources/MicroServiceDS";

    @Bean
    public DataSource datasource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/microservicedb");
        ds.setUsername("postgres");
        ds.setPassword("postgres");
        return ds;

    }

    // @Bean
    public DataSource dataSource()
        throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName(JNDI_JAVA_DATASOURCES);
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
        jndiObjectFactoryBean.afterPropertiesSet();
        return (DataSource) jndiObjectFactoryBean.getObject();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
                    final DataSource ds) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(ds);
        emfb.setPackagesToScan("br.com.cs.rs");
        emfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        Properties jpaProterties = new Properties();
        // jpaProterties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        jpaProterties.put("hibernate.dialect",
                        "org.hibernate.dialect.PostgreSQLDialect");
        jpaProterties.put("hibernate.format_sql", true);
        jpaProterties.put("hibernate.show_sql", true);
        // jpaProterties.put("hibernate.default_schema", "public");
        // jpaProterties.put("hibernate.hbm2ddl.auto", "create-drop");
        jpaProterties.put("javax.persistence.schema-generation.database.action",
                        "drop-and-create");
        emfb.setJpaProperties(jpaProterties);
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(
                    final EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
