/*
 * Listing 4-5. Calling a nonstatic member class' Instance method
 */

public class NSMCDemo
{
	public static void main(String[] args)
	{
		EnclosingClass2 ec = new EnclosingClass2();
		ec.new EnclosedClass().accessEnclosingClass();
	}
}
