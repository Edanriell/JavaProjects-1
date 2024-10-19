import exception.DinosaurIllException;
import exception.EnclosureBreachedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DinosaurCareSystem {
	private List<Dinosaur> dinosaurs;
	private Random random;

	public DinosaurCareSystem() {
		random = new Random();
		dinosaurs = new ArrayList<>();
		initializeDinosaurs();
	}

	// Initialize some dinosaur data
	private void initializeDinosaurs() {
		dinosaurs.add(new Dinosaur("Rex", "Tyrannosaurus", "Enclosure A1"));
		dinosaurs.add(new Dinosaur("Spike", "Stegosaurus", "Enclosure B2"));
		dinosaurs.add(new Dinosaur("Blue", "Velociraptor", "Enclosure C3"));
		dinosaurs.add(new Dinosaur("Bronto", "Brachiosaurus", "Enclosure D4"));
	}

	// Simulates the health check for all dinosaurs
	public void checkDinosaurHealth() throws DinosaurIllException {
		for (Dinosaur dinosaur : dinosaurs) {
			if (random.nextInt(10) < 2) { // 20% chance of illness
				dinosaur.setIll(true);
				throw new DinosaurIllException(dinosaur.getName(), dinosaur.getName() + " has fallen ill.");
			}
		}
		System.out.println("All dinosaurs are healthy.");
	}

	// Simulates the security check for all enclosures
	public void checkEnclosureSecurity() throws EnclosureBreachedException {
		for (Dinosaur dinosaur : dinosaurs) {
			if (random.nextInt(20) < 1) { // 5% chance of enclosure breach
				throw new EnclosureBreachedException(dinosaur.getEnclosureId(), "Security breach at " + dinosaur.getEnclosureId() + "!");
			}
		}
		System.out.println("All enclosures are secure.");
	}

	// Method to display the status of all dinosaurs
	public void displayDinosaurStatus() {
		System.out.println("Current Dinosaur Status:");
		for (Dinosaur dinosaur : dinosaurs) {
			System.out.println(dinosaur + " - Health: " + (dinosaur.isIll() ? "Ill" : "Healthy"));
		}
	}
}
