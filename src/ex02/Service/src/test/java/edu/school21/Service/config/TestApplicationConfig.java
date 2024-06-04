package edu.school21.Service.config;

import edu.school21.Service.models.User;
import edu.school21.Service.repositories.UsersRepository;
import edu.school21.Service.repositories.UsersRepositoryJdbcImpl;
import edu.school21.Service.services.UserServiceImpl;
import edu.school21.Service.services.UsersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class TestApplicationConfig {
    @Bean
    public DataSource embeddedDataBase() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .build();
    }

    @Bean
    public UsersRepository<User> usersRepositoryJdbcImpl() {
        return new UsersRepositoryJdbcImpl(embeddedDataBase());
    }

    @Bean
    public UsersService userServiceImpl() {
        return new UserServiceImpl(usersRepositoryJdbcImpl());
    }
}
