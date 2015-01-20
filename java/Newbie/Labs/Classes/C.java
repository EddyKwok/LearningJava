class C {
	public static void main(String[] args) {
		test();
		B obj = new B();
		B obj2 = new B();
		obj.display();
		System.out.println("Accessing 'a' from C.java: " + obj.a);
		
		// System.out.println("Accessing B.super.a from C.java: " + obj.super.a);
		// error : cannot find symbol.
		
		System.out.println("obj2.myStaticField = " + obj2.myStaticField);
		
		obj.myStaticField = "I won't give up!";

		System.out.println("obj.myStaticField = " + obj.myStaticField);
		System.out.println("obj2.myStaticField = " + obj2.myStaticField);
		System.out.println("B.myStaticField = " + B.myStaticField);

		// Try to modify the final field:
		// B.HOBBIES = "Managing people!";
		// causing while compiling more or less like this
		// "error : cannot assign value to a final variable HOBBIES"

		System.out.println("B.HOBBIES = " + B.HOBBIES);
		System.out.println("B.SEX (this is an inhireted static final field from A class) = " + B.SEX);
	}
	
	static void test() {
	    System.out.println("Is this just plain stupid?");
	}
}
