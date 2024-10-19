import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class MesozoicEdenParkManager {
	Scanner scanner = new Scanner(System.in);

	// Using HashMaps for easier access by UUID
	Map<UUID, Dinosaur> dinosaurMap = new HashMap<>();
	Map<UUID, Employee> employeeMap = new HashMap<>();
	Map<UUID, Guest> guestMap = new HashMap<>();
	
	public void initializeData() {
		// Add sample dinosaurs
		dinosaurMap.put(UUID.randomUUID(), new Dinosaur("T-Rex", "Tyrannosaurus Rex", "Healthy", "Zone A"));
		dinosaurMap.put(UUID.randomUUID(), new Dinosaur("Brachy", "Brachiosaurus", "Sick", "Zone B"));

		// Add sample employees
		employeeMap.put(UUID.randomUUID(), new Employee("Alice", "Zookeeper", "Morning", 50000));
		employeeMap.put(UUID.randomUUID(), new Employee("Bob", "Security", "Night", 40000));

		// Add sample guests
		guestMap.put(UUID.randomUUID(), new Guest("John Doe", "VIP", 150.0));
		guestMap.put(UUID.randomUUID(), new Guest("Jane Doe", "Regular", 50.0));
	}

	public void start() {
		while (true) {
			displayMenu();
			int choice = scanner.nextInt();
			handleMenuChoice(choice);
		}
	}

	public void displayMenu() {
		System.out.println("\nWelcome to Mesozoic Eden Park Manager!");
		System.out.println("1. Manage Dinosaurs");
		System.out.println("2. Manage Park Employees");
		System.out.println("3. Manage Tickets");
		System.out.println("4. Check Park Status");
		System.out.println("5. Handle Emergencies");
		System.out.println("6. Exit");
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
				manageTickets();
				break;
			case 4:
				checkParkStatus();
				break;
			case 5:
				handleEmergencies();
				break;
			case 6:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
		}
	}

	// Dinosaur Management
	public void manageDinosaurs() {
		System.out.println("\n--- Manage Dinosaurs ---");
		System.out.println("1. View Dinosaurs");
		System.out.println("2. Add Dinosaur");
		System.out.println("3. Edit Dinosaur Status");
		System.out.println("4. Edit Dinosaur Location");
		System.out.println("5. Remove Dinosaur");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine();  // consume the newline

		switch (choice) {
			case 1:
				viewDinosaurs();
				break;
			case 2:
				addDinosaur();
				break;
			case 3:
				editDinosaurStatus();
				break;
			case 4:
				editDinosaurLocation();
				break;
			case 5:
				removeDinosaur();
				break;
			default:
				System.out.println("Invalid choice.");
		}
	}

	// Employee Management
	public void manageEmployees() {
		System.out.println("\n--- Manage Employees ---");
		System.out.println("1. View Employees");
		System.out.println("2. Add Employee");
		System.out.println("3. Edit Employee Schedule");
		System.out.println("4. Remove Employee");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine();  // consume the newline

		switch (choice) {
			case 1:
				viewEmployees();
				break;
			case 2:
				addEmployee();
				break;
			case 3:
				editEmployeeSchedule();
				break;
			case 4:
				removeEmployee();
				break;
			default:
				System.out.println("Invalid choice.");
		}
	}

	// Ticket/Guest Management
	public void manageTickets() {
		System.out.println("\n--- Manage Tickets ---");
		System.out.println("1. View Guests");
		System.out.println("2. Add Guest");
		System.out.println("3. Remove Guest");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine();  // consume the newline

		switch (choice) {
			case 1:
				viewGuests();
				break;
			case 2:
				addGuest();
				break;
			case 3:
				removeGuest();
				break;
			default:
				System.out.println("Invalid choice.");
		}
	}

	// Park Status
	public void checkParkStatus() {
		System.out.println("\n--- Park Status ---");
		System.out.println("Dinosaurs in the park: " + dinosaurMap.size());
		System.out.println("Employees in the park: " + employeeMap.size());
		System.out.println("Guests in the park: " + guestMap.size());
	}

	// Emergency Handling (Advanced feature)
	public void handleEmergencies() {
		System.out.println("\n--- Emergency Alert ---");
		System.out.println("1. Dinosaur Escape");
		System.out.println("2. Medical Emergency");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				System.out.println("Dinosaur has escaped! Initiating lockdown protocol...");
				break;
			case 2:
				System.out.println("Medical emergency! Dispatching medical team...");
				break;
			default:
				System.out.println("Invalid emergency type.");
		}
	}

	// Methods to View, Add, Edit, Remove Dinosaurs
	public void viewDinosaurs() {
		System.out.println("\n--- Dinosaurs in the Park ---");
		dinosaurMap.values().forEach(Dinosaur::displayInfo);
	}

	public void addDinosaur() {
		System.out.print("Enter Dinosaur Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Dinosaur Species: ");
		String species = scanner.nextLine();
		System.out.print("Enter Dinosaur Status: ");
		String status = scanner.nextLine();
		System.out.print("Enter Dinosaur Location: ");
		String location = scanner.nextLine();

		dinosaurMap.put(UUID.randomUUID(), new Dinosaur(name, species, status, location));
		System.out.println("Dinosaur added.");
	}

	public void editDinosaurStatus() {
		System.out.print("Enter Dinosaur ID to Edit: ");
		UUID id = UUID.fromString(scanner.nextLine());
		if (dinosaurMap.containsKey(id)) {
			System.out.print("Enter new Status: ");
			String status = scanner.nextLine();
			dinosaurMap.get(id).setStatus(status);
			System.out.println("Dinosaur status updated.");
		} else {
			System.out.println("Dinosaur not found.");
		}
	}

	public void editDinosaurLocation() {
		System.out.print("Enter Dinosaur ID to Edit: ");
		UUID id = UUID.fromString(scanner.nextLine());
		if (dinosaurMap.containsKey(id)) {
			System.out.print("Enter new Location: ");
			String location = scanner.nextLine();
			dinosaurMap.get(id).setLocation(location);
			System.out.println("Dinosaur location updated.");
		} else {
			System.out.println("Dinosaur not found.");
		}
	}

	public void removeDinosaur() {
		System.out.print("Enter Dinosaur ID to Remove: ");
		UUID id = UUID.fromString(scanner.nextLine());
		dinosaurMap.remove(id);
		System.out.println("Dinosaur removed.");
	}

	// Methods to View, Add, Edit, Remove Employees
	public void viewEmployees() {
		System.out.println("\n--- Park Employees ---");
		employeeMap.values().forEach(Employee::displayInfo);
	}

	public void addEmployee() {
		System.out.print("Enter Employee Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Employee Role: ");
		String role = scanner.nextLine();
		System.out.print("Enter Employee Schedule: ");
		String schedule = scanner.nextLine();
		System.out.print("Enter Employee Salary: ");
		double salary = scanner.nextDouble();
		scanner.nextLine();  // consume the newline

		employeeMap.put(UUID.randomUUID(), new Employee(name, role, schedule, salary));
		System.out.println("Employee added.");
	}

	public void editEmployeeSchedule() {
		System.out.print("Enter Employee ID to Edit: ");
		UUID id = UUID.fromString(scanner.nextLine());
		if (employeeMap.containsKey(id)) {
			System.out.print("Enter new Schedule: ");
			String schedule = scanner.nextLine();
			employeeMap.get(id).setSchedule(schedule);
			System.out.println("Employee schedule updated.");
		} else {
			System.out.println("Employee not found.");
		}
	}

	public void removeEmployee() {
		System.out.print("Enter Employee ID to Remove: ");
		UUID id = UUID.fromString(scanner.nextLine());
		employeeMap.remove(id);
		System.out.println("Employee removed.");
	}

	// Methods to View, Add, Remove Guests
	public void viewGuests() {
		System.out.println("\n--- Park Guests ---");
		guestMap.values().forEach(Guest::displayInfo);
	}

	public void addGuest() {
		System.out.print("Enter Guest Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Ticket Type (e.g., Regular, VIP): ");
		String ticketType = scanner.nextLine();
		System.out.print("Enter Ticket Price: ");
		double price = scanner.nextDouble();
		scanner.nextLine();  // consume the newline

		guestMap.put(UUID.randomUUID(), new Guest(name, ticketType, price));
		System.out.println("Guest added.");
	}

	public void removeGuest() {
		System.out.print("Enter Guest ID to Remove: ");
		UUID id = UUID.fromString(scanner.nextLine());
		guestMap.remove(id);
		System.out.println("Guest removed.");
	}
}