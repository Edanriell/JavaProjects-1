import java.util.Optional;

public class Dinosaur {
	private String name;
	private String species;
	private String healthStatus;
	private int health;
	private Trainer trainer;  // Trainer object

	public Dinosaur(String name, String species, String healthStatus, int health, Trainer trainer) {
		this.name = name;
		this.species = species;
		this.healthStatus = healthStatus;
		this.health = health;
		this.trainer = trainer;  // This can be null, handled by Optional
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

	// Optional for trainer, avoids NullPointerException
	public Optional<Trainer> getTrainer() {
		return Optional.ofNullable(trainer);
	}

	public void boostHealth(int amount) {
		this.health += amount;
	}

	@Override
	public String toString() {
		return name + " (" + species + ") - Health: " + healthStatus + " (" + health + "%)";
	}
}
