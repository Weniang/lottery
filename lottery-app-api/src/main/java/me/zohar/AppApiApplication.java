package me.zohar;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppApiApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppApiApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
	}

}
