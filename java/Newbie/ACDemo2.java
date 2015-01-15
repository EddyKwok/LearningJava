/**
 * <code>Listing 4-10.</code> Declaring and instantiating an anonymous class that implements an interface.
 * 
 */

interface Speakable
{
    void speak();
}

public class ACDemo2
{
    public static void main (final String[] args) {
        new Speakable()
        {
            String msg = (args.length == 1) ? args[0] : "nothing to say";
            /* If we remove the public access modifier, Javac will fire below error message:
             *
             * eddykwok: ~/Programming/java/Newbie $ javac ACDemo2.java
             * ACDemo2.java:17: error: speak() in <anonymous ACDemo2$1> cannot implement speak() in Speakable
             * void speak()
             *      ^
             * attempting to assign weaker access privileges; was public
             * 1 error
             */
            public void speak()
            {
                System.out.println(msg);
            }
        }
        .speak();
    }
}