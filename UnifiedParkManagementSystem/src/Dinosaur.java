public abstract class Dinosaur {
	private String name;
	private String status;
	private String location;
	private String diet;
	private int age;

	public Dinosaur(String name, String status, String location, String diet, int age) {
		this.name = name;
		this.status = status;
		this.location = location;
		this.diet = diet;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDiet() {
		return diet;
	}

	public int getAge() {
		return age;
	}
}
