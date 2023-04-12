package cn.mx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.net.InetAddress;

/**
 * @author SSS
 * @class CommonMainApplication
 * @create 2023/3/30 17:41
 */

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class CommonMainApplication {

    public static void main(String[] args) {

        try {
            ConfigurableApplicationContext application = SpringApplication.run(CommonMainApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
