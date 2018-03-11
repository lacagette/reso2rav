package fr.mouvement.reso2rav.web.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
		mvc.perform(get("/producteurs?sort=identite.nom").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect((content().contentTypeCompatibleWith("application/hal+json")))
				.andExpect(jsonPath("$._embedded.producteurs", hasSize(equalTo(3))))
				.andExpect(jsonPath("$._embedded.reseauRavitaillements[0].nom", is("La cagette")));
		// @formatter:on

	}

}
