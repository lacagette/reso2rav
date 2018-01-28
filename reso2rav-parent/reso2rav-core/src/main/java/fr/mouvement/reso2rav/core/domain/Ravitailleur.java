package fr.mouvement.reso2rav.core.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Ravitailleur {

	@Id
	private String id;

	private IdentiteAvecAdresse identiteAvecAdresse;

	private Boolean vehicule;

	private Date dateInscription;

	private String infoSupplementaires;

}
