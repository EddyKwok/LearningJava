class CompareEnum {
	static enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC}
	
	public static void main(String[] args) {
		Month m1 = Month.JAN, m2 = Month.APR;
		if (m1.ordinal() > m2.ordinal())
			System.out.println(m1 + " > " + m2);
		else
			System.out.println(m2 + " >/= " + m1);
	}
}
