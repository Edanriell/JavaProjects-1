import java.util.Comparator;

public class DinosaurComparator implements Comparator<Dinosaur> {

	private String sortBy;

	public DinosaurComparator(String sortBy) {
		this.sortBy = sortBy;
	}

	@Override
	public int compare(Dinosaur d1, Dinosaur d2) {
		switch (sortBy) {
			case "size":
				return Integer.compare(d1.getSize(), d2.getSize());
			case "age":
				return Integer.compare(d1.getAge(), d2.getAge());
			case "health":
				return d1.getHealthStatus().compareTo(d2.getHealthStatus());
			default:
				return d1.getName().compareTo(d2.getName()); // Default is by name
		}
	}
}
