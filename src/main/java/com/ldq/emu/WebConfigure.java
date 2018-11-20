package com.ldq.emu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ldq.emu.interceptor.LoginInterceptor;

@Configuration
public class WebConfigure implements WebMvcConfigurer{
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	@Autowired
	private SecurityUrl securityurl;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
		.excludePathPatterns(securityurl.getSkipUrl());
		//.excludePathPatterns("/logindialog.html","/userLogin","/webjars/**");
		WebMvcConfigurer.super.addInterceptors(registry);
		
	}
	
	@Bean
	@ConfigurationProperties(prefix="securityurl")
	public SecurityUrl securityurl() {
		//spring-boot-configuration-processor
		return new SecurityUrl();
	}
}
