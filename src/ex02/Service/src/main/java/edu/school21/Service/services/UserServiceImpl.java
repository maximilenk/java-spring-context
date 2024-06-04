package edu.school21.Service.services;

import edu.school21.Service.models.User;
import edu.school21.Service.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("userServiceImpl")
public class UserServiceImpl implements UsersService {

    UsersRepository<User> usersRepository;

    @Autowired
    public UserServiceImpl(@Qualifier("usersRepositoryJdbcTemplateImpl") UsersRepository<User> usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public String signUp(String email) {
        if (usersRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("email is used by another user");
        }
        User user = new User(1L, email, "password");
        usersRepository.save(user);
        return user.getPassword();
    }
}
