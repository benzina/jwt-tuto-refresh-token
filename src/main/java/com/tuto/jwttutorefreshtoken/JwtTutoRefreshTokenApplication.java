package com.tuto.jwttutorefreshtoken;

import com.tuto.jwttutorefreshtoken.model.Role;
import com.tuto.jwttutorefreshtoken.model.User;
import com.tuto.jwttutorefreshtoken.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtTutoRefreshTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtTutoRefreshTokenApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
          userService.saveRole(new Role(null,"ROLE_USER"));
          userService.saveRole(new Role(null,"ROLE_MANAGER"));
          userService.saveRole(new Role(null,"ROLE_ADMIN"));
          userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

          userService.saveUser(new User(null,"benzina elmahdi","elmahdi","1234",new ArrayList<>()));
          userService.saveUser(new User(null,"benzina saad","saad","1234",new ArrayList<>()));
          userService.saveUser(new User(null,"benzina ayoub","ayoub","1234",new ArrayList<>()));
          userService.saveUser(new User(null,"benzina samira","samira","1234",new ArrayList<>()));

          userService.addRoleToUser("elmahdi","ROLE_MANAGER");
          userService.addRoleToUser("elmahdi","ROLE_ADMIN");
          userService.addRoleToUser("elmahdi","ROLE_SUPER_ADMIN");
          userService.addRoleToUser("elmahdi","ROLE_USER");
          userService.addRoleToUser("samira","ROLE_USER");
          userService.addRoleToUser("saad","ROLE_ADMIN");
          userService.addRoleToUser("ayoub","ROLE_SUPER_ADMIN");
        };
    }

}
