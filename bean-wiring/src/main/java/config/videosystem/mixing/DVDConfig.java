package config.videosystem.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import videosystem.Avengers;
import videosystem.DigitalVideoDisc;
import videosystem.IronMan;

@Configuration
public class DVDConfig {
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}

	@Bean
	public DigitalVideoDisc ironMan() {
		return new IronMan();
	}
}