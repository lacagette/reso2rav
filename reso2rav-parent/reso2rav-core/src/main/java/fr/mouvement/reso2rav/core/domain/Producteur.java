package fr.mouvement.reso2rav.core.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Producteur {

	@Id
	private String id;

	private IdentiteAvecAdresse identiteAvecAdresse = new IdentiteAvecAdresse();

	private String nomExploitation;

	private Date datePriseContact;

	private Set<Produit> produits = new HashSet<>();

}
