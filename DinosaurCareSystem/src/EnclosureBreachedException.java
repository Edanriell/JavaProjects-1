package exception;

public class EnclosureBreachedException extends Exception {
	private String enclosureId;

	public EnclosureBreachedException(String enclosureId, String message) {
		super(message);
		this.enclosureId = enclosureId;
	}

	public String getEnclosureId() {
		return enclosureId;
	}
}
