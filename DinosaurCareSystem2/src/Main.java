import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DinosaurCareSystem system = new DinosaurCareSystem();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n--- Mesozoic Eden Dinosaur Care System ---");
			System.out.println("1. Add a dinosaur");
			System.out.println("2. Log an activity");
			System.out.println("3. View activity log");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					system.addDinosaur();
					break;
				case 2:
					system.logActivity();
					break;
				case 3:
					system.displayActivities();
					break;
				case 4:
					System.out.println("Exiting...");
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}

