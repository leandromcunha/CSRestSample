package br.com.cs.rs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"br.com.cs.rs.controller",
    "br.com.cs.rs.hander"})
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

}