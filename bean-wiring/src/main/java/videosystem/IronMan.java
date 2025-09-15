package videosystem;

public class IronMan implements DigitalVideoDisc {
	private static final String title = "Iron Man";
	private static final String studio = "Marvel";
	
	@Override
	public String play() {
		return "Playing " + studio + "'s " + title;
	}

}