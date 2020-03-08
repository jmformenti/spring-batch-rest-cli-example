package org.atypical.batchrest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.chrisgleissner.springbatchrest.api.EnableSpringBatchRest;

@SpringBootApplication
@EnableSpringBatchRest
public class BatchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchApiApplication.class, args);
	}
}