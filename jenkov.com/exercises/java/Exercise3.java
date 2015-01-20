package exercises.java;

public class Exercise3 {
	public static void main(String[] args) {
		int[] numbers = {5, 10, 12, 13, 15};
		int sum = 0;

		for (int i=0;i<numbers.length;i++)
			sum += numbers[i];

		System.out.println("Sum : " + sum);
	}
}
