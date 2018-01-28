package fr.mouvement.reso2rav.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Vigie {

	@Id
	private String id;

	private IdentiteAvecAdresse identiteAvecAdresse;

}
