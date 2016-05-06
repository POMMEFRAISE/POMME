package entites;

import java.util.ArrayList;

public class PartiesEntite{

	protected ArrayList<PartieEntite> parties = new ArrayList<PartieEntite>();
	
	public PartiesEntite(){

	}
	
	public void add(PartieEntite partie){
		parties.add(partie);
	}

	public ArrayList<PartieEntite> getParties (){
		return parties;
	}
}