/**
 * Listing 10-1. Dumping available filesystem roots to the standard output device.
 *
 */

import java.io.File;

public class DumpRoots {
	public static void main(String[] args) {
		File[] roots = File.listRoots();
		for (File root: roots)
			System.out.println(root);
	}
}
