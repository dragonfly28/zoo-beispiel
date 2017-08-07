package de.muenchen.referenzarchitektur.example.zooverwaltung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZooverwaltungApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooverwaltungApplication.class, args);
    }
    
    
}
