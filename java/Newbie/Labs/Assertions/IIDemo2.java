/**
 * Listing 5-4. Another buggy Internal Invariant.
 *
 * Tips:
 * -----
 * When assertions are disabled, assert false; does not execute and the bug goes
 * undected. To always detect this bug, replace assert false; with 
 * throw new AssertionError(direction);.
 * 
 */

public class IIDemo2 {
	final static int NORTH = 0;
	final static int SOUTH = 1;
	final static int EAST = 2;
	final static int WEST = 3;

	public static void main(String[] args) {
		int direction = (int) (Math.random()*5);
		switch (direction) {
			case NORTH: System.out.println("Travelling north"); break;
			case SOUTH: System.out.println("Travelling south"); break;
			case EAST: System.out.println("Travelling east"); break;
			case WEST: System.out.println("Travelling west"); break;
			default: assert false;
		}
	}
}
