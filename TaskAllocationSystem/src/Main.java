import java.util.*;

enum Role {
	FEEDING,
	CLEANING,
	SECURITY,
	TOUR_GUIDE
}

class Employee {
	private String name;
	private Role role;

	public Employee(String name, Role role) {
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}
}

class TaskAssignmentManager {
	private List<Employee> employees;
	private int safetyRating; // Assuming a safety rating from 1 to 10

	public TaskAssignmentManager() {
		this.employees = new ArrayList<>();
		this.safetyRating = 8; // Default safety rating
	}

	public void addEmployee(String name, Role role) {
		employees.add(new Employee(name, role));
	}

	public void assignTasks() {
		for (Employee employee: employees) {
			String task = determineTask(employee);
			System.out.println("Assigning task to " + employee.getName() + ": " + task);
		}
	}

	private String determineTask(Employee employee) {
		switch (employee.getRole()) {
			case FEEDING -> {
				return "Feed dinosaurs";
			}
			case CLEANING -> {
				return "Clean dinosaur enclosures";
			}
			case SECURITY -> {
				if (safetyRating >= 7) {
					return "Patrol and ensure park security";
				} else {
					return "Assist in improving park security measures";
				}
			}
			case TOUR_GUIDE -> {
				return "Conduct guided tours for visitors";
			}
			default -> {
				return "No specific task assigned";
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		TaskAssignmentManager manager = new TaskAssignmentManager();

		manager.addEmployee("John Doe", Role.FEEDING);
		manager.addEmployee("Jane Smith", Role.CLEANING);
		manager.addEmployee("David Brown", Role.SECURITY);
		manager.addEmployee("Emily Green", Role.TOUR_GUIDE);

		manager.assignTasks();
	}
}
