package com.yq.jasypt.controller;

import com.yq.jasypt.service.UserService;
import com.yq.kernel.model.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> test</p>
 * @author youq  2020/1/21 14:43
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findUser")
    public ResultData<?> findUser() {
        return ResultData.success(userService.findAll());
    }

}
