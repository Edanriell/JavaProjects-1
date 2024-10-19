import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MesozoicEdenParkManager {

	private List<Dinosaur> dinosaurs;
	private List<Employee> employees;
	private Scanner scanner;

	public MesozoicEdenParkManager() {
		dinosaurs = new ArrayList<>();
		employees = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void loadInitialData() {
		// Add some dinosaurs
		dinosaurs.add(new TRex("Tyrant King", "Healthy", "North Zone", "Carnivore", 15));
		dinosaurs.add(new Triceratops("Trike", "Injured", "East Zone", "Herbivore", 10));

		// Add employees
		employees.add(new Veterinarian("John", "Veterinarian Department"));
		employees.add(new ParkRanger("Sara", "Security Department"));
	}

	public void start() {
		while (true) {
			displayMenu();
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline
			handleMenuChoice(choice);
		}
	}

	public void displayMenu() {
		System.out.println("\n--- Mesozoic Eden Park Manager ---");
		System.out.println("1. Manage Dinosaurs");
		System.out.println("2. Manage Employees");
		System.out.println("3. Track Dinosaurs");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
	}

	public void handleMenuChoice(int choice) {
		switch (choice) {
			case 1:
				manageDinosaurs();
				break;
			case 2:
				manageEmployees();
				break;
			case 3:
				trackDinosaurs();
				break;
			case 4:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Try again.");
		}
	}

	// Dinosaur management
	public void manageDinosaurs() {
		System.out.println("\n--- Manage Dinosaurs ---");
		for (Dinosaur dino : dinosaurs) {
			System.out.println(dino.getName() + " (" + dino.getClass().getSimpleName() + ") - Status: " + dino.getStatus() + ", Age: " + dino.getAge());
		}
		System.out.println("1. Add Dinosaur");
		System.out.println("2. Update Dinosaur Status");
		System.out.println("3. Update Dinosaur Location");
		System.out.println("4. Go Back");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
			case 1:
				addDinosaur();
				break;
			case 2:
				updateDinosaurStatus();
				break;
			case 3:
				updateDinosaurLocation();
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice.");
		}
	}

	public void addDinosaur() {
		System.out.print("Enter dinosaur type (1: TRex, 2: Triceratops): ");
		int type = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter dinosaur name: ");
		String name = scanner.nextLine();
		System.out.print("Enter dinosaur status: ");
		String status = scanner.nextLine();
		System.out.print("Enter dinosaur diet (Carnivore/Herbivore): ");
		String diet = scanner.nextLine();
		System.out.print("Enter dinosaur age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter dinosaur location: ");
		String location = scanner.nextLine();

		Dinosaur dino;
		if (type == 1) {
			dino = new TRex(name, status, location, diet, age);
		} else if (type == 2) {
			dino = new Triceratops(name, status, location, diet, age);
		} else {
			System.out.println("Invalid dinosaur type.");
			return;
		}
		dinosaurs.add(dino);
		System.out.println("Dinosaur added successfully.");
	}

	public void updateDinosaurStatus() {
		System.out.print("Enter dinosaur name to update status: ");
		String name = scanner.nextLine();
		for (Dinosaur dino : dinosaurs) {
			if (dino.getName().equalsIgnoreCase(name)) {
				System.out.print("Enter new status: ");
				String status = scanner.nextLine();
				dino.setStatus(status);
				System.out.println("Status updated.");
				return;
			}
		}
		System.out.println("Dinosaur not found.");
	}

	public void updateDinosaurLocation() {
		System.out.print("Enter dinosaur name to update location: ");
		String name = scanner.nextLine();
		for (Dinosaur dino : dinosaurs) {
			if (dino.getName().equalsIgnoreCase(name)) {
				System.out.print("Enter new location: ");
				String location = scanner.nextLine();
				dino.setLocation(location);
				System.out.println("Location updated.");
				return;
			}
		}
		System.out.println("Dinosaur not found.");
	}

	// Employee management
	public void manageEmployees() {
		System.out.println("\n--- Manage Employees ---");
		for (Employee emp : employees) {
			System.out.println(emp.getName() + " (" + emp.getClass().getSimpleName() + ") - Department: " + emp.getDepartment());
		}
		System.out.println("1. Add Employee");
		System.out.println("2. Assign Employee Schedule");
		System.out.println("3. Go Back");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				assignSchedule();
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid choice.");
		}
	}

	public void addEmployee() {
		System.out.print("Enter employee type (1: Park Ranger, 2: Veterinarian): ");
		int type = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter employee name: ");
		String name = scanner.nextLine();
		System.out.print("Enter employee department: ");
		String department = scanner.nextLine();

		Employee emp;
		if (type == 1) {
			emp = new ParkRanger(name, department);
		} else if (type == 2) {
			emp = new Veterinarian(name, department);
		} else {
			System.out.println("Invalid employee type.");
			return;
		}
		employees.add(emp);
		System.out.println("Employee added successfully.");
	}

	public void assignSchedule() {
		System.out.print("Enter employee name to assign schedule: ");
		String name = scanner.nextLine();
		for (Employee emp : employees) {
			if (emp.getName().equalsIgnoreCase(name)) {
				System.out.print("Enter new schedule: ");
				String schedule = scanner.nextLine();
				emp.setSchedule(schedule);
				System.out.println("Schedule assigned.");
				return;
			}
		}
		System.out.println("Employee not found.");
	}

	// Dinosaur tracking feature
	public void trackDinosaurs() {
		System.out.println("\n--- Dinosaur Tracking ---");
		for (Dinosaur dino : dinosaurs) {
			System.out.println("Tracking " + dino.getName() + " - Location: " + dino.getLocation());
		}
	}
}
