package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class HighSchoolRapper2Final implements CompactDisc {
	
	private final static String artist = "김하온";
	private final static String title = "붕붕";
	
	@Override
	public String play() {
		
		return "playing" + title + "by" + artist ;
	}

}
