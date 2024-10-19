import java.util.*;
import java.time.LocalDate;

public class DinosaurCareSystem {
	private Set<Dinosaur> dinosaurs;
	private List<Activity> activities;
	private Scanner scanner;

	public DinosaurCareSystem() {
		dinosaurs = new HashSet<>(); // Ensuring unique dinosaurs
		activities = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void addDinosaur() {
		String name = promptString("Enter dinosaur name: ");
		String species = promptString("Enter dinosaur species: ");
		String healthStatus = promptString("Enter dinosaur health status: ");
		int size = promptInt("Enter dinosaur size: ");
		int age = promptInt("Enter dinosaur age: ");

		Dinosaur newDinosaur = new Dinosaur(name, species, healthStatus, size, age);
		if (dinosaurs.add(newDinosaur)) {
			System.out.println("Dinosaur added: " + newDinosaur);
		} else {
			System.out.println("This dinosaur already exists.");
		}
	}

	public void logActivity() {
		if (dinosaurs.isEmpty()) {
			System.out.println("No dinosaurs available. Add a dinosaur first.");
			return;
		}

		System.out.println("Select a dinosaur by number:");
		List<Dinosaur> dinoList = new ArrayList<>(dinosaurs);
		for (int i = 0; i < dinoList.size(); i++) {
			System.out.println((i + 1) + ". " + dinoList.get(i));
		}

		int dinosaurIndex = promptInt("Enter dinosaur choice: ") - 1;
		if (dinosaurIndex < 0 || dinosaurIndex >= dinoList.size()) {
			System.out.println("Invalid choice.");
			return;
		}

		Dinosaur selectedDinosaur = dinoList.get(dinosaurIndex);

		String activityName = promptString("Enter activity name: ");
		String activityType = promptString("Enter activity type (Feeding, Medical, etc.): ");
		int duration = promptInt("Enter activity duration (in minutes): ");
		LocalDate date = LocalDate.now();

		Activity newActivity = new Activity(activityName, date, selectedDinosaur, activityType, duration);
		activities.add(newActivity);

		System.out.println("Activity logged: " + newActivity);
	}

	public List<Dinosaur> sortDinosaurs(String sortBy) {
		List<Dinosaur> sortedDinosaurs = new ArrayList<>(dinosaurs);
		Collections.sort(sortedDinosaurs, new DinosaurComparator(sortBy));
		return sortedDinosaurs;
	}

	public void displaySortedDinosaurs() {
		String sortBy = promptString("Sort by (name/size/age/health): ");
		List<Dinosaur> sortedDinosaurs = sortDinosaurs(sortBy);
		System.out.println("Sorted Dinosaurs by " + sortBy + ":");
		for (Dinosaur dino : sortedDinosaurs) {
			System.out.println(dino);
		}
	}

	public void searchDinosaur() {
		String searchName = promptString("Enter dinosaur name to search: ");
		Optional<Dinosaur> found = dinosaurs.stream()
				.filter(d -> d.getName().equalsIgnoreCase(searchName))
				.findFirst();

		if (found.isPresent()) {
			System.out.println("Dinosaur found: " + found.get());
		} else {
			System.out.println("Dinosaur not found.");
		}
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

	// Utility methods to prompt user input
	private String promptString(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

	private int promptInt(String prompt) {
		System.out.print(prompt);
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter a valid number.");
			System.out.print(prompt);
			scanner.next();
		}
		int result = scanner.nextInt();
		scanner.nextLine(); // Consume the newline
		return result;
	}
}
