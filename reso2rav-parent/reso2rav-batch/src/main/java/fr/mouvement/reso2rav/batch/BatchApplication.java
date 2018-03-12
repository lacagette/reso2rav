package fr.mouvement.reso2rav.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "fr.mouvement.reso2rav.core", "fr.mouvement.reso2rav.batch" })
@EnableBatchProcessing
public class BatchApplication {

	private Logger logger = LoggerFactory.getLogger(BatchApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BatchApplication.class, args);
	}

}
