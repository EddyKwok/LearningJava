/**
 * EqualsDemo.java. Demonstrating the different between == and equals().
 */
public class EqualsDemo {
        public static void main(String[] args) {
                String s1 = "abc";
                String s2 = "abc";

                String s3 = new String("abc");
                String s4 = new String("abc");

                System.out.println("String s1 = \"abc\"");
                System.out.println("String s2 = \"abc\"");

                System.out.println("String s3 = new String(\"abc\")");
                System.out.println("String s4 = new String(\"abc\")");

                System.out.println("");

                if (s1==s2)
                        System.out.println("s1==s2 is TRUE");
                else
                        System.out.println("s1==s2 is FALSE");

                if (s3==s4)
                        System.out.println("s3==s4 is TRUE");
                else
                        System.out.println("s3==s4 is FALSE");

                if (s3.equals(s4))
                        System.out.println("s3.equals(s4) is TRUE");
                else
                        System.out.println("s3.equals(s4) is FALSE");
        }
}
