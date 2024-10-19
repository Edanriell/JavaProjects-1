import Dinosaur.Dinosaur;
import Activity.Activity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DinosaurCareSystem {
	private List<Dinosaur> dinosaurs;
	private List<Activity> activities;
	private Scanner scanner;

	public DinosaurCareSystem() {
		dinosaurs = new ArrayList<>();
		activities = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void addDinosaur() {
		System.out.print("Enter dinosaur name: ");
		String name = scanner.nextLine();
		System.out.print("Enter dinosaur species: ");
		String species = scanner.nextLine();
		System.out.print("Enter dinosaur health status: ");
		String healthStatus = scanner.nextLine();

		Dinosaur newDinosaur = new Dinosaur(name, species, healthStatus);
		dinosaurs.add(newDinosaur);

		System.out.println("Dinosaur added: " + newDinosaur);
	}

	public void logActivity() {
		if (dinosaurs.isEmpty()) {
			System.out.println("No dinosaurs available. Add a dinosaur first.");
			return;
		}

		System.out.println("Select a dinosaur by number:");
		for (int i = 0; i < dinosaurs.size(); i++) {
			System.out.println((i + 1) + ". " + dinosaurs.get(i));
		}

		int dinosaurIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline

		if (dinosaurIndex < 0 || dinosaurIndex >= dinosaurs.size()) {
			System.out.println("Invalid choice.");
			return;
		}

		Dinosaur selectedDinosaur = dinosaurs.get(dinosaurIndex);

		System.out.print("Enter activity name: ");
		String activityName = scanner.nextLine();
		LocalDate date = LocalDate.now();

		Activity newActivity = new Activity(activityName, date, selectedDinosaur);
		activities.add(newActivity);

		System.out.println("Activity logged: " + newActivity);
	}

	public void displayActivities() {
		if (activities.isEmpty()) {
			System.out.println("No activities logged yet.");
			return;
		}

		System.out.println("Activity log:");
		for (Activity activity : activities) {
			System.out.println(activity);
		}
	}
}
