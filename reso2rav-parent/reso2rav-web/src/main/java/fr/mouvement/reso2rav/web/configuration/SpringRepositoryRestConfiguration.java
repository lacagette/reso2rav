package fr.mouvement.reso2rav.web.configuration;

import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class SpringRepositoryRestConfiguration extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.setRepositoryDetectionStrategy(RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);
		config.getCorsRegistry()
				.addMapping("/**") //
				.allowedOrigins("*") //
				.allowedHeaders("*") //
				.allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
	}

	public class NONE_BY_DEFAULT implements RepositoryDetectionStrategy {

		@Override
		public boolean isExported(RepositoryMetadata metadata) {
			// TODO Auto-generated method stub
			return false;
		}

	}

}
