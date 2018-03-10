package fr.mouvement.reso2rav.core.repository;

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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import fr.mouvement.reso2rav.core.ApplicationCoreTest;
import fr.mouvement.reso2rav.core.domain.Producteur;
import fr.mouvement.reso2rav.core.domain.ReseauRavitaillement;
import fr.mouvement.reso2rav.core.utils.JeuEssaiUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ApplicationCoreTest.class)
@AutoConfigureMockMvc
public class ReseauRavitaillementRepositoryTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ReseauRavitaillementRepository reseauRavitaillementRepository;

	@Autowired
	private ProducteurRepository producteurRepository;

	@Autowired
	JeuEssaiUtils jeuEssaiUtils;

	@Before
	public void creerJeuTest() {
		jeuEssaiUtils.creerJeuEssai();
	}

	@Test
	public void testGetReseauRavitaillements() throws Exception {
		// @formatter:off
		mvc.perform(get("/reseauRavitaillements").contentType(MediaType.APPLICATION_JSON)).andDo(print())
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
		mvc.perform(get("/reseauRavitaillements/" + reseauRavitaillement.getId() + "/producteurs")
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
		mvc.perform(patch("/reseauRavitaillements/" + reseauRavitaillement.getId() + "/producteurs")
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
