abstract class Employee {
	private String name;
	private String role;
	private String schedule;

	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
		this.schedule = "Not Assigned";
	}

	public String getName() { return name; }
	public String getRole() { return role; }
	public String getSchedule() { return schedule; }

	public void setSchedule(String schedule) { this.schedule = schedule; }

	public abstract void performDuties();
}