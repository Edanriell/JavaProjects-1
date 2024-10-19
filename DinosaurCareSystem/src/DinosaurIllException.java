package exception;

public class DinosaurIllException extends Exception {
	private String dinosaurName;

	public DinosaurIllException(String dinosaurName, String message) {
		super(message);
		this.dinosaurName = dinosaurName;
	}

	public String getDinosaurName() {
		return dinosaurName;
	}
}
