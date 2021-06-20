package com.example.lesson5task.service;

import com.example.lesson5task.component.Checker;
import com.example.lesson5task.component.MailSender;
import com.example.lesson5task.component.PasswordGenerator;
import com.example.lesson5task.entity.Role;
import com.example.lesson5task.entity.User;
import com.example.lesson5task.payload.ApiResponse;
import com.example.lesson5task.payload.UserDto;
import com.example.lesson5task.repository.RoleRepository;
import com.example.lesson5task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    Checker checker;

    @Autowired
    PasswordGenerator passwordGenerator;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MailSender mailSender;

    public ApiResponse add(UserDto userDto) throws MessagingException {
        Optional<Role> byId = roleRepository.findById(userDto.getRoleId());
        if (!byId.isPresent()) return new ApiResponse("Role topilmadi", false);
        boolean check = checker.check(byId.get().getName().name());

        if (!check) {
            return new ApiResponse("you do not access", false);
        }

        boolean b = userRepository.existsByEmail(userDto.getEmail());
        if (b) return new ApiResponse("already exists", false);

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPosition(userDto.getPosition());

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(byId.get());
        user.setRoles(roleSet);

        String password = passwordGenerator.genRandomPassword(10);
        user.setPassword(passwordEncoder.encode(password));
        String code = UUID.randomUUID().toString();
        user.setVerifyCode(code);

        userRepository.save(user);

        boolean b1 = mailSender.mailTextAddStuff(userDto.getEmail(), code, password);

        if (b1){
            return new ApiResponse("qoshildi", true);
        }

        return new ApiResponse("xatolik", false);

    }

}
