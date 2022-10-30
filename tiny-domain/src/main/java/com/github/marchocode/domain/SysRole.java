package com.github.marchocode.domain;

import com.github.marchocode.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sys_role")
@Getter
@Setter
public class SysRole extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<SysUser> users;

    @ManyToMany
    @JoinTable(name = "sys_role_menu", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    )
    private Set<SysMenu> menus;
}
