package com.yq.shiro;

import com.yq.kernel.constants.GlobalConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * <p> main</p>
 * @author youq  2020/1/10 15:06
 */
@SpringBootApplication
public class BootShiroApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootShiroApplication.class);
        application.addListeners(new ApplicationPidFileWriter(GlobalConstants.PID_FILE_NAME));
        application.run(args);
    }

}
