import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		DinosaurCareSystem system = new DinosaurCareSystem();

		// Create dinosaurs
		Dinosaur dino1 = new Dinosaur("T-Rex", "Tyrannosaurus", "Healthy", 80, new Trainer("John"));
		Dinosaur dino2 = new Dinosaur("Bronto", "Brachiosaurus", "Ill", 30, null);
		Dinosaur dino3 = new Dinosaur("Stego", "Stegosaurus", "Critical", 15, new Trainer("Amy"));

		system.addDinosaur(dino1);
		system.addDinosaur(dino2);
		system.addDinosaur(dino3);

		// Create health records
		system.addHealthRecord(new HealthRecord(dino1, 80, LocalDate.now()));
		system.addHealthRecord(new HealthRecord(dino2, 18, LocalDate.now()));
		system.addHealthRecord(new HealthRecord(dino3, 15, LocalDate.now()));

		// Create feeding schedules
		system.addFeedingSchedule(new FeedingSchedule(dino1, LocalTime.of(10, 30), LocalDate.now()));
		system.addFeedingSchedule(new FeedingSchedule(dino2, LocalTime.of(14, 30), LocalDate.now()));
		system.addFeedingSchedule(new FeedingSchedule(dino3, LocalTime.of(9, 00), LocalDate.now()));

		// Display all dinosaurs
		System.out.println("All Dinosaurs:");
		system.printAllDinosaurs();

		// Dynamic Sorting: Sort by name
		System.out.println("\nDinosaurs Sorted by Name:");
		system.sortDinosaurs(Comparator.comparing(Dinosaur::getName)).forEach(System.out::println);

		// Dynamic Filtering: Filter by species and trainer presence
		System.out.println("\nDinosaurs of Species 'Tyrannosaurus' with Trainers:");
		system.filterDinosaurs("Tyrannosaurus", true).forEach(System.out::println);

		// Aggregation: Calculate average health
		System.out.println("\nAverage Health of Dinosaurs: " + system.getAverageHealth());

		// Aggregation: Count critical health dinosaurs
		System.out.println("Number of Critical Health Dinosaurs: " + system.countDinosaursByHealthStatus("Critical"));

		// Batch Health Boost: Boost health of healthy dinosaurs
		system.batchBoostHealth(10);
		System.out.println("\nAfter Health Boost (Healthy Dinosaurs):");
		system.printAllDinosaurs();

		// Stream: Get critical health records
		System.out.println("\nCritical Health Records:");
		system.getCriticalHealthRecords().forEach(System.out::println);

		// Optional: Print dinosaur trainer info
		System.out.println("\nTrainer Information:");
		system.printDinosaurTrainerInfo();

		// Parallel Stream: Process health records
		System.out.println("\nProcessing Health Records in Parallel:");
		system.processHealthRecordsInParallel();

		// Notifications: Notify staff about critical dinosaurs
		System.out.println("\nSending Notifications:");
		system.notifyStaff(System.out::println);
	}
}
