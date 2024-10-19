import exception.DinosaurIllException;
import exception.EnclosureBreachedException;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DinosaurCareSystem careSystem = new DinosaurCareSystem();
		AlertSystem alertSystem = new AlertSystem();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n--- Mesozoic Eden Park Manager ---");
			System.out.println("1. Check Dinosaur Health");
			System.out.println("2. Check Enclosure Security");
			System.out.println("3. Display Dinosaur Status");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			try {
				switch (choice) {
					case 1:
						careSystem.checkDinosaurHealth();
						break;
					case 2:
						careSystem.checkEnclosureSecurity();
						break;
					case 3:
						careSystem.displayDinosaurStatus();
						break;
					case 4:
						System.out.println("Exiting...");
						System.exit(0);
					default:
						System.out.println("Invalid choice. Please try again.");
				}
			} catch (DinosaurIllException e) {
				System.err.println(e.getMessage());
				alertSystem.sendAlert("Dinosaur " + e.getDinosaurName() + " is ill. Immediate medical attention required!");
			} catch (EnclosureBreachedException e) {
				System.err.println(e.getMessage());
				alertSystem.sendAlert("Security breach in " + e.getEnclosureId() + ". Evacuate the area!");
			}
		}
	}
}