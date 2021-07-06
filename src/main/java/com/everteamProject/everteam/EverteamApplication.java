package com.everteamProject.everteam;

import com.everteamProject.everteam.Repository.LeaderRepository;
import com.everteamProject.everteam.models.LeaderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EverteamApplication implements CommandLineRunner {


	@Autowired
	private LeaderRepository repository;

	public static void main(String[] args) {SpringApplication.run(EverteamApplication.class, args); }

	@Override
	public void run(String... args) throws Exception {
		repository.save(new LeaderEntity("Thamyris Barbarino","thamyris.silva.barbarino@everis.nttdata.com"));
		repository.save(new LeaderEntity("Daniel Kin","daniel.kim.vidal@everis.nttdata.com"));

	}




}
