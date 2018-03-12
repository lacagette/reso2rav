package fr.mouvement.reso2rav.batch.creerjeutest;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;

import fr.mouvement.reso2rav.core.utils.JeuEssaiUtils;

@Component
public class InsererJeuEssaiTasklet implements Tasklet {

	@Value(value = "${spring.data.mongodb.database}")
	private String databaseName;

	@Autowired
	MongoClient mongoClient;

	@Autowired
	JeuEssaiUtils jeuEssaiUtils;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		mongoClient.dropDatabase(databaseName);

		jeuEssaiUtils.creerJeuEssai();

		return RepeatStatus.FINISHED;
	}

}
