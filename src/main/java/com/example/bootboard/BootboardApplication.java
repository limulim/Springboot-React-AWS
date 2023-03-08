package com.example.bootboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class BootboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootboardApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfiguerer() {
		return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOriginPatterns();
		}
		};
	}
	
}
