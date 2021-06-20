package com.example.lesson5task.component;

import com.example.lesson5task.entity.Company;
import com.example.lesson5task.entity.Role;
import com.example.lesson5task.entity.User;
import com.example.lesson5task.repository.CompanyRepository;
import com.example.lesson5task.repository.RoleRepository;
import com.example.lesson5task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner{

    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {

        if (initialMode.equals("always")){
            Set<Role> roles= new HashSet<>(roleRepository.findAll());
            User user = new User("Director", passwordEncoder.encode("1237"), "xusanov0999@gmail.com", roles, "director", true);
            User director = userRepository.save(user);
            Company company = new Company("Com", director);
        }


    }
}
