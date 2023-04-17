package it.epicode.gestionerenotazioni.model;

import it.epicode.gestionerenotazioni.enums.StatoPostazione;
import it.epicode.gestionerenotazioni.enums.TipoPostazione;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descrizione;

	@Enumerated(EnumType.STRING)
	private TipoPostazione tipopostazione;

	@Enumerated(EnumType.STRING)
	private StatoPostazione statopostazione;

	private Integer numMaxPosti;

	@ManyToOne
	@JoinColumn
	private Edificio edificio;

	public Postazione(String descrizione, TipoPostazione tipopostazione, StatoPostazione statopostazione,
			Integer numMaxPosti, Edificio edificio) {
		super();
		this.descrizione = descrizione;
		this.tipopostazione = tipopostazione;
		this.statopostazione = statopostazione;
		this.numMaxPosti = numMaxPosti;
		this.edificio = edificio;
	}

}
