import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DinosaurCareSystem {
	private List<Dinosaur> dinosaurs;
	private List<Consumer<String>> notificationSubscribers;
	private Scanner scanner;

	public DinosaurCareSystem() {
		dinosaurs = new ArrayList<>();
		notificationSubscribers = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void addDinosaur() {
		String name = promptString("Enter dinosaur name: ");
		String species = promptString("Enter dinosaur species: ");
		String healthStatus = promptString("Enter dinosaur health status: ");
		int size = promptInt("Enter dinosaur size: ");
		int age = promptInt("Enter dinosaur age: ");
		int health = promptInt("Enter dinosaur health (0-100): ");

		Dinosaur newDinosaur = new Dinosaur(name, species, healthStatus, size, age, health);
		dinosaurs.add(newDinosaur);
		System.out.println("Dinosaur added: " + newDinosaur);
	}

	// Lambda: Sorting dinosaurs by different attributes
	public void sortDinosaursBy(String attribute) {
		Comparator<Dinosaur> comparator = switch (attribute) {
			case "age" -> Comparator.comparing(Dinosaur::getAge);
			case "size" -> Comparator.comparing(Dinosaur::getSize);
			case "health" -> Comparator.comparing(Dinosaur::getHealth);
			default -> Comparator.comparing(Dinosaur::getName);
		};

		dinosaurs.sort(comparator);
		System.out.println("Dinosaurs sorted by " + attribute + ":");
		dinosaurs.forEach(System.out::println);
	}

	// Lambda: Filtering by species or critical health status
	public void filterDinosaurs(String filterType) {
		List<Dinosaur> filteredDinosaurs = switch (filterType) {
			case "species" -> {
				String species = promptString("Enter species to filter by: ");
				yield dinosaurs.stream().filter(d -> d.getSpecies().equalsIgnoreCase(species)).collect(Collectors.toList());
			}
			case "critical" -> dinosaurs.stream().filter(d -> d.getHealth() < 20).collect(Collectors.toList());
			default -> dinosaurs;
		};

		System.out.println("Filtered dinosaurs:");
		filteredDinosaurs.forEach(System.out::println);
	}

	// Method reference: Notification system
	public void checkAndNotifyIllDinosaurs() {
		dinosaurs.stream()
				.filter(Dinosaur::isIll)
				.forEach(d -> sendNotification(d.getName() + " is ill."));
	}

	// Advanced notification system with subscribers
	public void sendNotification(String message) {
		System.out.println("Notification: " + message);
		notificationSubscribers.forEach(subscriber -> subscriber.accept(message));
	}

	public void subscribeToNotifications(Consumer<String> subscriber) {
		notificationSubscribers.add(subscriber);
	}

	// Lambda: Perform health decay or increase over time
	public void updateDinosaurHealth() {
		dinosaurs.forEach(d -> d.decreaseHealth(5));
		System.out.println("Health decayed for dinosaurs. Current health status:");
		dinosaurs.forEach(System.out::println);
	}

	// Utility methods for prompting user input
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
