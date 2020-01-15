package com.yq.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * <p> 角色信息</p>
 * @author youq  2020/1/15 10:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private String id;

    private String name;

    private Set<Permissions> permissions;

}
