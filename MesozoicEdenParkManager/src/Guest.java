import java.util.UUID;

class Guest {
	private final UUID id;
	private final String name;
	private final String ticketType;
	private final double price;

	public Guest(String name, String ticketType, double price) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.ticketType = ticketType;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void displayInfo() {
		System.out.println("ID: " + id + ", Name: " + name + ", Ticket Type: " + ticketType + ", Price: $" + price);
	}
}