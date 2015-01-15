/* Listing 1-1. Dumping command-line arguments via mian()'s args array to the standard output device
*/

public class DumpArgs
{
    public static void main(String[] args)
    {
        System.out.println("Passed arguments:");
        for (int i = 0; i < args.length; i++)
            System.out.println(args[i]);
    }
}