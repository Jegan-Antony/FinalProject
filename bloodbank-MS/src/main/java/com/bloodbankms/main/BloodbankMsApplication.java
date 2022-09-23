package com.bloodbankms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan({ "com.bloodbankms" })
@EntityScan(basePackages = { "com.bloodbankms.entity" })
@EnableJpaRepositories("com.bloodbankms.dao")
public class BloodbankMsApplication {

	public static void main(String[] args) {

		SpringApplication.run(BloodbankMsApplication.class, args);

	}

}
