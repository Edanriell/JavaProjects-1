import java.util.Optional;

public class Dinosaur {
	private String name;
	private String species;
	private String healthStatus;
	private int health;  // Health score from 0 to 100
	private Trainer trainer;  // Could be null

	public Dinosaur(String name, String species, String healthStatus, int health, Trainer trainer) {
		this.name = name;
		this.species = species;
		this.healthStatus = healthStatus;
		this.health = health;
		this.trainer = trainer;
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

	public int getHealth() {
		return health;
	}

	public Optional<Trainer> getTrainer() {
		return Optional.ofNullable(trainer);
	}

	public void boostHealth(int amount) {
		this.health += amount;
		if (this.health > 100) this.health = 100;  // Max health capped at 100%
	}

	@Override
	public String toString() {
		return name + " (" + species + ") - Health: " + healthStatus + " (" + health + "%)";
	}
}
