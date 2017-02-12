package com.xiao.geeker.springbatchboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.xiao.geeker.springbatchboot.config.MainConfiguration;

@Configuration
@EnableAutoConfiguration(exclude = { /*BatchAutoConfiguration.class, DataSourceAutoConfiguration.class,*/
		WebMvcAutoConfiguration.class })
@Import(MainConfiguration.class)
public class SpringBatchAdmin extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchAdmin.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}
	
	private static Class<SpringBatchAdmin> applicationClass = SpringBatchAdmin.class;


}
