package fr.mouvement.reso2rav.core.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.mouvement.reso2rav.core.domain.Producteur;

public interface ProducteurRepository extends PagingAndSortingRepository<Producteur, String> {

}
