/*
 * Listing 4-1. Declaring a static member class.
 *
 */

public class EnclosingClass
{
	private static int i;

	private static void m1()
	{
		System.out.println(i); // Output: 1
	}
	
	/* Because accessEnclosingClass() is declared static, m2() must prefix this method's
	 * name with EnclosedClass and the member access operator to call this method. Also,
	 * EnclosingClass must be part of the prefix when calling this method from beyond this
	 * class. For example, EnclosingClass.EnclosedClass.accessEnclosingClass();.
	 */	
	public static void m2()
	{
		EnclosedClass.accessEnclosingClass();
	}
	
	public static class EnclosedClass
	{
		public static void accessEnclosingClass()
		{
			i = 1;
			m1();
		}

		/* Because accessEnclosingClass2() is nonstatic, it must be called from an instance of
		 * EnclosedClass. For example, when calling this method from beyond EnclosingClass,
		 * you might specify EnclosingClass.EnclosedClass ec = new EnclosingClass.EnclosedClass();
		 * ec.accesEnclosingClass2();
		 */
		public void accessEnclosingClass2()
		{
			m2();
		}
	}
}
