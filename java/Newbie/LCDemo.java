/**
 * <code>Listing 4-12.</code> Declaring a local class.
 * 
 */

public class LCDemo
{
    public void m(final int x)
    {
        final int y = x*2;
        class LocalClass
        {
            int a = x;
            int b = y;
        }
        LocalClass lc = new LocalClass();
        System.out.println(lc.a);
        System.out.println(lc.b);
    }
}