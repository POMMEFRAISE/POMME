package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class PartiesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<PartieDTO> parties = new ArrayList<PartieDTO>();
	
	public PartiesDTO(){
	}
	
	public void add(PartieDTO partie){
		parties.add(partie);
	}

	public ArrayList<PartieDTO> getParties (){
		return parties;
	}
}