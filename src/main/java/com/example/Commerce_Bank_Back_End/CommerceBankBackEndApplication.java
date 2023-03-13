package com.example.Commerce_Bank_Back_End;

import com.example.Commerce_Bank_Back_End.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class CommerceBankBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceBankBackEndApplication.class, args);
	}

}
