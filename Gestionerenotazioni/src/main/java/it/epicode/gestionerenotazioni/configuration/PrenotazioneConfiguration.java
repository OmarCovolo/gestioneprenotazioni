package it.epicode.gestionerenotazioni.configuration;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.gestionerenotazioni.model.Postazione;
import it.epicode.gestionerenotazioni.model.Prenotazione;
import it.epicode.gestionerenotazioni.model.Utente;

@Configuration
public class PrenotazioneConfiguration {

    @Bean("Reservation")
    @Scope("prototype")
    Prenotazione prenotazione(Utente utente, Postazione postazione, LocalDate data) {
		return new Prenotazione(utente, postazione, data);
	}
}
