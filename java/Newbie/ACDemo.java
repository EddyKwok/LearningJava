/**
 * <code>Listing 4-9.</code> Declarating and instantiating an anonymous class that extends a class.
 * 
 */

abstract class Speaker
{
    abstract void speak();
}

public class ACDemo
{
    public static void main (final String[] args) {
        new Speaker()
        {
            String msg = (args.length == 1) ? args[0] : "nothing to say";
            void speak()
            {
                System.out.println(msg);
            }
        }
        .speak();
    }
}