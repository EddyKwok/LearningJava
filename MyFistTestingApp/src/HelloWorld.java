public class HelloWorld
{
	public static void main(String[] args)
	{
		System.out.println("Hello World...");
		if (args.length > 0)
			for (int i=0;i<args.length;i++)
				System.out.println("Hello "+args[i]);
	}
}
