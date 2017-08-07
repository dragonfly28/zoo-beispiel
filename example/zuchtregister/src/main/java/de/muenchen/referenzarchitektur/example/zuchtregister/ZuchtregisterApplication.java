package de.muenchen.referenzarchitektur.example.zuchtregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuchtregisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuchtregisterApplication.class, args);
    }
    
    
}
