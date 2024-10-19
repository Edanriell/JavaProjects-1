import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Dinosaur> dinosaurs = new ArrayList<>();

		dinosaurs.add(new Dinosaur("T-Rex", new int[]{8, 14, 20}, 100));
		dinosaurs.add(new Dinosaur("Brachiosaurus", new int[]{7, 11, 15, 19}, 250));
		dinosaurs.add(new Dinosaur("Velociraptor", new int[]{6, 12, 18, 22}, 50));
		dinosaurs.add(new Dinosaur("Triceratops", new int[]{9, 13, 17, 21}, 150));

		for (int hour = 0; hour < 24; hour++) {
			checkFeedingTimes(dinosaurs, hour);
		}
	}

	public static void checkFeedingTimes(List<Dinosaur> dinosaurs, int hour) {
		for (Dinosaur dinosaur : dinosaurs) {
			if (dinosaur.isFeedingTime(hour)) {
				System.out.println("It's " + hour + ":00 - Feeding time for " + dinosaur.name +
						" with " + dinosaur.foodPortion + "kg of food.");
			}
		}
	}
}
