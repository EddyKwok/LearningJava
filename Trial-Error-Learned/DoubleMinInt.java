import java.math.*; 

class DoubleMinInt {
	static double d = 550000000.0;
	static int i = 25000000;
	
	static BigDecimal bd = new BigDecimal(d);
	
	public static void main(String[] args) {
		double result = d - i;
		System.out.println("static double d = 550000000.0;");
		System.out.println("static int i = 25000000;");
		System.out.println();
		System.out.println("public static void main(String[] args) {");
		System.out.println("double result = d - i; // " + result);
		System.out.println("}");
		System.out.println("new BigDecimal(result) => " + new BigDecimal(result)); 
	}
}
