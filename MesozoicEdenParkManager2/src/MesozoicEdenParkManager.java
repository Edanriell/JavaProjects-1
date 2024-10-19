import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MesozoicEdenParkManager {
	private List<Dinosaur> dinosaurs = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
	private List<VIPGuest> vipGuests = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	// Load initial data (could be expanded to read from files)
	public void loadInitialData() {
		dinosaurs.add(new Tyrannosaurus("Rex", "Healthy", "Zone A"));
		dinosaurs.add(new Triceratops("Cera", "Injured", "Zone B"));

		employees.add(new ParkRanger("John"));
		employees.add(new Veterinarian("Alice"));
		employees.add(new Janitor("Bob"));

		vipGuests.add(new VIPGuest("Elon Musk", "Private Tour"));
	}

	// Save data to a file
	public void saveData() throws IOException {
		FileWriter writer = new FileWriter("park_data.txt");
		writer.write("Dinosaur Data:\n");
		for (Dinosaur dino : dinosaurs) {
			writer.write(dino.getName() + ", " + dino.getSpecies() + ", " + dino.getStatus() + "\n");
		}
		writer.write("\nEmployee Data:\n");
		for (Employee emp : employees) {
			writer.write(emp.getName() + ", " + emp.getRole() + ", " + emp.getSchedule() + "\n");
		}
		writer.write("\nVIP Guests:\n");
		for (VIPGuest guest : vipGuests) {
			writer.write(guest.getName() + " attending " + guest.getEvent() + "\n");
		}
		writer.close();
		System.out.println("Data saved successfully.");
	}

	// Start the interactive console interface
	public void start() {
		while (true) {
			displayMainMenu();
			int choice = scanner.nextInt();
			try {
				handleMenuChoice(choice);
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// Display the main menu
	public void displayMainMenu() {
		System.out.println("\n--- Mesozoic Eden Park Manager ---");
		System.out.println("1. Manage Dinosaurs");
		System.out.println("2. Manage Employees");
		System.out.println("3. VIP Guest Management");
		System.out.println("4. Save Data");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
	}

	// Handle menu choices
	public void handleMenuChoice(int choice) throws InvalidInputException {
		switch (choice) {
			case 1:
				manageDinosaurs();
				break;
			case 2:
				manageEmployees();
				break;
			case 3:
				manageVIPGuests();
				break;
			case 4:
				try {
					saveData();
				} catch (IOException e) {
					System.out.println("Error saving data.");
				}
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				throw new InvalidInputException("Invalid choice. Please try again.");
		}
	}

	// Manage Dinosaurs with improved tracking and status update
	public void manageDinosaurs() throws InvalidInputException {
		System.out.println("\n--- Manage Dinosaurs ---");
		for (Dinosaur dino : dinosaurs) {
			dino.displayInfo();
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
				throw new InvalidInputException("Invalid choice.");
		}
	}

	// Add Dinosaur
	public void addDinosaur() {
		System.out.println("Enter dinosaur type (1: Tyrannosaurus, 2: Triceratops): ");
		int type = scanner.nextInt();
		scanner.nextLine();  // Consume newline
		System.out.print("Enter dinosaur name: ");
		String name = scanner.nextLine();
		System.out.print("Enter dinosaur status: ");
		String status = scanner.nextLine();
		System.out.print("Enter dinosaur initial location: ");
		String location = scanner.nextLine();

		Dinosaur dino;
		if (type == 1) {
			dino = new Tyrannosaurus(name, status, location);
		} else if (type == 2) {
			dino = new Triceratops(name, status, location);
		} else {
			System.out.println("Invalid dinosaur type.");
			return;
		}
		dinosaurs.add(dino);
		System.out.println("Dinosaur added successfully.");
	}

	// Update Dinosaur Status
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

	// Update Dinosaur Location
	public void updateDinosaurLocation() {
		System.out.print("Enter dinosaur name to update location: ");
		String name = scanner.nextLine();
		for (Dinosaur dino : dinosaurs) {
			if (dino.getName().equalsIgnoreCase(name)) {
				System.out.print("Enter new location: ");
				String location = scanner.nextLine();
				dino.addLocation(location);
				System.out.println("Location updated.");
				return;
			}
		}
		System.out.println("Dinosaur not found.");
	}

	// Manage Employees
	public void manageEmployees() throws InvalidInputException {
		System.out.println("\n--- Manage Employees ---");
		for (Employee emp : employees) {
			System.out.println(emp.getName() + " (" + emp.getRole() + ") - Schedule: " + emp.getSchedule());
		}
		System.out.println("1. Add Employee");
		System.out.println("2. Assign Schedule");
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
				throw new InvalidInputException("Invalid choice.");
		}
	}

	// Add Employee
	public void addEmployee() {
		System.out.println("Enter employee role (1: Park Ranger, 2: Veterinarian, 3: Janitor): ");
		int role = scanner.nextInt();
		scanner.nextLine();  // Consume newline
		System.out.print("Enter employee name: ");
		String name = scanner.nextLine();

		Employee emp;
		if (role == 1) {
			emp = new ParkRanger(name);
		} else if (role == 2) {
			emp = new Veterinarian(name);
		} else if (role == 3) {
			emp = new Janitor(name);
		} else {
			System.out.println("Invalid role.");
			return;
		}
		employees.add(emp);
		System.out.println("Employee added successfully.");
	}

	// Assign Schedule to Employee
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

	// Manage VIP Guests
	public void manageVIPGuests() throws InvalidInputException {
		System.out.println("\n--- Manage VIP Guests ---");
		for (VIPGuest guest : vipGuests) {
			guest.displayVIPInfo();
		}
		System.out.println("1. Add VIP Guest");
		System.out.println("2. Go Back");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
			case 1:
				addVIPGuest();
				break;
			case 2:
				return;
			default:
				throw new InvalidInputException("Invalid choice.");
		}
	}

	// Add VIP Guest
	public void addVIPGuest() {
		System.out.print("Enter VIP guest name: ");
		String name = scanner.nextLine();
		System.out.print("Enter VIP event: ");
		String event = scanner.nextLine();
		vipGuests.add(new VIPGuest(name, event));
		System.out.println("VIP guest added successfully.");
	}
}