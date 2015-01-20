import java.math.BigDecimal;

class TestBigDecimal {
    private static BigDecimal x = new BigDecimal("50");
    public static void main(String[] args) {
        x = x.multiply(new BigDecimal("12")).divide(new BigDecimal("3"));
        System.out.println("x = x.multiply(new BigDecimal(\"12\")).devide(new BigDecimal(\"3\")); // "+x);
        System.out.println("new BigDecimal(\"-1\"); // " + new BigDecimal("-1"));
        BigDecimal y = new BigDecimal("1750550");
        String t = y.toString();
        t = t.substring(0, t.length()-3)+"000";
        BigDecimal z = new BigDecimal(t);
        System.out.println(z);
        BigDecimal e = new BigDecimal(0);
    }
}
