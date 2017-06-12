package com.viniweb.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.viniweb.boot"})
public class FootBallTeamsApp {

	public static void main(String[] args) {
		SpringApplication.run(FootBallTeamsApp.class, args);
	}
}
