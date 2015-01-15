/* Java doesn't allow you to inherit from more than one 
 * class. So, what do you do when you want do you do
 * when you want to add additional functionality?
 * You create an interface. Interfaces are empty 
 * classes. They provide all of the methods you must
 * use, but none of the code.
 */

// This is how you define an interface. They normally
// have a name that is an adjective. Adjectives modify
// nouns. Most objects have noun names

// You can also precede interface with abstract, to emphasize
// that an interface is abstract. Because an interface is already
// abstract, it is redundant to specify abstract in the interface's
// declaration.
public interface Drivable {
	// An interface's fields are implicitly declared public,
	// static, and final. It is therefore redundant to declare
	// them with these reserved words. Becuase these fields are
	// contants, they must be explicitly initialized; otherwise,
	// the compiler reports an error.
	//
	// You can put fields in an interface, but understand 
	// that their values are final and can't be changed
	double PI = 3.14159265;
	
	// All methods in an interface must be implemented
	// They are public and abstract by default
	// An abstract method must be defined by any class 
	// that uses the interface
	int getWheels();
	
	// You can't define a method as final and abstract
	// final means the method can't be changed and 
	// abstract means it must be changed
	void setWheels(int numWheels);
	
	double getSpeed();
	
	void setSpeed(double speed);
}
