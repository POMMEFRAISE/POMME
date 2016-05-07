package entites;

import java.util.ArrayList;

public class JeuxEntite{

	protected ArrayList<JeuEntite> jeux = new ArrayList<JeuEntite>();
	
	public JeuxEntite(){
	}
	
	public void add(JeuEntite jeu){
		jeux.add(jeu);
	}

	public ArrayList<JeuEntite> getJeux (){
		return jeux;
	}
}