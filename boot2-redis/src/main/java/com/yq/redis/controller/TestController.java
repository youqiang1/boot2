package com.yq.redis.controller;

import com.yq.kernel.model.ResultData;
import com.yq.redis.util.RedisService;
import com.yq.redis.util.SsoRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> test</p>
 * @author youq  2019/12/31 9:21
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private SsoRedisService ssoRedisService;

    private static final String KEY = "boot2_redis_test";

    @RequestMapping("/add2")
    public ResultData<?> add2(String value) {
        ssoRedisService.set(KEY, value);
        return ResultData.success();
    }

    @RequestMapping("/get2")
    public ResultData<?> get2() {
        return ResultData.success(ssoRedisService.getStr(KEY));
    }

    @RequestMapping("/add")
    public ResultData<?> add(String value) {
        redisService.set(KEY, value);
        return ResultData.success();
    }

    @RequestMapping("/get")
    public ResultData<?> get() {
        return ResultData.success(redisService.getStr(KEY));
    }

    @RequestMapping("/test")
    public void test() {
        log.info("test...");
    }

}
