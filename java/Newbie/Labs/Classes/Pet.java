/**
 * Pet.
 *
 */

public abstract class Pet {
	protected int numberOfFeet;
	protected String name;

	abstract int getNumberOfFeet();

	abstract String getName();

	void setName(String name) {
		this.name = name;
	}
}
