import java.util.UUID;

class Dinosaur {
	private final UUID id;
	private final String name;
	private final String species;
	private String status;
	private String location;

	public Dinosaur(String name, String species, String status, String location) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.species = species;
		this.status = status;
		this.location = location;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void displayInfo() {
		System.out.println("ID: " + id + ", Name: " + name + ", Species: " + species + ", Status: " + status + ", Location: " + location);
	}
}