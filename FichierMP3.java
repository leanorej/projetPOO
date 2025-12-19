package projetpoo;

import java.io.File;
import java.io.IOException;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;




public class FichierMP3{
	//attributs
	protected String nom;
	protected Metadonnees metad;
	protected FluxAudio flux;
	protected String type;
	protected String chemin;
	
	
	public FichierMP3(Metadonnees m, FluxAudio f, String t, String c){
		this.metad = m;
		this.flux = f;
		this.type = t ;
		this.chemin = c;
		File file = new File(c);
        this.nom = file.getName();
	}

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
		Duree d = new Duree(heures, minutes, secondes);
		this.metad.setD(d); 
	}



	public Metadonnees getM(){
		return this.metad;
	}
	
	public FluxAudio getF(){
		return this.flux;
	}
	
	public String getNom(){
		return this.nom;
	}

	public String getT(){
		return this.type;
	}
	
	public String getC(){
		return this.chemin;
	}
	
	public void setM(Metadonnees m){
		this.metad = m;
	}
	
	public void setF(FluxAudio f){
		this.flux = f;
	}
	
	public void setT(String t){
		this.type = t;
	}
	
	public void setC(String c){
		this.chemin = c;
	}
	
	public String toString(){
		return nom + " : \n" + metad + "\ntype : " + type + "\nchemin : " + chemin;
	}
}