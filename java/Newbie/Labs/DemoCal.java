public class DemoCal {
	public static void main(String[] args) {
		float a = 4, b = 8, c = -5;
		
		System.out.println("float a = 4, b = 8, c = -5;");
		System.out.println("");
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("a/b = " + a/b);
        	System.out.println("a/b+\"\\n\" = " + a/b+"\n");
        	System.out.println("--------------------------------");
       		 
        	demoCalInt();
	}
	
	private static void demoCalInt() {
		int a = 4, b = 8, c = -5;
        	
        	System.out.println("int a = 4, b = 8, c = -5;");
        	System.out.println("");
        	System.out.println("a/b+\"\\n\"+(++c*b--)+\" \"+a--*b/c-- ="); 
        	System.out.println(a/b+"\n"+(++c*b--)+" "+a--*b/c--); 
	}
}

