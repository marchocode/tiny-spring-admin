package com.github.marchocode.security.config;

import com.github.marcho.security.config.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JwtTokenUtilTest {

    @Autowired
    private JwtTokenUtil jwtTokenUtilTest;

    @Test
    public void test1() {

        String token = jwtTokenUtilTest.generateToken();
        System.out.printf(token);

    }


}