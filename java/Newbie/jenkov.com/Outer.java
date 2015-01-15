/**
 * Non-static Nested Classes (Inner Classes): Shadowing.
 * http://tutorials.jenkov.com/java/nested-classes.html
 *
 */

public class Outer {
	private String text = "I am outer private!";
	
	public class Inner {
		private String text = "I am inner private!";

		public void printText() {
			System.out.println(text);
			System.out.println(Outer.this.text);
		}
	}

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.printText();
	}
}
