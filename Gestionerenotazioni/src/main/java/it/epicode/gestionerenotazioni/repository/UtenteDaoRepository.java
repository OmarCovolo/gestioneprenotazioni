package it.epicode.gestionerenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.epicode.gestionerenotazioni.model.Utente;

@Repository
public interface UtenteDaoRepository extends CrudRepository<Utente, Long> {
	
	public List<Utente> findByCity(String citta);
	public List<Utente> findByEmail(String email);
	
	
	@Query(value = "SELECT u FROM Utente u WHERE nomeutente = :nomeutente")
	public Utente ricercaPerNomeUtente(String nomeutente);

	@Query(value = "SELECT u FROM Utente u WHERE utente.id= :id")
	public Object ricercaPerId(Long id);

}
