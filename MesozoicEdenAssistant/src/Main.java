import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	Scanner scanner = new Scanner(System.in);

	List<Dinosaur> dinosaurList = new ArrayList<>();
	List<Staff> staffList = new ArrayList<>();

	double parkOpeningHour = 8.00;
	double parkClosingHour = 20.00;

	int maxVisitorCount = 420;
	int currentVisitorCount = 0;

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

	public void start() {
		while (true) {
			displayMenu();
			int choice = scanner.nextInt();
			handleMenuChoice(choice);
		}
	}

	public void displayMenu() {
		System.out.println("1. Add Dinosaur");
		System.out.println("2. Remove Dinosaur");
		System.out.println("3. Check Park Hours");
		System.out.println("4. Greet Guest");
		System.out.println("5. Check Visitors Count");
		System.out.println("6. Manage Staff");
		System.out.println("7. Exit");
		System.out.print("Enter your choice: ");
	}

	public void handleMenuChoice(int choice) {
		switch (choice) {
			case 1:
				addDinosaur();
				break;
			case 2:
				removeDinosaur();
				break;
			case 3:
				checkParkHours();
				break;
			case 4:
				greetGuest();
				break;
			case 5:
				checkVisitorsCount();
				break;
			case 6:
				manageStaff();
				break;
			case 7:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
		}
	}

	public void addDinosaur() {
		System.out.println("Enter Dinosaur ID:");
		int id = scanner.nextInt();

		System.out.println("Enter Dinosaur name:");
		String name = scanner.next();

		System.out.println("Enter Dinosaur species:");
		String species = scanner.next();

		System.out.println("Enter Dinosaur weight (in kg):");
		double weight = scanner.nextDouble();

		System.out.println("Enter Dinosaur height (in meters):");
		double height = scanner.nextDouble();

		System.out.println("Enter Dinosaur diet (Herbivore/Carnivore/Omnivore):");
		String diet = scanner.next();

		dinosaurList.add(new Dinosaur(id, name, species, weight, height, diet));
		System.out.println("Dinosaur added: " + name);
	}

	public void removeDinosaur() {
		System.out.println("Enter the ID of the Dinosaur you want to remove:");
		int id = scanner.nextInt();

		boolean removed = dinosaurList.removeIf(dinosaur -> dinosaur.id == id);

		if (removed) {
			System.out.println("Dinosaur with ID " + id + " has been removed.");
		} else {
			System.out.println("Dinosaur with ID " + id + " was not found.");
		}
	}

	public void checkParkHours() {
		System.out.println("Enter the current time (e.g., 14.30 for 2:30 PM):");
		double currentTime = scanner.nextDouble();

		if (currentTime >= parkOpeningHour && currentTime < parkClosingHour) {
			System.out.println("The park is open.");
		} else {
			System.out.println("The park is closed.");
		}
	}

	public void greetGuest() {
		System.out.println("Enter guest name:");
		String name = scanner.next();
		System.out.println("Hello " + name + ", welcome to Mesozoic Eden Park!");
	}

	public void checkVisitorsCount() {
		System.out.println("Enter the number of visitors entering the park:");
		int enteringVisitors = scanner.nextInt();

		if (currentVisitorCount + enteringVisitors > maxVisitorCount) {
			System.out.println("Sorry, the park is at full capacity. Please wait for some visitors to leave.");
		} else {
			currentVisitorCount += enteringVisitors;
			System.out.println("Visitors entered. Current visitor count: " + currentVisitorCount);
		}
	}

	public void manageStaff() {
		System.out.println("1. Add Staff");
		System.out.println("2. Remove Staff");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				addStaff();
				break;
			case 2:
				removeStaff();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
		}
	}

	public void addStaff() {
		System.out.println("Enter Staff ID:");
		int id = scanner.nextInt();

		System.out.println("Enter Staff name:");
		String name = scanner.next();

		System.out.println("Enter Staff role (e.g., Zookeeper, Guide, Veterinarian):");
		String role = scanner.next();

		System.out.println("Enter Staff salary:");
		double salary = scanner.nextDouble();

		System.out.println("Enter Staff shift (Morning/Evening/Night):");
		String shift = scanner.next();

		staffList.add(new Staff(id, name, role, salary, shift));
		System.out.println("Staff added: " + name);
	}

	public void removeStaff() {
		System.out.println("Enter the ID of the Staff you want to remove:");
		int id = scanner.nextInt();

		boolean removed = staffList.removeIf(staff -> staff.id == id);

		if (removed) {
			System.out.println("Staff with ID " + id + " has been removed.");
		} else {
			System.out.println("Staff with ID " + id + " was not found.");
		}
	}
}