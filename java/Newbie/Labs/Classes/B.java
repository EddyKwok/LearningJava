class B extends A {
    int x = 5;
    int y = 10;
    int z = 4;
    int a = 200;
    static String  myStaticField = "I still confuse.";
    static final String HOBBIES = "Coding & Juggling!";
    
    B() {
        if (y == 2) System.out.println("I have 'y' that inherited from my ancestor and it can be accessed!");
        super.y++;
        y++;
        this.y++;
        
        // Try to access a private varable of the super class.
        // if (super.z) System.out.println("I can access the super's private variable!");
        // That statement will cause the compiler complaining "Error: z has private access in A"
        
        super.setMyPrivateZ(20);
        setMyPrivateZ(30);
    }
	
	void display() {
	    y++;
		System.out.println(super.x + ", " + y + ", " + z);
		System.out.println("Showing a from B = " + a);
		System.out.println("Displaying A.a from B (super.a) = " + super.a);
		System.out.println("super.z = " + showMyPrivateZ());
	}
}
