import java.util.Scanner;

public class Main {
	private static final double WEIGHT_PROPORTION  = 0.05;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the dinosaur's weight in kilograms: ");
		double dinosaurWeight = input.nextDouble();

		System.out.print("Enter the number of feedings per day: ");
		double requiredFeedingsPerDay = input.nextDouble();

		double foodNeeded = calculateDailyFood(dinosaurWeight);

		double foodPortion = calculateFoodPortion(foodNeeded, requiredFeedingsPerDay);

		System.out.printf("Our %.2f kg dinosaur needs to eat %.2f kg daily, which means we need to serve %.2f kg per feeding.%n",
				dinosaurWeight, foodNeeded, foodPortion);

		input.close();
	}

	private static double calculateDailyFood(double weight) {
		return weight * WEIGHT_PROPORTION;
	}

	private static double calculateFoodPortion(double totalFood, double feedingsPerDay) {
		return totalFood / feedingsPerDay;
	}
}