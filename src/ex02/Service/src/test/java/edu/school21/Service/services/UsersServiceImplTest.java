package edu.school21.Service.services;

import edu.school21.Service.config.TestApplicationConfig;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class UsersServiceImplTest  {
    static UsersService usersService;
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);

    @BeforeAll
    public static void init() {
        usersService = context.getBean("userServiceImpl", UserServiceImpl.class);
    }

    @Test
    void checkReturningParam() {
        Assertions.assertEquals(usersService.signUp("aboba"), "password");
    }
    @Test
    void checkException() {
        Assertions.assertThrows(RuntimeException.class, () -> usersService.signUp("aboba"));
    }



    @AfterAll
    public static void destroy() {
        context.close();
    }
}
