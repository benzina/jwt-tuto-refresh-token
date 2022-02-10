package com.tuto.jwttutorefreshtoken.service;

import com.tuto.jwttutorefreshtoken.model.Role;
import com.tuto.jwttutorefreshtoken.model.User;
import com.tuto.jwttutorefreshtoken.repository.RoleRepository;
import com.tuto.jwttutorefreshtoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} in the database",user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} in the database",role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        log.info("adding role {} to user {}",roleName,username);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("get user by username {} from database",username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users from database");
        return userRepository.findAll();
    }
}
