class Triceratops extends Dinosaur {
	public Triceratops(String name, String status, String location) {
		super(name, "Triceratops", status, location);
	}

	@Override
	public void displayInfo() {
		System.out.println("Triceratops: " + getName() + " | Status: " + getStatus() + " | Location History: " + getLocationHistory());
	}
}