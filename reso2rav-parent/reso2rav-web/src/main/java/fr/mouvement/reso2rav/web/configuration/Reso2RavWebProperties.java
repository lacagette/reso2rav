package fr.mouvement.reso2rav.web.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "reso2rav")
@Setter
public class Reso2RavWebProperties {

	private String environnement;

	public enum Environnement {
		LOCAL, PRODUCTION;
	}

	public Environnement geEnvironnementEnum() {
		return Environnement.valueOf(environnement);
	}

}
