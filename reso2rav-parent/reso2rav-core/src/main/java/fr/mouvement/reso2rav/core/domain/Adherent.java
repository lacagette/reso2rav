package fr.mouvement.reso2rav.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Adherent {

	@Id
	private String id;

	private Identite identite;

}
