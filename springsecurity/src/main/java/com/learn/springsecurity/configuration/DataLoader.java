package com.learn.springsecurity.configuration;

import com.learn.springsecurity.entity.User;
import com.learn.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
        	User admin = User.builder()
        	        .username("admin")
        	        .password(passwordEncoder.encode("admin123"))
        	        .role("ADMIN")
        	        .build();


            User user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("user123"))
                    .role("USER")
                    .build();

            userRepository.save(admin);
            userRepository.save(user);
        }
    }
}
