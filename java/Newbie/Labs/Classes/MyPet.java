/**
 * MyPet.java
 *
 */

public class MyPet {
	public static void main(String[] args) {
		Cat myCat = new Cat("Kuching");

		System.out.println("Introducing to my pet's name: " + myCat.getName());
		System.out.println("He is a normal healthy pet who has : " + myCat.getNumberOfFeet() + " feet");
	}
}
