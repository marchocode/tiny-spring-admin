package com.github.marchocode.security.config;

import com.github.marchocode.security.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class JwtTokenUtilTest {

    @Autowired
    private JwtService jwtTokenUtilTest;

    @Test
    public void test1() {

        String token = jwtTokenUtilTest.generateToken(null);
        jwtTokenUtilTest.getUserinfo(token);

    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test2() {
        String password = passwordEncoder.encode("123456");
        // $2a$10$uZ5DnjGobHaQpB2gY5RGi.mfCZ7G73MHD4d0GL7eCCOZpnVAyn2P2
        System.out.println(password);
    }


}