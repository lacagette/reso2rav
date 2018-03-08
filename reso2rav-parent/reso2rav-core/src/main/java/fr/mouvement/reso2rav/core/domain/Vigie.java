package fr.mouvement.reso2rav.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.experimental.Delegate;

@Document
@Data
public class Vigie {

	@Id
	private String id;

	@Delegate
	private Identite identite = new Identite();

	@Delegate
	private Adresse adresse = new Adresse();

}
