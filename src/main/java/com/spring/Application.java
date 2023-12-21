package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.PropertySource;
//@EnableHystrix
//@EnableCircuitBreaker
//@EnableHystrixDashboard
@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class }) 
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//s@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class })
@PropertySource("classpath:application.yml")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
