/**
 * Listing 5-5. A buggy control-flow Invariant.
 *
 */

public class CFDemo {
	final static int NORTH = 0;
	final static int SOUTH = 1;
	final static int EAST = 2;
	final static int WEST = 3;

	public static void main(String[] args) {
		int direction = (int) (Math.random()*4);
		switch (direction) {
			case NORTH: System.out.println("Travelling north"); break;
			case SOUTH: System.out.println("Travelling south"); break;
			case EAST: System.out.println("Travelling east"); break;
			case WEST: System.out.println("Travelling west");
			default: assert false;
		}
	}
}
