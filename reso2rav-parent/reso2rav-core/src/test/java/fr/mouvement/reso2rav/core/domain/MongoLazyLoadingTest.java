package fr.mouvement.reso2rav.core.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.mouvement.reso2rav.core.repository.ProducteurRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoLazyLoadingTest {

	@Autowired
	ProducteurRepository producteurRepository;

	@Before
	public void init() {

		Producteur producteur = new Producteur();

		producteur.setNom("Gentil producteur");

		producteurRepository.save(producteur);

	}

	@Test
	public void lazyLoadingTest() {

		Producteur producteur = producteurRepository.findAll().iterator().next();

		assertEquals("Gentil producteur", producteur.getNom());

	}

}
