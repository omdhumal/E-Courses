package com.orenda.lifesecure.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.orenda.lifesecure"})
public class WebAppConfig implements WebMvcConfigurer{
	
	  @Bean
	   public InternalResourceViewResolver resolver() {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setViewClass(JstlView.class);
	      resolver.setPrefix("/WEB-INF/jsp/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   }
	 
//	   @Bean
//	   public MessageSource messageSource() {
//	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
//	      source.setBasename("message");
//	      return source;
//	   }
	   @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/assets/");
	    }
	   


}
