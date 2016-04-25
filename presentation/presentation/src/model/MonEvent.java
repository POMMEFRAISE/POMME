package model;

public class MonEvent {
	private JoueurPresentation joueurPresentation;
	private Redirection redirection;
	
	public JoueurPresentation getJoueurPresentation() {
		return joueurPresentation;
	}

	public void setJoueurPresentation(JoueurPresentation joueurPresentation) {
		this.joueurPresentation = joueurPresentation;
	}

	public Redirection getRedirection() {
		return redirection;
	}

	public void setRedirection(Redirection redirection) {
		this.redirection = redirection;
	}
}