package com.github.marchocode.repository;

import com.github.marchocode.domain.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysMenuRepository extends JpaRepository<SysMenu, Long>, JpaSpecificationExecutor<SysMenu> {

}
