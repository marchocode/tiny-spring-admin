package com.github.marcho.security.rest;

import com.github.marcho.security.pojo.AuthUserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/login")
    public ResponseEntity login(@Validated @RequestBody AuthUserVO userVO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userVO.getUsername(), userVO.getPassword())
        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authenticate);
    }

    @DeleteMapping("/logout")
    public ResponseEntity logout() {
        return null;
    }

    @GetMapping("/info")
    public ResponseEntity info() {
        return null;
    }


}
