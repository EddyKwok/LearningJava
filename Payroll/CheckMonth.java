class CheckMonth {
    public static void main(String[] args) {
        Month month = Month.JANUARY;
        System.out.println(month.ordinal());
        System.out.println(month.getMonth());
        System.out.println(month.values());
        Month m2 = Month.JANUARY;
        System.out.println(m2.valueOf("DECEMBER").getMonth());
    }
}
