class Veterinarian extends Employee {
	public Veterinarian(String name) {
		super(name, "Veterinarian");
	}

	@Override
	public void performDuties() {
		System.out.println(getName() + " (Veterinarian) is checking the health of the dinosaurs.");
	}
}