package fr.mouvement.reso2rav.core.domain;

import lombok.Data;
import lombok.experimental.Delegate;

@Data
public class IdentiteAvecAdresse {

	@Delegate
	private Identite identite;

	@Delegate
	private Adresse adresse;
}
