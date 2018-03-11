package fr.mouvement.reso2rav.web.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import fr.mouvement.reso2rav.core.domain.Producteur;
import fr.mouvement.reso2rav.core.repository.ProducteurRepository;

@RunWith(SpringRunner.class)
@Reso2RavRestRepositoryTest
public class ProducteurRestRepositoryTest extends AbstractTestWithJeuEssai {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ProducteurRepository producteurRepository;

	@Test
	public void testGetProducteurs() throws Exception {

		// @formatter:off
		mvc.perform(
				get("/producteurs?sort=identite.nom").contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect((content().contentTypeCompatibleWith("application/hal+json")))
				.andExpect(jsonPath("$._embedded.producteurs", hasSize(equalTo(3))))
				.andExpect(jsonPath("$._embedded.producteurs[0].identite.nom", is("Cloclo")));
		// @formatter:on

	}

	@Test
	public void postProducteur() throws Exception {

		assertEquals(3, producteurRepository.count());

		// @formatter:off
		String newProducteurJson = 
			"{"
				+ "\"identite\": {"
					+ "\"nom\": \"Encore un petit nouveau !!!\""
				+ "}"
			+ "}";
		
		mvc.perform(
				post("/producteurs").contentType(MediaType.APPLICATION_JSON).content(newProducteurJson))
		.andDo(print())
		.andExpect(status().is(201));
		// @formatter:on

		assertEquals(4, producteurRepository.count());

		assertTrue(producteurRepository.findOneByIdentiteNom("Encore un petit nouveau !!!").isPresent());

	}

	@Test
	public void putProducteur() throws Exception {

		Optional<Producteur> optionalProducteur = producteurRepository.findOneByIdentiteNom("Cloclo");

		assertTrue(optionalProducteur.isPresent());

		Producteur producteur = optionalProducteur.get();

		// @formatter:off
		String updateProducteurJson = 
				"{"
					+ "\"identite\": {"
						+ "\"nom\": \"Cloclo mais en mieux\""
					+ "}"
				+ "}";

		
		mvc.perform(
				put("/producteurs/"+ producteur.getId()).contentType(MediaType.APPLICATION_JSON).content(updateProducteurJson))
		.andDo(print())
		.andExpect(status().is(204));
		// @formatter:on

		Producteur updatedProducteur = producteurRepository.findOne(producteur.getId());

		/*
		 * On a mis à jour tous les paramètres de l'objet, ceux qui n'était pas
		 * renseigné dans le body de la requête sont maintenant null
		 */
		assertEquals("Cloclo mais en mieux", updatedProducteur.getNom());

		assertNull(updatedProducteur.getPrenom());

	}

	@Test
	public void patchProducteur() throws Exception {

		Optional<Producteur> optionalProducteur = producteurRepository.findOneByIdentiteNom("Cloclo");

		assertTrue(optionalProducteur.isPresent());

		Producteur producteur = optionalProducteur.get();

		// @formatter:off
		String updateProducteurJson = 
				"{"
					+ "\"identite\": {"
						+ "\"nom\": \"Cloclo mais en mieux\""
					+ "}"
				+ "}";

		
		mvc.perform(
				patch("/producteurs/"+ producteur.getId()).contentType(MediaType.APPLICATION_JSON).content(updateProducteurJson))
		.andDo(print())
		.andExpect(status().is(204));
		// @formatter:on

		Producteur updatedProducteur = producteurRepository.findOne(producteur.getId());

		/*
		 * On a mis à jour tous les seuls paramètres de l'objet renseigné dans
		 * le body, les autres sont restés identiques
		 */
		assertEquals("Cloclo mais en mieux", updatedProducteur.getNom());

		assertEquals("Roger", updatedProducteur.getPrenom());

	}

	@Test
	public void deleteProducteur() throws Exception {

		assertEquals(3, producteurRepository.count());

		Producteur producteur = producteurRepository.findOneByIdentiteNom("Cloclo").get();

		// @formatter:off
		mvc.perform(
				delete("/producteurs/" + producteur.getId()))
		.andDo(print())
		.andExpect(status().is(204));
		// @formatter:on

		assertEquals(2, producteurRepository.count());

	}

}
