package com.github.marchocode.security.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class JwtService {

    private JwtBuilder jwtBuilder;
    private JwtParser jwtParser;

    @PostConstruct
    public void init() {
        String security = "NzBiNGIwOGQ4ZTc1NTBmOGY1MmE5NDU1YTUxMDM1NTRlMDJiNjBkZGZlYTJkMDc3NDdkNTRlMzcxNDExNjM0MjkyMDhkZDJmODc5NmJiNjEzZTgyM2ZjZjRhZTc0NTU3NzFiZjM0MTUwMzU5MmE2M2IzMGJkNmFjODc4NGZjNzA=";
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(security));

        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String generateToken(Authentication authentication) {
        return jwtBuilder.setId(UUID.randomUUID().toString()).setSubject(authentication.getName()).compact();
    }

    public Authentication getUserinfo(String token) {
        String subject = jwtParser.parseClaimsJws(token).getBody().getSubject();
        return new UsernamePasswordAuthenticationToken(subject, "*******", new ArrayList<>());
    }


}
