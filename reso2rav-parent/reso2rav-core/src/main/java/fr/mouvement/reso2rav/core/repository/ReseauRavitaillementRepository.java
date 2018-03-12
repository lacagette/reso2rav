package fr.mouvement.reso2rav.core.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import fr.mouvement.reso2rav.core.domain.ReseauRavitaillement;

@RestResource
public interface ReseauRavitaillementRepository extends PagingAndSortingRepository<ReseauRavitaillement, String> {

	public Optional<ReseauRavitaillement> findOneByNom(String nom);

}
