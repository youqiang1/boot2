package com.yq.ehcache.controller;

import com.yq.ehcache.service.TestService;
import com.yq.kernel.model.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p> 测试</p>
 * @author youq  2020/1/16 11:55
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/minute")
    public ResultData<?> minute() {
        long st = System.currentTimeMillis();
        List<String> list = testService.getList(1);
        log.info("缓存一分钟方法请求耗时：{}", System.currentTimeMillis() - st);
        return ResultData.success(list);
    }

    @RequestMapping("/minute2")
    public ResultData<?> minute2() {
        long st = System.currentTimeMillis();
        List<String> list = testService.getList2(2);
        log.info("缓存一分钟方法2请求耗时：{}", System.currentTimeMillis() - st);
        return ResultData.success(list);
    }

    @RequestMapping("/hour")
    public ResultData<?> hour() {
        long st = System.currentTimeMillis();
        List<String> list = testService.getList3(3);
        log.info("缓存一小时方法请求耗时：{}", System.currentTimeMillis() - st);
        return ResultData.success(list);
    }

    @RequestMapping("evictCache")
    public ResultData<?> evictCache(String methodName, String param) {
        long st = System.currentTimeMillis();
        testService.minuteEvictCache("com.yq.ehcache.service.TestService", methodName, param);
        log.info("清除缓存完成，耗时：{}", System.currentTimeMillis() - st);
        return ResultData.success();
    }

    @RequestMapping("hourEvictCache")
    public ResultData<?> hourEvictCache(String methodName, String param) {
        long st = System.currentTimeMillis();
        testService.hourEvictCache("com.yq.ehcache.service.TestService", methodName, param);
        log.info("清除缓存完成，耗时：{}", System.currentTimeMillis() - st);
        return ResultData.success();
    }

}
