package fr.mouvement.reso2rav.core.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class ReseauRavitaillement {

	@Id
	private String id;

	private String nom;

	@DBRef(lazy = true)
	private Set<Producteur> producteurs = new HashSet<>();

	@DBRef(lazy = true)
	private Set<Ravitailleur> ravitailleurs = new HashSet<>();

	@DBRef(lazy = true)
	private Set<Vigie> vigies = new HashSet<>();

}
