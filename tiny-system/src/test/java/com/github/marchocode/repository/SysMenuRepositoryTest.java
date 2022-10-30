package com.github.marchocode.repository;

import com.github.marchocode.domain.SysMenu;
import com.github.marchocode.domain.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysMenuRepositoryTest {

    @Resource
    private SysMenuRepository sysMenuRepository;

    @Resource
    private SysRoleRepository sysRoleRepository;

    @Test
    public void test1() {

        SysMenu sysMenu = new SysMenu();

        sysMenu.setName("目录");
        sysMenu.setType(1);

        sysMenuRepository.save(sysMenu);
    }


    @Test
    public void test2() {

        SysRole sysRole = sysRoleRepository.findById(1l).get();

        List<SysMenu> all = sysMenuRepository.findAll();
        sysRole.setMenus(new HashSet<>(all));

        sysRoleRepository.save(sysRole);

    }


}