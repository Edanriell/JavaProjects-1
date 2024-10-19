public class Main {
	public static void main(String[] args) {
		String dinosaurName = "Stegosaurus";
		int dinosaurAge = 6;
		char dinosaurSpecies = 'M';
		String dinosaurDiet = "herbivore";
		int dinosaurWeight = 50;

		String out = "Meet " + dinosaurName + ", a " + dinosaurAge + " year-old " + dinosaurSpecies + ". As a " + dinosaurDiet + ", it has a robust weight of " + dinosaurWeight + " kilograms.";
		System.out.println(out);
	}
}