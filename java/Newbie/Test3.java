public class Test3 {
	public static void main(String[] args) {
		System.out.print("Type something:");
		int ch = 0;
		while (ch != '\n') {
			try {
				ch = System.in.read();
				switch (ch) {
					case 'a': System.out.println("a "+ch);break;
					case 'A': System.out.println("A "+ch);break;
					default: System.out.println(ch);break;
				}
			}
			catch (java.io.IOException ioe) {
			}
		}
	}
}
