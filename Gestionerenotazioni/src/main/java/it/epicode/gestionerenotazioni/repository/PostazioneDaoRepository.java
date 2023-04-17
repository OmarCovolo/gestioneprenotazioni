package it.epicode.gestionerenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.epicode.gestionerenotazioni.model.Postazione;
import it.epicode.gestionerenotazioni.model.Utente;



@Repository
public interface PostazioneDaoRepository extends CrudRepository<Postazione, Long> {

		public List<Postazione> cercaTramiteCitta(String citta);

		public List<Postazione> cercaTramiteEdificio(String edificio);

		public List<Postazione> findByNameAndLastname(String nome, String cognome);

		@Query(value = "SELECT u FROM User u WHERE u.city IN ('Roma', 'Milano', 'Napoli')")
		public List<Utente> findByCityInR_M_N();

		@Query(value = "SELECT u FROM User u WHERE u.age > :age")
		public List<Utente> findByAgeOverParams(Integer age);
	}

