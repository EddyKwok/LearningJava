import java.math.*;

class PrimitiveWrapper
{
	public static void main(String[] args)
	{
		BigDecimal bd = new BigDecimal(Float.MAX_VALUE);
		System.out.println("Float.MAX_VALUE : " + Float.MAX_VALUE);
		System.out.println("Float.MAX_VALUE : " + bd + " (BigDecimaled)");
	}
}
