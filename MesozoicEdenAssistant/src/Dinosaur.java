public class Dinosaur {
	int id;
	String name;
	String species;
	double weight;
	double height;
	String diet;

	Dinosaur(int id, String name, String species, double weight, double height, String diet) {
		this.id = id;
		this.name = name;
		this.species = species;
		this.weight = weight;
		this.height = height;
		this.diet = diet;
	}

	@Override
	public String toString() {
		return "Dinosaur{" +
				"id=" + id +
				", name='" + name + '\'' +
				", species='" + species + '\'' +
				", weight=" + weight +
				", height=" + height +
				", diet='" + diet + '\'' +
				'}';
	}
}
