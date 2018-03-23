package fr.mouvement.reso2rav.web.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Reso2RavRestRepositoryTest
public class TypeProduitControllerTest extends AbstractTestWithJeuEssai {

	@Test
	public void testGetTypeProduits() throws Exception {

		// @formatter:off
		getMockMvc().perform(get("/typeProduits").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect((content().contentTypeCompatibleWith("application/json")))
				.andExpect(jsonPath("$[0]", is("BLE")));
		// @formatter:on

	}

}
