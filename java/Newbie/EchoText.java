/* Listing 1-2. Echoing text read from standard input to standard output */

public class EchoText
{
    public static void main(String[] args) throws java.io.IOException
    {
        System.out.println("Please enter some text and press Enter!");
        int ch;
        // If it is running in Windows environment, then, the cariage return will be 13 instad on 10.
        // However it is 10 in linux system.
        while ((ch = System.in.read()) != 10)
            System.out.print((char) ch);
        System.out.println();
    }
}