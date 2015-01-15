public class IncDemo
{
	static int idx1, idx2;
	
	public static void main(String[] args)
	{
		System.out.println("static int idx1, idx2;");
		System.out.println();
		show(1);show(2);
	}
	
	// I have unintentionally tested to write the private method like this "static private void show(int id)"
	// and it was run successfully also, no error.
	private static void show(int id)
	{
		System.out.println("System.out.println(idx"+id+") = "+(id==1 ? idx1 : idx2));
		System.out.println("System.out.println("+(id==2 ? "++" : "")+"idx"+id+(id==1 ? "++" : "")+") = "+(id==1 ? idx1++ : ++idx2));
		System.out.println("System.out.println(idx"+id+") = "+(id==1 ? idx1 : idx2));
		System.out.println();
	}
}