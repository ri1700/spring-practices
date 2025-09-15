package config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *                                  import 
 * JavaConfig3(VideoSystemConfig) <-------  JavaConfig1, JavaConfig2
 * 
 */
@Configuration
@Import({DVDConfig.class, DVDPlayerConfig.class})
public class VideoSystemConfig {
}