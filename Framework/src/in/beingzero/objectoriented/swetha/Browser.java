package in.beingzero.objectoriented.swetha;

public interface Browser {
		
	void launch();
	public void quit();
	void purpose();
	String getBrowserName();

}

	//Findings

	//a. Compilation result without any access modifiers on all functions in interface?

	//Observation: No compilation errors

	//b. Compilation result on applying private access modifier to any function in interface?

	//Observation: Illegal modifier for the interface method quit; only public, abstract, default, static and strictfp are permitted


	//c. Compilation result on applying protected access modifier to any function in interface?

	//Observation: Illegal modifier for the interface method purpose; only public, abstract, default, static and strictfp are permitted

	//d. Compilation result on applying public access modifier to any function in interface?

	//Observation: No compilation error

	//e. Compilation result on applying public abstract to any function in interface?

	//Observation: No compilation error

	//f. Compilation result on applying only abstract keyword to any function in interface?

	//Observation: No compilation error

	//g. Compilation result on defining body of any one function in the interface?

	//Observation: Abstract methods do not specify a body


	//Mark These Statements True/False Based on your Findings from previous Experiment.
	//1. Functions in interface can have only declaration, but not definition. - True
	//2. All the methods defined in an interface are public and abstract by default. - True

