public interface TestInterface {
	// Because java has implicitly declares variables
	// in an interface as public, static, and final,
	// hence, practically, we must not prefix those modifiers
	// in variable declarations in an interface class.
	//
	// It means we are freely to choose whether to put the
	// modifiers or not. The effect will be the same.
	//
	// public static final int i = 0; // correct
	// static final int i = 0; // correct
	// final int i = 0; // correct
	int i = 0; // correct
	// All above four ways of initiating the variable gain
	// the exact same result (have exact same meaning!)
	//
	// Initiating a variable other than public, static, final
	// inside an interface is not allowed!
	//
	// Following statements will causing error at compile time.
	// protected int j = 0;
	// private int z = 0;
	// private int x;
	//
	// An interface:
	// 1. All methods are by default and must be public, & abstract.
	// 2. All variables are by default and must be public, static, & final.
	// 3. An interface can't be instantiated.
}
