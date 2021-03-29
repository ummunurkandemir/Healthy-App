import java.util.Random;
//This class implements MotivationDisplayer interface as Factory Design Pattern requires.
public class LossWeightMotivation implements MotivationDisplayer{

	//Here the method override declared for users that preferred loss weight program selection to display related
	//motivation messages.
	@Override
	public String displayMotivationMessage() {
		//Here the sentences array.
		String motivationMessagges[] = {
				"My weight does not determine my worth",
				"If I don’t eat junk, I don’t gain weight.",
				"You are your only limit",		
				"Keep an open mind and a closed refrigerator.",		
				"Strive for progress, not perfection."	
				};
		//Here randomly created integer to choose related sentence to display.
				Random rnd = new Random();
				int motIndex = rnd.nextInt(motivationMessagges.length);
				return (motivationMessagges[motIndex]);
	}

}
