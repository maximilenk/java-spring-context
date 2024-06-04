package edu.school21.Service.application;

import edu.school21.Service.config.ApplicationConfig;
import edu.school21.Service.models.User;
import edu.school21.Service.repositories.UsersRepositoryJdbcImpl;
import edu.school21.Service.repositories.UsersRepositoryJdbcTemplateImpl;
import edu.school21.Service.services.UserServiceImpl;
import edu.school21.Service.services.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UsersService usersService = context.getBean("userServiceImpl", UserServiceImpl.class);
        usersService.signUp("aboba");
    }
}
