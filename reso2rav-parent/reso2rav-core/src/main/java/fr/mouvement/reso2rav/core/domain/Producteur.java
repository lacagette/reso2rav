package fr.mouvement.reso2rav.core.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.experimental.Delegate;

@Data
@Document
public class Producteur {

	@Id
	private String id;

	@Delegate
	private Identite identite = new Identite();

	@Delegate
	private Adresse adresse = new Adresse();

	private String nomExploitation;

	private Date datePriseContact;

	private Set<Produit> produits = new HashSet<>();

	public void addProduit(Produit produit) {
		this.produits.add(produit);
	}

}
