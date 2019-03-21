package com.fj.forkJointest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * https://docs.spring.io/spring-statemachine/docs/2.0.3.RELEASE/reference/htmlsingle/#statemachine-config-states-junction
 */


@SpringBootApplication
@EnableScheduling
public class ForkJointestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ForkJointestApplication.class, args);
	}
}
