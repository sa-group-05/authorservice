package com.iuh.nhom05.AuthorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class AuthorServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthorServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		// Return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/authors/**"))
				.apis(RequestHandlerSelectors.basePackage("com.iuh.nhom05"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Author Service API",
				"APIs for Author Service",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Nhóm 05", "fit.iuh.edu.vn", "a@b.com"),
				"API License",
				"fit.iuh.edu.vn",
				Collections.emptyList());
	}
}
