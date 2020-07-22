package com.project.config;

import com.project.pojo.Books;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.project.service")
public class ApplicationConfig {
    @Bean
    public Books getBook(){
        return new Books();
    }
//    @Bean
//    public BookServiceImpl getBookServiceImplConfig(){
//        return new BookServiceImpl();
//    }


}
