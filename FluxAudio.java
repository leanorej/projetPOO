package projetpoo;

/**
 * Classe FluxAudio qui permet d'identifier le flux audio d'un fichier MP3
 */
public class FluxAudio {
	
	protected String donnees;
	
	/**
	 * Constructeur de FluxAudio
	 * @param d la donnée en chaîne de caractères représentant le flux audio
	 */
	public FluxAudio(String d){
		this.donnees = d;
	}
	
	/**
	 * @return la donnée en chaîne de caractères représentant le flux audio
	 */
	public String getFA(){
		return this.donnees;
	}
	
	/**
	 * Définit la donnée du flux audio
	 * @param d la nouvelle donnée en chaîne de caractères
	 */
	public void setFA(String d){
		this.donnees = d;
	}

}
