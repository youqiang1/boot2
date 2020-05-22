package com.yq.test;

import com.yq.kernel.constants.GlobalConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * <p> main</p>
 * @author youq  2020/1/15 15:43
 */
@SpringBootApplication
public class BootTestApplication {

    private static Logger log = LogManager.getLogger(BootTestApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootTestApplication.class);
        application.addListeners(new ApplicationPidFileWriter(GlobalConstants.PID_FILE_NAME));
        log.info("log4j2");
        application.run(args);
    }

}
