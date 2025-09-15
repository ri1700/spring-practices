package config.videosystem.mixing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import videosystem.DVDPlayer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {VideoSystemConfig.class})
public class DVDPlayerMixingConfigTest02 {

	@Autowired
	private DVDPlayer dvdPlayer;
	
	@Test
	public void testPlay() {
		assertEquals("playing Marvel's Avengers", dvdPlayer.play());
	}
}