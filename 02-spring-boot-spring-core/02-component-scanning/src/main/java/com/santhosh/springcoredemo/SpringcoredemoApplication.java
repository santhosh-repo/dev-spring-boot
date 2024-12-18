package com.santhosh.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(scanBasePackages = {"com.santhosh.util",
"com.santhosh.springcoredemo"})
 */
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
