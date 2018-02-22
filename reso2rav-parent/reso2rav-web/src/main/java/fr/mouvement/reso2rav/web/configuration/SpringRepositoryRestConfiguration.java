package fr.mouvement.reso2rav.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import fr.mouvement.reso2rav.web.configuration.Reso2RavWebProperties.Environnement;

@Component
public class SpringRepositoryRestConfiguration extends RepositoryRestConfigurerAdapter {

	@Autowired
	Reso2RavWebProperties reso2RavWebProperties;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		if (reso2RavWebProperties.getEnvironnementEnum() == Environnement.LOCAL) {
			config.setRepositoryDetectionStrategy(RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);
			config.getCorsRegistry().addMapping("/**") //
					.allowedHeaders("*") //
					.allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
					.allowedOrigins("*");
		}
	}

}
