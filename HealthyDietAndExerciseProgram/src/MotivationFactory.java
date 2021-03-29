//This class created to produce motivation related classes as factory design pattern required. 
public class MotivationFactory {
	//This method takes an integer as parameter that refers program selection which  will be definer of class creation.
	public MotivationDisplayer display(int programSelection) {
		
		if(programSelection==0) {
			return new LossWeightMotivation(); 
		}
		else if (programSelection ==1) {
			return new GainWeightMotivation();
		}
		else if(programSelection ==2) {
			return new StayFitMotivation();
		}
		else {
			return null;
		}
	}
}
