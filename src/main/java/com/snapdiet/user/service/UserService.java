package com.snapdiet.user.service;

import com.snapdiet.user.domain.User;
import com.snapdiet.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // 사용자 이름 중복 체크
    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username) != null;
    }

    // 사용자 저장 (비밀번호 암호화)
    public void saveUser(User user) {
        // 비밀번호를 BCrypt로 암호화
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}