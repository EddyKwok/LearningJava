/**
 * Anonymous.
 * http://tutorials.jenkov.com/java/nested-classes.html
 */
//public class Anonymous {
	public class SuperClass {
		public void doIt() {
			System.out.println("SuperClass doIt()");
		}
	//}

	SuperClass instance = new SuperClass() {
		public void doIt() {
			System.out.println("Anonymous doIt()");
		}
	};
	
	public static void main(String[] args) { instance.doIt(); }
}
