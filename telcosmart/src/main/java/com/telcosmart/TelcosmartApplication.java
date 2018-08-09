package com.telcosmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.telcosmart.model.Profile;


/**
 * 
 * @author Kumaraswami Hosuru
 *
 */
//@EnableJpaAuditing
@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackageClasses = Profile.class)
public class TelcosmartApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelcosmartApplication.class, args);
	}
}
