package com.yq.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * <p> 用户信息</p>
 * @author youq  2020/1/15 10:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;

    private String username;

    private String password;

    private Set<Role> roles;

}
