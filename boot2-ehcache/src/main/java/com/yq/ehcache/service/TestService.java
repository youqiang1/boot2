package com.yq.ehcache.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 测试</p>
 * @author youq  2020/1/16 11:52
 */
@Slf4j
@Service
public class TestService {

    @Cacheable(value = "minuteCache", keyGenerator = "cacheKeyGenerator")
    public List<String> getList(Integer param) {
        log.info("缓存一分钟：getList(), param: {}", param);
        List<String> list = Lists.newArrayListWithCapacity(3);
        list.add("1");
        list.add("2");
        list.add("3");
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}
        return list;
    }

    @CacheEvict(value = "minuteCache", keyGenerator = "cacheKeyGenerator")
    public void minuteEvictCache(String className, String methodName, Object... params) {
        log.info("evicting...");
    }

    @Cacheable(value = "minuteCache", keyGenerator = "cacheKeyGenerator")
    public List<String> getList2(Integer param) {
        log.info("缓存一分钟：getList2(), param: {}", param);
        List<String> list = Lists.newArrayListWithCapacity(3);
        list.add("11");
        list.add("22");
        list.add("33");
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}
        return list;
    }

    @Cacheable(value = "hourCache", keyGenerator = "cacheKeyGenerator")
    public List<String> getList3(Integer param) {
        log.info("缓存一小时：getList3(), param: {}", param);
        List<String> list = Lists.newArrayListWithCapacity(3);
        list.add("111");
        list.add("222");
        list.add("333");
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}
        return list;
    }

    @CacheEvict(value = "hourCache", keyGenerator = "cacheKeyGenerator")
    public void hourEvictCache(String className, String methodName, Object... params) {
        log.info("evicting...");
    }

}
