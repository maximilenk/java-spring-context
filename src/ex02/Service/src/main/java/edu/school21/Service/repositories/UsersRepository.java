package edu.school21.Service.repositories;

import edu.school21.Service.models.User;

import java.util.Optional;

public interface UsersRepository<T> extends CrudRepository<T> {
    Optional<T> findByEmail(String email);
}
