package ru.itis.sem1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.sem1.Models.State;
import ru.itis.sem1.Models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User u set u.state = ?1 where u.id= ?2")
    void updateUserState(State state, Long id);
}