package com.raj.FinalSalesken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.raj.FinalSalesken.Repository")
@ComponentScan(basePackages = {"com.raj.FinalSalesken"})
public class FinalSaleskenApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalSaleskenApplication.class, args);
	}

}
