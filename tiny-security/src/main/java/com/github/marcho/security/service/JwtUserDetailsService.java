package com.github.marcho.security.service;

import com.github.marchocode.domain.SysUser;
import com.github.marchocode.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserRepository.findByUsername(username);

        if (Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("user not found");
        }

        return new User(username, sysUser.getPassword(), new ArrayList<>());
    }


}
