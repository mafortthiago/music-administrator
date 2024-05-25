package com.music.administrator;

import com.music.administrator.principal.Screen;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdministratorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdministratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Screen main = new Screen();
		main.menu();
	}
}
