/**
 * Cat.
 *
 */

public class Cat extends Pet {
	public Cat(String name) {
		this.name = name;
		this.numberOfFeet = 4;
	}
	
	public int getNumberOfFeet() {
		return this.numberOfFeet;
	}

	public String getName() {
		return this.name;
	}

}
