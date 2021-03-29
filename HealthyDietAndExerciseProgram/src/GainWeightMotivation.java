import java.util.Random;
//This class implements MotivationDisplayer interface as Factory Design Pattern requires.
public class GainWeightMotivation implements MotivationDisplayer {

	//Here the method override declared for users that preferred gain weight program selection to display related
	//motivation messages.
	@Override
	public String displayMotivationMessage() {
		//Here the sentences array.
		String motivationMessagges[] = {
				"It’s not a diet, it’s a lifestyle change.",
				"If not now when ?",
				"Achieve yourself !",		
				"Eat more to be happier",		
				"Believe in yourself"	
				};
		//Here randomly created integer to choose related sentence to display.
				Random rnd = new Random();
				int motIndex = rnd.nextInt(motivationMessagges.length);
				return (motivationMessagges[motIndex]);
	}

}