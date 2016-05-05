package entites;

public class CommandeEntite {
	protected int id;
	protected String message;
	protected int numeroPresentation;
	
	public CommandeEntite(int id, String message, int numeroPresentation) {
		this.id = id;
		this.message = message;
		this.numeroPresentation = numeroPresentation;
	}

	public CommandeEntite() {
		this.id = 0;
		this.message = "";
		this.numeroPresentation = 0;
	}
	
	public CommandeEntite(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}