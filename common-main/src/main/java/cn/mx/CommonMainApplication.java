package cn.mx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/**
 * @author SSS
 * @class CommonMainApplication
 * @create 2023/3/30 17:41
 */

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class CommonMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonMainApplication.class, args);
    }
}
