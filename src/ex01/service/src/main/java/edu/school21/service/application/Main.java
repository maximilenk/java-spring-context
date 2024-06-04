package edu.school21.service.application;

import edu.school21.service.models.User;
import edu.school21.service.repositories.UsersRepositoryJdbcImpl;
import edu.school21.service.repositories.UsersRepositoryJdbcTemplateImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws NoSuchFieldException, IllegalAccessException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UsersRepositoryJdbcImpl repositoryJdbc = context.getBean("usersRepositoryJdbcImpl", UsersRepositoryJdbcImpl.class);
        repositoryJdbc.save(new User(1L, "asd"));
        repositoryJdbc.save(new User(1L, "dsa"));
        repositoryJdbc.save(new User(1L, "das"));
        System.out.println(repositoryJdbc.findAll().toString());
        UsersRepositoryJdbcTemplateImpl repositoryJdbcTemplate
                = context.getBean("usersRepositoryJdbcTemplateImpl", UsersRepositoryJdbcTemplateImpl.class);
        User u = repositoryJdbcTemplate.findById(1L).get();
        u.setEmail("updatedEmail");
        repositoryJdbcTemplate.update(u);
        repositoryJdbcTemplate.save(new User(5L, "secondDB"));
        System.out.println();
        System.out.println(repositoryJdbcTemplate.findAll().toString());
        context.close();
    }
}
