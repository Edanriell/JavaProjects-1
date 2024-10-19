import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DinosaurCareSystem system = new DinosaurCareSystem();
		Scanner scanner = new Scanner(System.in);

		// Subscriber to notification system
		system.subscribeToNotifications(message -> System.out.println("[ALERT] Park staff notified: " + message));

		while (true) {
			System.out.println("\n--- Mesozoic Eden Dinosaur Care System ---");
			System.out.println("1. Add a dinosaur");
			System.out.println("2. Sort dinosaurs");
			System.out.println("3. Filter dinosaurs");
			System.out.println("4. Boost health for healthy dinosaurs");
			System.out.println("5. Check and notify ill dinosaurs");
			System.out.println("6. Update health (decay)");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					system.addDinosaur();
					break;
				case 2:
					System.out.print("Sort by (name, age, size, health): ");
					String sortAttribute = scanner.nextLine();
					system.sortDinosaursBy(sortAttribute);
					break;
				case 3:
					System.out.print("Filter by (species, critical): ");
					String filterType = scanner.nextLine();
					system.filterDinosaurs(filterType);
					break;
				case 4:
					System.out.println("Boosting health for healthy dinosaurs...");
					system.updateDinosaurHealth();
					break;
				case 5:
					System.out.println("Checking and notifying ill dinosaurs...");
					system.checkAndNotifyIllDinosaurs();
					break;
				case 6:
					system.updateDinosaurHealth();
					break;
				case 7:
					System.out.println("Exiting...");
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
