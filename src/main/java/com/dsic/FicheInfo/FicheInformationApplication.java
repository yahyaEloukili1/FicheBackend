package com.dsic.FicheInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dsic.FicheInfo.entities.AppRole;
import com.dsic.FicheInfo.entities.AppUser;
import com.dsic.FicheInfo.entities.Fiche;
import com.dsic.FicheInfo.services.AccountService;

@SpringBootApplication
public class FicheInformationApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired
	@Lazy
	private AccountService accountService;
	@Bean
	public BCryptPasswordEncoder getBPE() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(FicheInformationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Fiche.class);
		if(accountService.finduserByUsrname("adminPdi")==null) {
			accountService.save(new AppUser(null,"adminPdi","Laayoune2022@",null,null));
		}
		if(accountService.findRoleByRoleName("ADMIN")==null) {
			accountService.saveRole(new AppRole(null,"ADMIN"));
		}
		if(accountService.findRoleByRoleName("USER")==null) {
			accountService.saveRole(new AppRole(null,"USER"));
		}


		if(accountService.findRoleByRoleName("ADMIN")==null) {
			accountService.addRoleToUser("adminPdi","ADMIN");
		}
		
		if(accountService.findRoleByRoleName("USER")==null) {
			accountService.addRoleToUser("adminPdi","USER");
		}
		
		
	}

}
