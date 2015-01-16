/*
 * I thought the <code>new</code> keyword in this statement
 * <code>TheNumber[] myNumbers = new TheNumber[] {TheNumber.TWO, TheNumber.ONE}</code>
 * is targetting to the <code>ENUM</code> class. It isn't. It uses to instantiating the
 * array, not the variable. Not fully understand yet.
 */

public class TestEnumAgain {
	enum TheNumber {
		ONE, TWO, THREE, FOUR, FIVE
	}

	public static void main(String[] args) {
		TheNumber myNumber = TheNumber.ONE;
		TheNumber[] myNumbers = new TheNumber[] {TheNumber.TWO, TheNumber.THREE, TheNumber.FIVE};
		TheNumber[] hisNumbers = {TheNumber.ONE, TheNumber.FIVE, TheNumber.FIVE};

		System.out.println("These are my numbers:");
		for (int i=0;i<myNumbers.length;i++) System.out.println(myNumbers[i]);
		
		System.out.println();
		System.out.println("These are his numbers:");
		for (int i=0;i<hisNumbers.length;i++) System.out.println(hisNumbers[i]);
	}
} 
