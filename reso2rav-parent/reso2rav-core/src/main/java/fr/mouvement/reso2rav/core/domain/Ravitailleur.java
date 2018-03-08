package fr.mouvement.reso2rav.core.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.experimental.Delegate;

@Document
@Data
public class Ravitailleur {

	@Id
	private String id;

	@Delegate
	private Identite identite = new Identite();

	@Delegate
	private Adresse adresse = new Adresse();

	private Boolean vehicule;

	private Date dateInscription;

	private String infoSupplementaires;

}
