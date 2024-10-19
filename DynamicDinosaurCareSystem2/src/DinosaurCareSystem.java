import java.time.LocalTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class DinosaurCareSystem {
	private List<Dinosaur> dinosaurs;
	private List<HealthRecord> healthRecords;
	private List<FeedingSchedule> feedingSchedules;
	private static final int CRITICAL_HEALTH_THRESHOLD = 20;

	public DinosaurCareSystem() {
		dinosaurs = new ArrayList<>();
		healthRecords = new ArrayList<>();
		feedingSchedules = new ArrayList<>();
	}

	public void addDinosaur(Dinosaur dinosaur) {
		dinosaurs.add(dinosaur);
	}

	public void addHealthRecord(HealthRecord record) {
		healthRecords.add(record);
	}

	public void addFeedingSchedule(FeedingSchedule schedule) {
		feedingSchedules.add(schedule);
	}

	// Dynamic Sorting: Sort by different parameters
	public List<Dinosaur> sortDinosaurs(Comparator<Dinosaur> comparator) {
		return dinosaurs.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
	}

	// Dynamic Filtering: Filter by health, species, or trainer presence
	public List<Dinosaur> filterDinosaurs(String species, boolean filterByTrainerPresence) {
		return dinosaurs.stream()
				.filter(d -> d.getSpecies().equalsIgnoreCase(species))
				.filter(d -> filterByTrainerPresence == d.getTrainer().isPresent())
				.collect(Collectors.toList());
	}

	// Aggregation: Calculate average health of dinosaurs
	public double getAverageHealth() {
		return dinosaurs.stream()
				.mapToInt(Dinosaur::getHealth)
				.average()
				.orElse(0);
	}

	// Aggregation: Count dinosaurs with a specific health status
	public long countDinosaursByHealthStatus(String status) {
		return dinosaurs.stream()
				.filter(d -> d.getHealthStatus().equalsIgnoreCase(status))
				.count();
	}

	// Batch health boost: Apply health boosts for all healthy dinosaurs
	public void batchBoostHealth(int amount) {
		dinosaurs.stream()
				.filter(d -> d.getHealthStatus().equalsIgnoreCase("healthy"))
				.forEach(d -> d.boostHealth(amount));
	}

	// Stream: Find all health records below a critical threshold
	public List<HealthRecord> getCriticalHealthRecords() {
		return healthRecords.stream()
				.filter(record -> record.getHealthStatus() < CRITICAL_HEALTH_THRESHOLD)
				.collect(Collectors.toList());
	}

	// Use Optional to avoid NullPointerException
	public void printDinosaurTrainerInfo() {
		dinosaurs.forEach(dino -> {
			String trainerName = dino.getTrainer()
					.map(trainer -> "Trainer: " + trainer.getName())
					.orElse("No trainer assigned");
			System.out.println(dino.getName() + " - " + trainerName);
		});
	}

	// Parallel Stream: Process health records in parallel
	public void processHealthRecordsInParallel() {
		healthRecords.parallelStream()
				.forEach(record -> {
					System.out.println("Processing record: " + record.getDinosaur().getName() + " - " + record.getDate());
				});
	}

	// Notifications: Use method reference to notify staff about events
	public void notifyStaff(Consumer<String> notificationMethod) {
		dinosaurs.stream()
				.filter(d -> d.getHealthStatus().equalsIgnoreCase("critical"))
				.forEach(d -> notificationMethod.accept("URGENT: " + d.getName() + " needs immediate care!"));
	}

	// Display all dinosaurs in the system
	public void printAllDinosaurs() {
		dinosaurs.forEach(System.out::println);
	}

	// Display all health records in the system
	public void printAllHealthRecords() {
		healthRecords.forEach(System.out::println);
	}

	// Display all feeding schedules in the system
	public void printAllFeedingSchedules() {
		feedingSchedules.forEach(System.out::println);
	}
}
