package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * Max Upload File Size Configure
     * MaxFileSize = 10Kb
     * MaxRequestSize = 1Mb
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //MaxFileSize
        factory.setMaxFileSize("10KB"); //KB,MB
        //MaxRequestSize
        factory.setMaxRequestSize("1024KB");
        return factory.createMultipartConfig();
    }
}
