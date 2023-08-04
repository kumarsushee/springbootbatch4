package com.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages ={"com.springbootapplication.model"})
@EnableDiscoveryClient
public class SpringbootapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapplicationApplication.class, args);
	}

}
