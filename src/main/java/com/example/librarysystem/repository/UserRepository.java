package com.example.librarysystem.repository;

import com.example.librarysystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User , Long> {

    Optional<User> getByFinCode(String finCode);

}
