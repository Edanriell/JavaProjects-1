import java.util.ArrayList;
import java.util.List;

abstract class Dinosaur {
	private String name;
	private String species;
	private String status;
	private List<String> locationHistory;

	public Dinosaur(String name, String species, String status, String location) {
		this.name = name;
		this.species = species;
		this.status = status;
		this.locationHistory = new ArrayList<>();
		this.locationHistory.add(location);
	}

	public String getName() { return name; }
	public String getSpecies() { return species; }
	public String getStatus() { return status; }
	public List<String> getLocationHistory() { return locationHistory; }

	public void setStatus(String status) { this.status = status; }
	public void addLocation(String location) { this.locationHistory.add(location); }

	public abstract void displayInfo();
}