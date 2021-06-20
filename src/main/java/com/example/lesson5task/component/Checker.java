package com.example.lesson5task.component;

import com.example.lesson5task.entity.Role;
import com.example.lesson5task.entity.User;
import com.example.lesson5task.entity.enums.RoleName;
import com.example.lesson5task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class Checker {

    @Autowired
    UserRepository userRepository;

    public boolean check(String role) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<User> byId = userRepository.findById(user.getId());

        if (byId.isPresent()) {
            Set<Role> roles = byId.get().getRoles();
            String position = byId.get().getPosition();
            if (role.equals(RoleName.ROLE_DIRECTOR.name())) {
                return false;
            }
            for (Role role1 : roles) {
                if (role.equals(RoleName.ROLE_MANAGER.name()) && role1.getName().name().equals(RoleName.ROLE_DIRECTOR.name())) {
                    return true;
                }
            }
        }
    }