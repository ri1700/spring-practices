package config.videosystem.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import videosystem.Avengers;
import videosystem.DVDPlayer;

/**
 *                               import 
 * JavaConfig2(DVDPlayerConfig) <------- JavaConfig1
 * 
 */
@Configuration
@Import({DVDConfig.class})
public class DVDPlayerConfig {
	@Bean
	public DVDPlayer dvdPlayer(Avengers dvd) {
		return new DVDPlayer(dvd);
	}
}