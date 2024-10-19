public class Dinosaur {
	private String name;
	private String species;
	private String healthStatus;
	private int size;
	private int age;
	private int health;

	public Dinosaur(String name, String species, String healthStatus, int size, int age, int health) {
		this.name = name;
		this.species = species;
		this.healthStatus = healthStatus;
		this.size = size;
		this.age = age;
		this.health = health;
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

	public boolean isIll() {
		return healthStatus.equalsIgnoreCase("ill");
	}

	public int getSize() {
		return size;
	}

	public int getAge() {
		return age;
	}

	public int getHealth() {
		return health;
	}

	public void decreaseHealth(int amount) {
		this.health -= amount;
		if (this.health < 0) this.health = 0;
		if (this.health < 20) this.healthStatus = "critical";
	}

	public void increaseHealth(int amount) {
		this.health += amount;
		if (this.health > 100) this.health = 100;
		if (this.health > 20 && this.healthStatus.equals("critical")) this.healthStatus = "stable";
	}

	@Override
	public String toString() {
		return name + " (" + species + ") - Size: " + size + " - Age: " + age + " - Health: " + healthStatus + " (" + health + "%)";
	}
}
