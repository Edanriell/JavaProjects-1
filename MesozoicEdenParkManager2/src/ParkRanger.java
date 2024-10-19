class ParkRanger extends Employee {
	public ParkRanger(String name) {
		super(name, "Park Ranger");
	}

	@Override
	public void performDuties() {
		System.out.println(getName() + " (Park Ranger) is patrolling the park.");
	}
}