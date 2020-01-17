package com.yq.ehcache;

import com.yq.kernel.constants.GlobalConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * <p> main</p>
 * @author youq  2020/1/16 11:51
 */
@SpringBootApplication
public class BootEhcacheApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootEhcacheApplication.class);
        application.addListeners(new ApplicationPidFileWriter(GlobalConstants.PID_FILE_NAME));
        application.run(args);
    }

}
