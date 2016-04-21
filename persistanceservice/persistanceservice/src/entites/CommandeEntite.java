package entites;

public class CommandeEntite {
	protected int id;
	protected String message;
	
	public CommandeEntite(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public CommandeEntite() {
		this.id = 0;
		this.message = "";
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
}
