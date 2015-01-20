/** 
 * <code>Listing 4-4.</code> Declaring a nonstatic member class
 * <p>
 * Copied and pasted from Learn Java for Android Development textbook, CHAPTER 4, page 143.
 */
 
public class EnclosingClass
{
    private int i;
    private void m1()
    {
        System.out.println(i); // Output: 1
    }
    
    // Here it is the enclosed non-static member class
    public class EnclosedClass
    {
        public void accessEnclosingClass()
        {
            i = 1;
            m1();
        }
    }
    
    /**
     * This is the source code originally taken from the textbook, also in page 143. 
     * 
     * Listing 4-5. Calling a nonstatic member class's instance method
     * public class NSMCDemo
     * {
     *      public static void main(String[] args)
     *      {
     *          EnclosingClass ec = new EnclosingClass();
     *          ec.new EnclosedClass().accessEnclosingClass();
     *      }
     * }
     */ 
    public static void main(String[] args)
    {
        //EnclosedClass ec = new EnclosedClass(); // error: non-static variable this cannot be referenced from a static context
        //ec.accessEnclosingClass();
        
        EnclosingClass ec = new EnclosingClass();
        ec.new EnclosedClass().accessEnclosingClass();
        
        // Here I tried another method on to run the enclosed non-static member class' method
        // which has the exact same outcome with the above given by the author sample code.
        EnclosedClass ec2 = ec.new EnclosedClass();
        ec2.accessEnclosingClass();
        
        // Another method
        EnclosingClass.EnclosedClass ec3 = new EnclosingClass.EnclosedClass();
    }
}