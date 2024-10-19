import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		// Sample Dinosaurs
		Dinosaur dino1 = new Dinosaur("T-Rex", "Tyrannosaurus", "Healthy", 80, new Trainer("John"));
		Dinosaur dino2 = new Dinosaur("Bronto", "Brachiosaurus", "Ill", 30, null);
		Dinosaur dino3 = new Dinosaur("Stego", "Stegosaurus", "Critical", 15, new Trainer("Amy"));

		// Health Records
		List<HealthRecord> healthRecords = new ArrayList<>();
		healthRecords.add(new HealthRecord(dino1, 80, LocalDate.now()));
		healthRecords.add(new HealthRecord(dino2, 30, LocalDate.now()));
		healthRecords.add(new HealthRecord(dino3, 15, LocalDate.now()));

		// Feeding Schedules
		List<FeedingSchedule> feedingSchedules = new ArrayList<>();
		feedingSchedules.add(new FeedingSchedule(dino1, LocalTime.of(10, 30)));
		feedingSchedules.add(new FeedingSchedule(dino2, LocalTime.of(15, 45)));

		// Dinosaur List
		List<Dinosaur> dinosaurs = List.of(dino1, dino2, dino3);

		// Dinosaur Care System
		DinosaurCareSystem system = new DinosaurCareSystem(dinosaurs, healthRecords, feedingSchedules);

		// Sorting Dinosaurs by Health and Name
		System.out.println("Sorted Dinosaurs by Health and Name:");
		List<Dinosaur> sortedDinosaurs = system.sortDinosaursByHealthAndName();
		sortedDinosaurs.forEach(System.out::println);

		// Get critical and near-critical health records
		System.out.println("\nCritical Health Records:");
		List<HealthRecord> criticalRecords = system.getCriticalHealthRecords(30, 40);
		criticalRecords.forEach(System.out::println);

		// Morning Feeds with Notifications
		System.out.println("\nMorning Feeding Schedule:");
		system.getMorningFeedsWithNotifications();

		// Trainer Info with Notifications
		System.out.println("\nTrainer Information:");
		dinosaurs.forEach(dino -> System.out.println(system.getTrainerInfo(dino)));

		// Average Health
		System.out.println("\nAverage Dinosaur Health: " + system.calculateAverageHealth());

		// Most Critical Dinosaur
		Optional<Dinosaur> criticalDino = system.getMostCriticalDinosaur();
		criticalDino.ifPresent(dino -> System.out.println("Most Critical Dinosaur: " + dino));

		// Boost Health for Dinosaurs Below Threshold
		System.out.println("\nBoosting Health for Dinosaurs below 50 health points...");
		system.boostHealthForAllBelowThreshold(50, 10);

		// Health Distribution
		System.out.println("\nHealth Distribution:");
		Map<String, Long> healthDistribution = system.getHealthDistribution();
		healthDistribution.forEach((category, count) -> System.out.println(category + ": " + count));

		// Final Dinosaur States
		System.out.println("\nFinal Dinosaur List:");
		system.printAllDinosaurs();
	}
}
