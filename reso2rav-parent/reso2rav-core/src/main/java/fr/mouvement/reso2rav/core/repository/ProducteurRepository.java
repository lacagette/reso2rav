package fr.mouvement.reso2rav.core.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import fr.mouvement.reso2rav.core.domain.Producteur;

@RestResource
public interface ProducteurRepository extends PagingAndSortingRepository<Producteur, String> {

	Optional<Producteur> findOneByIdentiteNom(String nom);

}
