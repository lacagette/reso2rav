package fr.mouvement.reso2rav.web.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import fr.mouvement.reso2rav.core.domain.Producteur;
import fr.mouvement.reso2rav.core.domain.ReseauRavitaillement;
import fr.mouvement.reso2rav.core.repository.ProducteurRepository;
import fr.mouvement.reso2rav.core.repository.ReseauRavitaillementRepository;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Reso2RavRestRepositoryTest
@Slf4j
public class ReseauRavitaillementRestRepositoryTest extends AbstractTestWithJeuEssai {

	@Value("spring.data.rest.base-path")
	String basePath;

	@Autowired
	private ReseauRavitaillementRepository reseauRavitaillementRepository;

	@Autowired
	private ProducteurRepository producteurRepository;

	@Test
	public void testGetReseauRavitaillements() throws Exception {

		// @formatter:off
		getMockMvc().perform(get("/reseauRavitaillements").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect((content().contentTypeCompatibleWith("application/hal+json")))
				.andExpect(jsonPath("$._embedded.reseauRavitaillements", hasSize(equalTo(1))))
				.andExpect(jsonPath("$._embedded.reseauRavitaillements[0].nom", is("La cagette")));
		// @formatter:on
	}

	@Test
	public void testGetProducteursOfReseauRavitaillement() throws Exception {

		Optional<ReseauRavitaillement> optionalReseauRavitaillement = reseauRavitaillementRepository
				.findOneByNom("La cagette");

		assertTrue(optionalReseauRavitaillement.isPresent());

		ReseauRavitaillement reseauRavitaillement = optionalReseauRavitaillement.get();

		// @formatter:off
		getMockMvc().perform(get("/reseauRavitaillements/" + reseauRavitaillement.getId() + "/producteurs")
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect((content().contentTypeCompatibleWith("application/hal+json")))
				.andExpect(jsonPath("$._embedded.producteurs", hasSize(equalTo(3))));
		// @formatter:on

	}

	@Test
	public void testPatchAddOneProducteurToReseauRavitaillement() throws Exception {

		Optional<ReseauRavitaillement> optionalReseauRavitaillement = reseauRavitaillementRepository
				.findOneByNom("La cagette");

		assertTrue(optionalReseauRavitaillement.isPresent());

		ReseauRavitaillement reseauRavitaillement = optionalReseauRavitaillement.get();

		Producteur newProducteur = new Producteur();

		newProducteur.setNom("Le petit nouveau");

		producteurRepository.save(newProducteur);

		assertNotNull(newProducteur.getId());

		// @formatter:off
		getMockMvc().perform(patch("/reseauRavitaillements/" + reseauRavitaillement.getId() + "/producteurs")
				.contentType("text/uri-list")
				.content("/producteurs/" + newProducteur.getId()))
				.andDo(print())
				.andExpect(status().is(204));
		// @formatter:on

		Optional<ReseauRavitaillement> optionalReseauRavitaillementFresh = reseauRavitaillementRepository
				.findOneByNom("La cagette");

		ReseauRavitaillement reseauRavitaillementFresh = optionalReseauRavitaillementFresh.get();

		assertEquals(4, reseauRavitaillementFresh.getProducteurs().size());

	}

}
