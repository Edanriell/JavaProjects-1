public class Dinosaur {
	private String name;
	private String species;
	private String healthStatus;
	private int size; // Size of dinosaur (for sorting purposes)
	private int age; // Age of the dinosaur

	public Dinosaur(String name, String species, String healthStatus, int size, int age) {
		this.name = name;
		this.species = species;
		this.healthStatus = healthStatus;
		this.size = size;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSpecies() {
		return species;
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public int getSize() {
		return size;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return name + " (" + species + ") - Size: " + size + " - Age: " + age + " - Health: " + healthStatus;
	}
}
