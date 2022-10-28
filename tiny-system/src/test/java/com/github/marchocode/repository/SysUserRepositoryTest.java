package com.github.marchocode.repository;

import com.github.marchocode.domain.SysRole;
import com.github.marchocode.domain.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class SysUserRepositoryTest {

    @Autowired
    private SysUserRepository userRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Test
    public void save() {
        SysUser user = new SysUser();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setCreateBy("mrc");

        userRepository.save(user);
    }


    @Test
    public void saveAndRole() {

        SysUser user = new SysUser();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setCreateBy("mrc");

        SysRole role1 = new SysRole();
        role1.setName("111");

        SysRole role2 = new SysRole();
        role2.setName("222");

        Set<SysRole> set = new HashSet<>();
        set.add(role1);
        set.add(role2);

        sysRoleRepository.saveAll(set);

        user.setRoles(set);

        userRepository.save(user);
    }


}
