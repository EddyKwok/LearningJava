import java.util.Random;
import java.util.Arrays;

class HalloArray
{
	private static Random rnd = new Random();
	public static void main(String[] args)
	{
		int[][] x = new int[2][4];
		System.out.println(x.length);
		for (int i=0;i<x.length;i++)
			for (int j=0;j<x[i].length;j++)
				x[i][j] = rnd.nextInt(100);
		System.out.println(Arrays.deepToString(x));
	}
}
