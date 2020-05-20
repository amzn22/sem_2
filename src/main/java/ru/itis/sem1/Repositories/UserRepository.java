package ru.itis.sem1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.sem1.Models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByUuid(String uuid);

    Optional<User> findUserByUsername(String username);
}