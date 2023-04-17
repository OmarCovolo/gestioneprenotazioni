package it.epicode.gestionerenotazioni.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import it.epicode.gestionerenotazioni.model.Edificio;

@Configuration
@PropertySource("classpath:application.properties")
public class EdificioConfiguration {

	@Bean("ParametriEdificio")
	@Scope("prototype")
	public Edificio parametriEdificio(String nome, String indirizzo, String citta) {
		return new Edificio(nome, indirizzo, citta);
	}

	@Bean("EdificioFake")
	@Scope("prototype")
	public Edificio edificioFake() {
		Faker f = Faker.instance(new Locale("it-IT"));
		Edificio e = new Edificio();
		e.setNome(f.company().name());
		e.setIndirizzo(f.address().streetAddress());
		e.setCitta(f.address().city());
		return e;
	}
}
