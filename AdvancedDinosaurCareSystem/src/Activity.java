import java.time.LocalDate;

public class Activity {
	private String activityName;
	private LocalDate date;
	private Dinosaur dinosaur;
	private String activityType; // Feeding, Training, Medical, etc.
	private int durationMinutes; // Activity duration in minutes

	public Activity(String activityName, LocalDate date, Dinosaur dinosaur, String activityType, int durationMinutes) {
		this.activityName = activityName;
		this.date = date;
		this.dinosaur = dinosaur;
		this.activityType = activityType;
		this.durationMinutes = durationMinutes;
	}

	public String getActivityName() {
		return activityName;
	}

	public LocalDate getDate() {
		return date;
	}

	public Dinosaur getDinosaur() {
		return dinosaur;
	}

	public String getActivityType() {
		return activityType;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	@Override
	public String toString() {
		return "Activity: " + activityName + " (" + activityType + " for " + durationMinutes + " mins) on " + date + " for " + dinosaur.getName();
	}
}
