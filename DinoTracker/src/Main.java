public class Main {
	public static void main(String[] args) {
		String[] dinoNames = new String[10];
		int[] dinoAges = new int[10];
		String[] dinoSpecies = new String[10];
		int[] dinoEnclosures = new int[10];
		int[] dinoWeights = new int[10];

		dinoNames[0] = "Rex"; dinoAges[0] = 5; dinoSpecies[0] = "T-Rex"; dinoEnclosures[0] = 1; dinoWeights[0] = 7000;
		dinoNames[1] = "Brachy"; dinoAges[1] = 10; dinoSpecies[1] = "Brachiosaurus"; dinoEnclosures[1] = 2; dinoWeights[1] = 15000;
		dinoNames[2] = "Velo"; dinoAges[2] = 3; dinoSpecies[2] = "Velociraptor"; dinoEnclosures[2] = 3; dinoWeights[2] = 500;
		dinoNames[3] = "Trice"; dinoAges[3] = 7; dinoSpecies[3] = "Triceratops"; dinoEnclosures[3] = 4; dinoWeights[3] = 6000;
		dinoNames[4] = "Stego"; dinoAges[4] = 8; dinoSpecies[4] = "Stegosaurus"; dinoEnclosures[4] = 5; dinoWeights[4] = 7000;
		dinoNames[5] = "Anky"; dinoAges[5] = 6; dinoSpecies[5] = "Ankylosaurus"; dinoEnclosures[5] = 6; dinoWeights[5] = 4500;
		dinoNames[6] = "Spino"; dinoAges[6] = 4; dinoSpecies[6] = "Spinosaurus"; dinoEnclosures[6] = 7; dinoWeights[6] = 8000;
		dinoNames[7] = "Ptero"; dinoAges[7] = 2; dinoSpecies[7] = "Pteranodon"; dinoEnclosures[7] = 8; dinoWeights[7] = 250;
		dinoNames[8] = "Iguan"; dinoAges[8] = 9; dinoSpecies[8] = "Iguanodon"; dinoEnclosures[8] = 9; dinoWeights[8] = 4000;
		dinoNames[9] = "Diplod"; dinoAges[9] = 11; dinoSpecies[9] = "Diplodocus"; dinoEnclosures[9] = 10; dinoWeights[9] = 12000;

		System.out.println("Dinosaur Records:");
		System.out.println("=================");
		for (int i = 0; i < 10; i++) {
			System.out.println("Name: " + dinoNames[i] +
					", Age: " + dinoAges[i] + " years" +
					", Species: " + dinoSpecies[i] +
					", Enclosure: " + dinoEnclosures[i] +
					", Weight: " + dinoWeights[i] + " kg");
		}

		int totalAge = 0;
		int totalWeight = 0;
		for (int i = 0; i < 10; i++) {
			totalAge += dinoAges[i];
			totalWeight += dinoWeights[i];
		}

		double averageAge = (double) totalAge / 10;
		double averageWeight = (double) totalWeight / 10;

		System.out.println("\nAverage Age of Dinosaurs: " + averageAge + " years");
		System.out.println("Average Weight of Dinosaurs: " + averageWeight + " kg");
	}
}