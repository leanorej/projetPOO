package projetpoo;

/**
*Classe FluxAudio qui permet d'identifier le flux audio d'un fichier MP3
*/
public class FluxAudio{
	
	protected String donnees;
	
	/**
	* Constructeur de Flux Audio
	* @parametres la donnée en chaîne de caractères
	*/
	public FluxAudio(String d){
		this.donnees = d;
	}
	
	/**
	* Getter et Setter de Flux Audio
	*/
	public String getFA(){
		return this.donnees;
	}
	
	public void setFA(String d){
		this.donnees = d;
	}

}