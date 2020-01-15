package com.yq.shiro.service;

import com.yq.shiro.entity.User;

/**
 * <p> 登陆服务</p>
 * @author youq  2020/1/15 10:33
 */
public interface LoginService {

    User getUserByName(String username);

}
