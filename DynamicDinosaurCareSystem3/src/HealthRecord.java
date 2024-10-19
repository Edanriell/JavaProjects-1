import java.time.LocalDate;

public class HealthRecord {
	private Dinosaur dinosaur;
	private int healthStatus;  // 0 - 100 health range
	private LocalDate date;

	public HealthRecord(Dinosaur dinosaur, int healthStatus, LocalDate date) {
		this.dinosaur = dinosaur;
		this.healthStatus = healthStatus;
		this.date = date;
	}

	public Dinosaur getDinosaur() {
		return dinosaur;
	}

	public int getHealthStatus() {
		return healthStatus;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return dinosaur.getName() + " - Health: " + healthStatus + "% on " + date;
	}
}
