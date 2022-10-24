package com.github.marchocode.repository;

import com.github.marchocode.domain.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysUserRepositoryTest {

    @Autowired
    private SysUserRepository userRepository;

    @Test
    public void save() {
        SysUser user = new SysUser();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setCreateBy("mrc");

        userRepository.save(user);
    }

}
