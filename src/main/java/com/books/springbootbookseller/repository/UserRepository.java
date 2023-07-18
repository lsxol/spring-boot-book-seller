package com.books.springbootbookseller.repository;

import com.books.springbootbookseller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
