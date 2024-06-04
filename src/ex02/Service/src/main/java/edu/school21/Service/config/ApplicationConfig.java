package edu.school21.Service.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("edu.school21.Service")
@PropertySource("classpath:db.properties")
public class ApplicationConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource hikariDataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public DataSource driverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setPassword(env.getRequiredProperty("db.password"));
        dataSource.setUsername(env.getRequiredProperty("db.user"));
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver.name"));
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        return dataSource;
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setUsername(env.getRequiredProperty("db.user"));
        config.setPassword(env.getRequiredProperty("db.password"));
        config.setJdbcUrl(env.getRequiredProperty("db.url"));
        return config;
    }
}
