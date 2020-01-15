package com.yq.shiro.config;

import com.yq.shiro.entity.Permissions;
import com.yq.shiro.entity.Role;
import com.yq.shiro.entity.User;
import com.yq.shiro.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p> 自义定Realm</p>
 * @author youq  2020/1/15 10:38
 */
public class SimpleRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // principals.getPrimaryPrincipal() 可以理解为 SecurityUtils.getSubject().getPrincipal()，
        // 下面方法返回对象的第一个参数，可以是用户名，也可以是用户对象。
        User user = (User) principals.getPrimaryPrincipal();
        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoles()) {
            simpleAuthorizationInfo.addRole(role.getName());
            for (Permissions permissions : role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permissions.getName());
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token.getPrincipal() == null) {
            return null;
        }
        String name = token.getPrincipal().toString();
        User user = loginService.getUserByName(name);
        if (user == null) {
            return null;
        } else {
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
    }

}
