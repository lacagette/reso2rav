package fr.mouvement.reso2rav.batch.creerjeutest;

import fr.mouvement.reso2rav.batch.BatchApplication;
import fr.mouvement.reso2rav.core.domain.ReseauRavitaillement;
import fr.mouvement.reso2rav.core.repository.ReseauRavitaillementRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BatchApplication.class)
public class CreerJeuTestTest {

	@Autowired
	JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	CreerJeuTestJobConfig creerJeuTestJobConfig;

	@Autowired
	ReseauRavitaillementRepository reseauRavitaillementRepository;

	@Before
	public void setJobToTest() {
		/*
		 * Configurer le job à tester
		 */
		jobLauncherTestUtils.setJob(creerJeuTestJobConfig.creerJeuEssaiJob());
	}

	@Test
	public void testCreerJeuTestJob() throws Exception {

		assertFalse(reseauRavitaillementRepository.findAll().iterator().hasNext());

		JobExecution jobExecution = jobLauncherTestUtils.launchJob();

		assertEquals(jobExecution.getExitStatus(), ExitStatus.COMPLETED);

		ReseauRavitaillement reseauRavitaillement = reseauRavitaillementRepository.findAll().iterator().next();

		assertNotNull(reseauRavitaillement);

		assertEquals(3, reseauRavitaillement.getProducteurs().size());

	}

}
