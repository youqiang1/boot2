package com.yq.jasypt.config.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * <p> 配置</p>
 * @author youq  2020/1/21 14:10
 */
@Configuration
public class JasyptConfig {

    @Bean
    public StringEncryptor stringEncryptor(Environment environment) {
        return new JasyptStringEncryptor(environment);
    }

}
