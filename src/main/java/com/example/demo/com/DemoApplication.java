package com.example.demo.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Source vid https://www.youtube.com/watch?v=vtPkZShrvXQ
 * Ideas: 
 * add JWT authentication
 * Make a docker compose file
 * gti bot with sonarquibe
 * https
 * rate limit requests 
 * 
 */

// docker: docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine
// docker start postgres-spring
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
