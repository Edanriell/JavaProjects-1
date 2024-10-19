class Janitor extends Employee {
	public Janitor(String name) {
		super(name, "Janitor");
	}

	@Override
	public void performDuties() {
		System.out.println(getName() + " (Janitor) is cleaning the park.");
	}
}