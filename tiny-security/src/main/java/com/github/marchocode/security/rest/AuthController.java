package com.github.marchocode.security.rest;

import com.github.marchocode.security.pojo.AuthUserVO;
import com.github.marchocode.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@Validated @RequestBody AuthUserVO userVO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userVO.getUsername(), userVO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        String token = jwtService.generateToken(authenticate);
        return ResponseEntity.ok(token);
    }

    @DeleteMapping("/logout")
    public ResponseEntity logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok(null);
    }

    @GetMapping("/info")
    public ResponseEntity info() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getDetails();
        return ResponseEntity.ok(obj);
    }


}
