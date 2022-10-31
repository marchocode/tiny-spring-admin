package com.github.marcho.security.config;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;

@Component
public class JwtTokenUtil {

    private JwtBuilder jwtBuilder;

    @PostConstruct
    public void init() {
        jwtBuilder = Jwts.builder();
    }

    public String generateToken() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.ES256);
        return jwtBuilder.setSubject("Bob").signWith(key).compact();
    }

}
