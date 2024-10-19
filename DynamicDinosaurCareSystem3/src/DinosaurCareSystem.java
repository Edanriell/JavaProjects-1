import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DinosaurCareSystem {
	private List<Dinosaur> dinosaurs;
	private List<HealthRecord> healthRecords;
	private List<FeedingSchedule> feedingSchedules;

	public DinosaurCareSystem(List<Dinosaur> dinosaurs, List<HealthRecord> healthRecords, List<FeedingSchedule> feedingSchedules) {
		this.dinosaurs = dinosaurs;
		this.healthRecords = healthRecords;
		this.feedingSchedules = feedingSchedules;
	}

	// Advanced Sorting: Multi-criteria sorting by health and name
	public List<Dinosaur> sortDinosaursByHealthAndName() {
		return dinosaurs.stream()
				.sorted(Comparator.comparingInt(Dinosaur::getHealth)
						.thenComparing(Dinosaur::getName))
				.collect(Collectors.toList());
	}

	// Health records: Critical and Near-Critical Alerts
	public List<HealthRecord> getCriticalHealthRecords(int criticalThreshold, int nearCriticalThreshold) {
		return healthRecords.stream()
				.filter(record -> record.getHealthStatus() < criticalThreshold || record.getHealthStatus() <= nearCriticalThreshold)
				.collect(Collectors.toList());
	}

	// Morning feeds with notification
	public List<FeedingSchedule> getMorningFeedsWithNotifications() {
		List<FeedingSchedule> morningFeeds = feedingSchedules.stream()
				.filter(schedule -> schedule.getTime().isBefore(LocalTime.NOON))
				.collect(Collectors.toList());

		morningFeeds.forEach(feed -> System.out.println("Reminder: " + feed.getDinosaur().getName() + " needs to be fed in the morning."));
		return morningFeeds;
	}

	// Advanced: Get trainer info or notify if no trainer
	public String getTrainerInfo(Dinosaur dinosaur) {
		return dinosaur.getTrainer()
				.map(trainer -> "Trainer: " + trainer.getName())
				.orElseGet(() -> {
					System.out.println("Alert: " + dinosaur.getName() + " has no assigned trainer!");
					return "No trainer assigned";
				});
	}

	// Calculate average health of all dinosaurs
	public double calculateAverageHealth() {
		return dinosaurs.stream()
				.mapToInt(Dinosaur::getHealth)
				.average()
				.orElse(0.0);  // Return 0.0 if the stream is empty
	}

	// Find the most critical dinosaur (lowest health)
	public Optional<Dinosaur> getMostCriticalDinosaur() {
		return dinosaurs.stream()
				.min(Comparator.comparingInt(Dinosaur::getHealth));
	}

	// Parallel processing of health data: boosting health for all dinosaurs below a threshold
	public void boostHealthForAllBelowThreshold(int threshold, int boostAmount) {
		dinosaurs.parallelStream()
				.filter(dinosaur -> dinosaur.getHealth() < threshold)
				.forEach(dinosaur -> dinosaur.boostHealth(boostAmount));
	}

	// Statistical health analysis: how many dinosaurs fall into each health category
	public Map<String, Long> getHealthDistribution() {
		return dinosaurs.stream()
				.collect(Collectors.groupingBy(dinosaur -> {
					if (dinosaur.getHealth() >= 80) return "Healthy";
					else if (dinosaur.getHealth() >= 50) return "Moderate";
					else return "Critical";
				}, Collectors.counting()));
	}

	// Print all dinosaurs
	public void printAllDinosaurs() {
		dinosaurs.forEach(System.out::println);
	}
}
