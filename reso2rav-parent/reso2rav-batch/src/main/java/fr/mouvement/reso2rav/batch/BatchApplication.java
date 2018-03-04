package fr.mouvement.reso2rav.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "fr.mouvement.reso2rav.core", "fr.mouvement.reso2rav.batch" }, exclude = {
		DataSourceAutoConfiguration.class })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class BatchApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BatchApplication.class, args);
	}

}
