package com.iuh.nhom05.AuthorService.controller;

import com.iuh.nhom05.AuthorService.entities.User;
import com.iuh.nhom05.AuthorService.jwt.JWTProvider;
import com.iuh.nhom05.AuthorService.repository.UserRepository;
import com.iuh.nhom05.AuthorService.user.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("")
    public String login(@RequestBody User user){
        User databaseUser = userRepository.findUserByUsername(user.getUsername());

        if(passwordEncoder.matches(user.getPassword(), databaseUser.getPassword())) {
            return jwtProvider.generateToken(new MyUserDetail(databaseUser));
        }

        return null;
    }
}
