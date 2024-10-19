package Activity;

import Dinosaur.Dinosaur;
import java.time.LocalDate;

public class Activity {
	private String activityName;
	private LocalDate date;
	private Dinosaur dinosaur;

	public Activity(String activityName, LocalDate date, Dinosaur dinosaur) {
		this.activityName = activityName;
		this.date = date;
		this.dinosaur = dinosaur;
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

	@Override
	public String toString() {
		return "Activity: " + activityName + " on " + date + " for " + dinosaur.getName();
	}
}
