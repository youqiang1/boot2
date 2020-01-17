package com.yq.ehcache.config;

import com.yq.kernel.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <p> 自定义cache key生成器</p>
 * @author youq  2020/1/16 16:30
 */
@Slf4j
@Component
public class CacheKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        char sp = ':';
        StringBuilder key = new StringBuilder();
        if (!method.getName().contains("EvictCache")) {
            key.append(target.getClass().getName());
            key.append(sp);
            key.append(method.getName());
            key.append(sp);
        }
        if (params.length > 0) {
            for (Object o : params) {
                if (BeanHelper.isSimpleValueType(o.getClass())) {
                    key.append(o);
                } else {
                    key.append(ObjectUtils.toJson(o));
                }
                key.append(sp);
            }
        } else {
            key.append("0:");
        }
        String returns = key.substring(0, key.length() - 1);
        log.debug("generate key: {}", returns);
        return returns;
    }

}
