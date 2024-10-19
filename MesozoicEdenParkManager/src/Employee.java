import java.util.UUID;

class Employee {
	private final UUID id;
	private final String name;
	private final String role;
	private final double salary;
	private String schedule;

	public Employee(String name, String role, String schedule, double salary) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.role = role;
		this.schedule = schedule;
		this.salary = salary;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public void displayInfo() {
		System.out.println("ID: " + id + ", Name: " + name + ", Role: " + role + ", Schedule: " + schedule + ", Salary: $" + salary);
	}
}