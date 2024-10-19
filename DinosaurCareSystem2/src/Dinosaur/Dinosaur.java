package Dinosaur;

public class Dinosaur {
	private String name;
	private String species;
	private String healthStatus;

	public Dinosaur(String name, String species, String healthStatus) {
		this.name = name;
		this.species = species;
		this.healthStatus = healthStatus;
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

	@Override
	public String toString() {
		return name + " (" + species + ") - Health: " + healthStatus;
	}
}
