class TestBoolean
{
	public static void main(String[] args)
	{
		System.out.println(isNegative(5));
	}

	static Boolean isNegative(double d)
	{
		return (d < 0) ? Boolean.TRUE : Boolean.FALSE;
	}
}
