package com.yq.jasypt.config.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>console 项目的数据库相关的配置</p>
 * @author youq  2018/3/2 10:49
 */
@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.yq.jasypt.repository"})
@EntityScan(basePackages = {"com.yq.jasypt.db", "org.springframework.data.jpa.convert.threeten"})
public class DbRepositoryConfig {

}
