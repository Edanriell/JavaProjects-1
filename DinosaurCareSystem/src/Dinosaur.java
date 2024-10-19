public class Dinosaur {
	private String name;
	private String species;
	private String enclosureId;
	private boolean isIll;

	public Dinosaur(String name, String species, String enclosureId) {
		this.name = name;
		this.species = species;
		this.enclosureId = enclosureId;
		this.isIll = false;
	}

	public String getName() {
		return name;
	}

	public String getSpecies() {
		return species;
	}

	public String getEnclosureId() {
		return enclosureId;
	}

	public boolean isIll() {
		return isIll;
	}

	public void setIll(boolean ill) {
		isIll = ill;
	}

	@Override
	public String toString() {
		return name + " (" + species + ") in Enclosure: " + enclosureId;
	}
}
