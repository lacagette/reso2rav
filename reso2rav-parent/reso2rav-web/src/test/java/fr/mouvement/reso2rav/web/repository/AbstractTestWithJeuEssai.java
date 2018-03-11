package fr.mouvement.reso2rav.web.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import fr.mouvement.reso2rav.core.utils.JeuEssaiUtils;

@RunWith(SpringRunner.class)
public abstract class AbstractTestWithJeuEssai {

	@Autowired
	JeuEssaiUtils jeuEssaiUtils;

	@Autowired
	MongoTemplate mongoTemplate;

	@Before
	public void creerJeuTest() {
		jeuEssaiUtils.creerJeuEssai();
	}

	@After
	public void cleanUpDatabase() {
		mongoTemplate.getDb().dropDatabase();
	}

}
