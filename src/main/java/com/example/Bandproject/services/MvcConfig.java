package com.example.Bandproject.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("Success");
        registry.addViewController("/").setViewName("Userpage");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/userpage").setViewName("Userpage");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/usersecretpage").setViewName("UserSecretPage");
    }

}