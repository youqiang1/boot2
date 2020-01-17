package com.yq.ehcache.config;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Element;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p> 自定义缓存，可以加redis缓存</p>
 * @author youq  2020/1/16 16:38
 */
@Slf4j
public class MyEhCache implements Cache {

    private String name;

    private net.sf.ehcache.Cache ehCache;

    /**
     * 默认1h=1*60*60
     */
    private long liveTime = 60 * 60;

    private static final List<String> EHCACHE_ENABLE_KEY = new ArrayList<>() {
        {
            add("TestService");
        }
    };

    @Override
    public Object getNativeCache() {
        return this;
    }

    @Override
    public ValueWrapper get(Object key) {
        Boolean ehCacheFlag = ehCacheEnableCheck(key);
        if (ehCacheFlag) {
            Element value = ehCache.get(key);
            log.debug("Cache L1 (ehcache) {}, key :{}, value.size :{}", ehCache.getName() + ehCache.getGuid(), key, (value != null ? value.toString().length() : "null"));
            return (value != null ? new SimpleValueWrapper(value.getObjectValue()) : null);
        }
        return null;
    }

    private Boolean ehCacheEnableCheck(Object key) {
        for (String enableKey : EHCACHE_ENABLE_KEY) {
            if ((key.toString().contains(enableKey))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        if (ehCacheEnableCheck(key)) {
            ehCache.put(new Element(key, value));
        }
    }

    @Override
    public void evict(Object key) {
        log.debug("remove cache key: {}, cache: {}", key, ehCache.getName() + ehCache.getGuid());
        ehCache.remove(key);
    }

    @Override
    public void clear() {
        log.info("remove all cache");
        ehCache.removeAll();
    }

    public net.sf.ehcache.Cache getEhCache() {
        return ehCache;
    }

    public void setEhCache(net.sf.ehcache.Cache ehCache) {
        this.ehCache = ehCache;
    }

    public long getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(long liveTime) {
        this.liveTime = liveTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
