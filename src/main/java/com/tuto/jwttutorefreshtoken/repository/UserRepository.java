package com.tuto.jwttutorefreshtoken.repository;

import com.tuto.jwttutorefreshtoken.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
