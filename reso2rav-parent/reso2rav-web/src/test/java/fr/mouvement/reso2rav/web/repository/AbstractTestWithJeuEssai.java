package fr.mouvement.reso2rav.web.repository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import fr.mouvement.reso2rav.core.utils.JeuEssaiUtils;

@RunWith(SpringRunner.class)
public abstract class AbstractTestWithJeuEssai {

	@Autowired
	JeuEssaiUtils jeuEssaiUtils;

	@Before
	public void creerJeuTest() {
		jeuEssaiUtils.creerJeuEssai();
	}

}
