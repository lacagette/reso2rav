package fr.mouvement.reso2rav.batch.creerjeutest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class CreerJeuTestJobConfig {

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Autowired
	InsererJeuEssaiTasklet insererJeuEssaiTasklet;

	@Bean
	public Job creerJeuEssaiJob() {

		return jobBuilderFactory.get("creerJeuEssaiJob").flow(insererJeuEssaiStep()).build().build();

	}

	@Bean
	public Step insererJeuEssaiStep() {

		return stepBuilderFactory.get("insererJeuEssaiStep").tasklet(insererJeuEssaiTasklet).build();

	}

}
