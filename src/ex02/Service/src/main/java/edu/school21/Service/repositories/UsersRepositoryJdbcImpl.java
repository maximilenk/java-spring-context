package edu.school21.Service.repositories;

import edu.school21.Service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("usersRepositoryJdbcImpl")
public class UsersRepositoryJdbcImpl implements UsersRepository<User> {
    DataSource dataSource;

    @Autowired
    public UsersRepositoryJdbcImpl(@Qualifier("hikariDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<User> findById(Long id) {
        String query = "Select * from users where id = " + id +";";
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        String query = "Select * from users;";
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                userList.add(new User(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User entity) {
        String query = "insert into users(email, password) values ('"
                + entity.getEmail() + "', '" + entity.getPassword() + "');";
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User entity) {
        String query = "update users set email = '"
                + entity.getEmail() + "', password = '"
                + entity.getPassword() +"' where id = "
                + entity.getId() + ";";
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String query = "delete from users where id = " + id + ";";
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String query = "Select * from users where email = '" + email + "';";
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
