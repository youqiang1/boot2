package com.yq.jasypt;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.yq.kernel.constants.GlobalConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * <p> main</p>
 * EnableEncryptableProperties 启动数据库加密功能
 * @author youq  2020/1/21 13:41
 */
@SpringBootApplication
@EnableEncryptableProperties
public class BootJasyptApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootJasyptApplication.class);
        application.addListeners(new ApplicationPidFileWriter(GlobalConstants.PID_FILE_NAME));
        application.run(args);
    }

}
