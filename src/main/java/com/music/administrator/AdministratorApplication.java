package com.music.administrator;

import com.music.administrator.principal.Screen;
import com.music.administrator.repository.ArtistRepository;
import com.music.administrator.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdministratorApplication implements CommandLineRunner {
	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private MusicRepository musicRepository;
	public static void main(String[] args) {
		SpringApplication.run(AdministratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Screen main = new Screen(artistRepository, musicRepository);
		main.menu();
	}
}
