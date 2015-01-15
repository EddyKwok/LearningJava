/**
 * Listing 5-3. Discovering that an Internal Invariant can vary.
 */

public class IIDemo {
	public static void main(String[] args) {
		double temperature = 50.0; // Celscius
		if (temperature < 0.0)
			System.out.println("Water has olidified");
		else
		if (temperature >= 100.0)
			System.out.println("Water is boiling into a gas");
		else {
			// temperature > 0.0 and temperature < 100.0
			assert(temperature > 0.0 && temperature < 100.0) : temperature;
			System.out.println("Water is remainingin its liquid state");
		}
	}
}
