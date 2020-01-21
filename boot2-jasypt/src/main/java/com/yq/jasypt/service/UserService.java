package com.yq.jasypt.service;

import com.yq.jasypt.db.User;
import com.yq.jasypt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> user service</p>
 * @author youq  2020/1/21 14:42
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
