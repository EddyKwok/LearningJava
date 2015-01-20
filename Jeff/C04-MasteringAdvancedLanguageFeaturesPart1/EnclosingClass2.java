/*
 * Listing 4-4. Declaring a nonstatic member class.
 */

public class EnclosingClass2
{
	private int i;
	
	private void m1()
	{
		System.out.println(i); // Output: 1
	}
	
	public class EnclosedClass
	{
		public void accessEnclosingClass()
		{
			i=1;
			m1();
		}
	}
}
