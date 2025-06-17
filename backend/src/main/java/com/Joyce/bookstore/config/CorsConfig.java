package com.Joyce.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    public CorsConfig() {
        System.out.println("CorsConfig class is being instantiated!");
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                System.out.println("corsConfigurer bean is being created!");

                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173","http://localhost:5174","http://localhost:8080", "https://online-bookstore-one.vercel.app") // 允許來自 local 伺服器的請求
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
