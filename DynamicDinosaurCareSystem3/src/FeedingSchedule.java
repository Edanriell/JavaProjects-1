import java.time.LocalTime;

public class FeedingSchedule {
	private Dinosaur dinosaur;
	private LocalTime time;

	public FeedingSchedule(Dinosaur dinosaur, LocalTime time) {
		this.dinosaur = dinosaur;
		this.time = time;
	}

	public Dinosaur getDinosaur() {
		return dinosaur;
	}

	public LocalTime getTime() {
		return time;
	}

	@Override
	public String toString() {
		return dinosaur.getName() + " feeding at " + time;
	}
}
