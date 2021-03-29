import java.util.Random;
//This class implements MotivationDisplayer interface as Factory Design Pattern requires.
public class StayFitMotivation implements MotivationDisplayer{
	//Here the method override declared for users that preferred stay fit program selection to display related
	//motivation messages.
	@Override
	public String displayMotivationMessage() {
		//Here the sentences array.
		String motivationMessagges[] = {
		"Keep fit and stay healhty",
		"If you wait, all that happens is you get older.",
		"A goal without a plan is just a wish.",		
		"Save your body save your mind",		
		"Respect your body."	
		};
		//Here randomly created integer to choose related sentence to display.
		Random rnd = new Random();
		int motIndex = rnd.nextInt(motivationMessagges.length);
		return (motivationMessagges[motIndex]);
	}
}
