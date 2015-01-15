/**
 * Test declaring static variable in a non-static method.
 * 
 */

class Test1 {
	static int x = 0;
	
	public static void main(String[] args) {
		//aNonStaticMethod();
		System.out.println("Here are two facts presented in this test:");
		System.out.println("------------------------------------------");
		System.out.println("If we call a non-static method within main will cause below compile error:");
		System.out.println("error: non-static method aNonStaticMethod() cannot be referenced from a static context");
		System.out.println();
		aStaticMethod();
	}

	void aNonStaticMethod() {
		//static int i = 0;
		System.out.println("// If below line of code exist inside a method,\n"+
				   "// it will causing error \"error: Illegal start of expression.\" while compiling.\n"+
				   "// static int i = 0;");
		System.out.println("Error while compiling or no error?");
	}

	static void aStaticMethod() {
		//static int i = 0;
		System.out.println("Declaring a static variable inside a method whether a static or a non-static method");
		System.out.println("simply aren't allowed, that is, will causing the following error while compiling:");
		String errMsg = "error: illegal start of expression\n\t\tstatic int i = 0;\n\t\t^";
		System.out.println(errMsg);
	}
}
