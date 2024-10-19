class Tyrannosaurus extends Dinosaur {
	public Tyrannosaurus(String name, String status, String location) {
		super(name, "Tyrannosaurus", status, location);
	}

	@Override
	public void displayInfo() {
		System.out.println("Tyrannosaurus: " + getName() + " | Status: " + getStatus() + " | Location History: " + getLocationHistory());
	}
}