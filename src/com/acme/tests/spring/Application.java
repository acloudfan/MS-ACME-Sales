package com.acme.tests.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private AppName appName;

    @Bean
    public AppName getAppName(@Value("Application1") String appName){
        System.out.println("wtf");
        return () -> appName;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("apper : "+appName);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
