public class Dinosaur {
	String name;
	int[] feedingTimes;
	int foodPortion;

	Dinosaur(String name, int[] feedingTimes, int foodPortion) {
		this.name = name;
		this.feedingTimes = feedingTimes;
		this.foodPortion = foodPortion;
	}

	boolean isFeedingTime(int hour) {
		for (int time : feedingTimes) {
			if (hour == time) {
				return true;
			}
		}
		return false;
	}
}
