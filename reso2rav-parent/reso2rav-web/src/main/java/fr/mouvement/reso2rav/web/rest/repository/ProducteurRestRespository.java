package fr.mouvement.reso2rav.web.rest.repository;

import org.springframework.data.rest.core.annotation.RestResource;

import fr.mouvement.reso2rav.core.domain.Producteur;

public interface ProducteurRespository extends RestRepositoryMethodExportedFalse<Producteur, String> {

	@RestResource(exported = true)
	@Override
	Producteur findOne(String id);

}
