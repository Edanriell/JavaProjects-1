public class Staff {
	int id;
	String name;
	String role;
	double salary;
	String shift;

	Staff(int id, String name, String role, double salary, String shift) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.salary = salary;
		this.shift = shift;
	}

	@Override
	public String toString() {
		return "Staff{" +
				"id=" + id +
				", name='" + name + '\'' +
				", role='" + role + '\'' +
				", salary=" + salary +
				", shift='" + shift + '\'' +
				'}';
	}
}
