package com.admiral.tsp.timesheetportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/403").setViewName("403");

        registry.addViewController("/register").setViewName("register");

        registry.addViewController("/reports").setViewName("forward:/reports/index.html");
    }

}
