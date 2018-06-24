package simulator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import simulator.service.RobotsService;
import simulator.service.RobotsServiceImpl;

@Configuration
public class RobotsConfiguration {
	
	@Bean
	public RobotsService robotsService() {
		return new RobotsServiceImpl();
	}

}
