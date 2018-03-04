package fr.mouvement.reso2rav.web.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import fr.mouvement.reso2rav.core.domain.ReseauRavitaillement;

@RestResource
public interface ReseauRavitaillementRestRepository extends PagingAndSortingRepository<ReseauRavitaillement, String> {

}
