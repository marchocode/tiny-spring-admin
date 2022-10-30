package com.github.marchocode.domain;

import com.github.marchocode.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sys_menu")
@Getter
@Setter
public class SysMenu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "menu_name")
    private String name;

    @Column(name = "menu_type")
    private Integer type;

    @ManyToMany(mappedBy = "menus")
    private Set<SysRole> roles;

    @Column(name = "menu_pid")
    private Long pid;

}
