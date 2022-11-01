package com.github.marchocode.security.service;

import com.github.marchocode.domain.SysUser;
import com.github.marchocode.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service("userDetailsService")
@RequiredArgsConstructor
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername,用户={},尝试登录", username);
        SysUser sysUser = sysUserRepository.findByUsername(username);

        if (Objects.isNull(sysUser)) {
            log.error("loadUserByUsername,未查询到用户信息");
            throw new UsernameNotFoundException("user not found");
        }

        return new User(username, sysUser.getPassword(), new ArrayList<>());
    }


}
