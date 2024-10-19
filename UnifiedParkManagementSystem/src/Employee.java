public abstract class Employee {
	private String name;
	private String department;
	private String schedule;

	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
}
