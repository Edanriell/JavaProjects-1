import java.time.LocalTime;
import java.time.LocalDate;

public class FeedingSchedule {
	private Dinosaur dinosaur;
	private LocalTime time;
	private LocalDate date;

	public FeedingSchedule(Dinosaur dinosaur, LocalTime time, LocalDate date) {
		this.dinosaur = dinosaur;
		this.time = time;
		this.date = date;
	}

	public Dinosaur getDinosaur() {
		return dinosaur;
	}

	public LocalTime getTime() {
		return time;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Feeding: " + dinosaur.getName() + " - Time: " + time + " - Date: " + date;
	}
}
