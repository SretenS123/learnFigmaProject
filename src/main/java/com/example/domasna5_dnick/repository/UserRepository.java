package com.example.domasna5_dnick.repository;

import com.example.domasna5_dnick.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsernameAndPassword(String name, String passwrd);
    Optional<User> findByUsername(String name);

}
