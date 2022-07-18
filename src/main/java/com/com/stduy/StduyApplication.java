package com.com.stduy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger-ui/index.html
 */
@EnableSwagger2
@SpringBootApplication
public class StduyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StduyApplication.class, args);
    }

}
