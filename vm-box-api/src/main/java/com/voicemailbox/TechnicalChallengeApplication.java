package com.voicemailbox;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.voicemailbox.util.InitialData;

@SpringBootApplication
public class TechnicalChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalChallengeApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(InitialData initialData) {
		return args -> {
			initialData.addLoginData();
			initialData.addVoicemailData();
		};
	}

}
