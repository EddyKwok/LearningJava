/**
 * <code>SuperClass</code> Anonymous classes.
 * http://tutorials.jenkov.com/java/nested-classes.html
 */
public class SuperClass {
	public void doIt() {
		System.out.println("SuperClass doIt()");
	}

	public static void main(String[] args) {
		SuperClass instance = new SuperClass() {
			public void doIt() {
				System.out.println("Anonymous doIt()");
			}
		};
		
		instance.doIt();
	}
}
