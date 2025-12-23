package projetpoo;

import java.io.File;
import java.io.IOException;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

/**
* Classe permettant a gestion des métadonnées d'un fichier MP3
*/

public class FichierMP3{
	
	protected String nom;
	protected Metadonnees metad;
	protected FluxAudio flux;
	protected String type;
	protected String chemin;
	
	/**
	*Constructeur qui crée un fichier MP3
	*paramètres : les métadonnées,le fluxaudio,le ype et le chemin
	*/
	
	public FichierMP3(Metadonnees m, FluxAudio f, String t, String c){
		this.metad = m;
		this.flux = f;
		this.type = t ;
		this.chemin = c;
		File file = new File(c);
        this.nom = file.getName();
	}
	/**
	*Constructeur qui crée un fichier MP3 à partir de son chemin pour trouver toutes ses informations
	*paramètres : le chemin relatif
	*/

	public FichierMP3(String chemin){
		this.metad = new Metadonnees("", "", "", null, null, "mp3" );
		this.flux = null;
		this.type = "mp3";
		this.chemin = chemin;

		File fichier = new File(chemin);
        this.nom = fichier.getName();

		try{
			this.extraireMD();
		} catch(Exception e){
			System.out.println("Erreur");
		}
	}		
	
	/**
	* Méthode qui permet d'extraire les métadonnées d'un fichier MP3
	* Renvoie une erreur si le format n'est pas le bon
	* Récupère les métadonnées selon le format If3v1 ou Id3v2, on favorise Id3v1
	* On converti la durée récupérée en heures, minutes et secondes
	*/
	public void extraireMD() throws Exception {

    	Mp3File mp3 = new Mp3File(chemin);

    	String titre = null;
    	String artiste = null;
    	String album = null;
    	String annee = null;
    	
		if (mp3.hasId3v2Tag()) {
        	ID3v2 tag = mp3.getId3v2Tag();
        	titre = tag.getTitle();
        	artiste = tag.getArtist();
        	album = tag.getAlbum();
        	annee = tag.getYear();
    	}
   
    	else if (mp3.hasId3v1Tag()) {
        	ID3v1 tag = mp3.getId3v1Tag();
        	titre = tag.getTitle();
        	artiste = tag.getArtist();
        	album = tag.getAlbum();
        	annee = tag.getYear();
    	}

    	this.metad.setTitre(titre);
		this.metad.setArt(artiste);
		this.metad.setAlb(album); 
		this.metad.setAnneeSortie(annee);
		this.metad.setType("mp3");

		int totalSec = (int) mp3.getLengthInSeconds();
		int heures = totalSec / 3600;
		int minutes = (totalSec % 3600) / 60;
		int secondes = totalSec % 60;
		Duree d = new Duree(secondes, minutes, heures);
		this.metad.setD(d); 
	}

	/**
	* Permet de récupérer les métadonnées d'un fichierMP3
	* Renvoie les métadonnées du fichier MP3
	*/
	
	public Metadonnees getM(){
		return this.metad;
	}
	
	/**
	* Permet de récupérer le flux audio d'un fichierMP3
	* Renvoie le flux audio du fichier MP3
	*/
	
	public FluxAudio getF(){
		return this.flux;
	}

	/**
	* Permet de récupérer le nom d'un fichierMP3
	* Renvoie le nom du fichier MP3
	*/
		
	public String getNom(){
		return this.nom;
	}

	/**
	* Permet de récupérer le type d'un fichierMP3
	* Renvoie le type du fichier MP3
	*/
	
	public String getT(){
		return this.type;
	}
	
	/**
	* Permet de récupérer le chemin d'un fichierMP3
	* Renvoie le chemin du fichier MP3
	*/
		
	public String getC(){
		return this.chemin;
	}
	
	/**
	* Permet de modifier les métadonnées d'un fichierMP3
	* Paramètre : les nouvelles métadonnées
	*/
	
	public void setM(Metadonnees m){
		this.metad = m;
	}
	
	/**
	* Permet de modifier le flux audio d'un fichierMP3
	* Paramètre : le nouveau flux audio
	*/
	
	public void setF(FluxAudio f){
		this.flux = f;
	}
	
	/**
	* Permet de modifier le type d'un fichierMP3
	* Paramètre : le nouveau type
	*/
	
	public void setT(String t){
		this.type = t;
	}
	
	/**
	* Permet de modifier le chemin d'un fichierMP3
	* Paramètre : le nouveau fichier
	*/
	
	public void setC(String c){
		this.chemin = c;
	}
	
	/**
	* Méthode to string
	* Renvoie le nom, les métadonnées, le type et le chemin du fochier MP3
	*/
	
	public String toString(){
		return nom + " : \n" + metad + "\ntype : " + type + "\nchemin : " + chemin;
	}
}