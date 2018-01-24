package fr.mouvement.reso2rav.core.domain;

import lombok.Data;

@Data
public class Produit {

	private TypeProduit typeProduit;

	private Integer quantiteDisponible;

	private TypeRetrait typeRetrait;

	private FrequenceProduit frequence;

}
