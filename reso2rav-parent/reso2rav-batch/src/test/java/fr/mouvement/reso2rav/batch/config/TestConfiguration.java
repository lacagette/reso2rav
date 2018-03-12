package fr.mouvement.reso2rav.batch.config;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	JobRepository jobRepository;

	@Bean
	public JobLauncherTestUtils jobLauncherTestUtils() {
		JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();

		jobLauncherTestUtils.setJobLauncher(jobLauncher);
		jobLauncherTestUtils.setJobRepository(jobRepository);

		return jobLauncherTestUtils;

	}

}
