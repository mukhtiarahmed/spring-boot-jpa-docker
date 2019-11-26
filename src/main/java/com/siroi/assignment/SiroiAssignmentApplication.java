package com.siroi.assignment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class SiroiAssignmentApplication extends SpringBootServletInitializer {

	@Value("${image.dir}")
	private String imageDir;

	public static void main(String[] args) throws Exception {	
		SpringApplication.run(SiroiAssignmentApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SiroiAssignmentApplication.class);
	}




}
