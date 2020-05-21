package com.stackroute.keepnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
 @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

 *
 * 
 * @ComponentScan({"com.stackroute.keepnote"})
 * 
 * @EnableJpaRepositories("com.stackroute.keepnote.repository")
 */

@SpringBootApplication
public class UserAuthenticationServiceApplication {




    public static void main(String[] args) {
        SpringApplication.run(UserAuthenticationServiceApplication.class, args);
    }
}
