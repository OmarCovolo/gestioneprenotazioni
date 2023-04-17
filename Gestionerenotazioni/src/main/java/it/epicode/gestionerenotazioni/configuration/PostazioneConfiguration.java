package it.epicode.gestionerenotazioni.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import it.epicode.gestionerenotazioni.enums.TipoPostazione;
import it.epicode.gestionerenotazioni.model.Edificio;
import it.epicode.gestionerenotazioni.model.Postazione;

@Configuration
public class PostazioneConfiguration {

    @Bean("Station")
    @Scope("prototype")
    Postazione parametriPostazione(String descrizione, TipoPostazione tipopostazione, Integer numMaxPosti,
                                                                              Edificio edificio) {
		return new Postazione();

	}

    @Bean("Postazione_Fake")
    @Scope("prototype")
    Postazione fakeStation() {
		Faker f = Faker.instance(new Locale("it-IT"));
		Postazione p = new Postazione();
		p.setDescrizione("La postazione è di tipo " + p.getTipopostazione() + "ed offre un numero massimo di "
				+ p.getNumMaxPosti() + " posti.");
		int posti = f.number().numberBetween(1, 50);
		p.setNumMaxPosti(posti);
		if (posti <= 35) {
			p.setTipopostazione(TipoPostazione.SALA_RIUNIONI);
		} else if (posti <= 15) {
			p.setTipopostazione(TipoPostazione.PRIVATO);
		} else {
			p.setTipopostazione(TipoPostazione.OPENSPACE);
		}
		return p;
	}

}

