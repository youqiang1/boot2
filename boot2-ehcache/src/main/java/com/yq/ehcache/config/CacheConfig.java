package com.yq.ehcache.config;

import net.sf.ehcache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * <p> cache配置</p>
 * @author youq  2020/1/16 15:40
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public EhCacheManagerFactoryBean ehcacheManager() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("/ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        cacheManagerFactoryBean.setCacheManagerName("ehCacheManager");
        return cacheManagerFactoryBean;
    }

    @Bean
    public EhCacheFactoryBean minuteCacheFactoryBean() {
        EhCacheFactoryBean ehCacheFactoryBean = new EhCacheFactoryBean();
        ehCacheFactoryBean.setCacheName("minuteEhCache");
        ehCacheFactoryBean.setCacheManager(ehcacheManager().getObject());
        //缓存数据在失效前的允许闲置时间(单位:秒)，仅当eternal=false时使用，默认值是0表示可闲置时间
        //无穷大,若超过这个时间没有访问此Cache中的某个元素,那么此元素将被从Cache中清除
        ehCacheFactoryBean.setTimeToIdle(60);
        //缓存数据的总的存活时间（单位：秒），仅当eternal=false时使用，从创建开始计时，失效结束。
        ehCacheFactoryBean.setTimeToLive(60);
        return ehCacheFactoryBean;
    }

    @Bean
    public MyEhCache minuteCache() {
        MyEhCache myEhCache = new MyEhCache();
        myEhCache.setName("minuteCache");
        myEhCache.setLiveTime(60);
        myEhCache.setEhCache((Cache) minuteCacheFactoryBean().getObject());
        return myEhCache;
    }

    @Bean
    public EhCacheFactoryBean hourCacheFactoryBean() {
        EhCacheFactoryBean ehCacheFactoryBean = new EhCacheFactoryBean();
        ehCacheFactoryBean.setCacheName("hourEhCache");
        ehCacheFactoryBean.setCacheManager(ehcacheManager().getObject());
        //缓存数据在失效前的允许闲置时间(单位:秒)，仅当eternal=false时使用，默认值是0表示可闲置时间
        //无穷大,若超过这个时间没有访问此Cache中的某个元素,那么此元素将被从Cache中清除
        ehCacheFactoryBean.setTimeToIdle(3600);
        //缓存数据的总的存活时间（单位：秒），仅当eternal=false时使用，从创建开始计时，失效结束。
        ehCacheFactoryBean.setTimeToLive(3600);
        return ehCacheFactoryBean;
    }

    @Bean
    public MyEhCache hourCache() {
        MyEhCache myEhCache = new MyEhCache();
        myEhCache.setName("hourCache");
        myEhCache.setLiveTime(3600);
        myEhCache.setEhCache((Cache) hourCacheFactoryBean().getObject());
        return myEhCache;
    }

}
