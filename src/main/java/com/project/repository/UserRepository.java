package com.project.repository;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import com.project.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);

}
