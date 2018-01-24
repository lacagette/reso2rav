package fr.mouvement.reso2rav.core.domain;

import lombok.Data;
import lombok.experimental.Delegate;

@Data
public class Identite {

	private String nom;

	private String prenom;

	private String telephone;

	private String mail;

	@Delegate
	private Adresse adresse;
}
