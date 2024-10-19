class VIPGuest {
	private String name;
	private String event;

	public VIPGuest(String name, String event) {
		this.name = name;
		this.event = event;
	}

	public String getName() { return name; }
	public String getEvent() { return event; }

	public void displayVIPInfo() {
		System.out.println("VIP Guest: " + name + " attending " + event);
	}
}