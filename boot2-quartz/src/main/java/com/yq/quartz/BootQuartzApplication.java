package com.yq.quartz;

import com.yq.kernel.constants.GlobalConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * <p> main</p>
 * @author youq  2020/1/21 15:37
 */
@SpringBootApplication
public class BootQuartzApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootQuartzApplication.class);
        application.addListeners(new ApplicationPidFileWriter(GlobalConstants.PID_FILE_NAME));
        application.run(args);
    }

}
