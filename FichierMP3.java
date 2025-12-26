package projetpoo;

import java.io.File;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import javax.swing.ImageIcon;

/**
* Classe permettant la gestion des métadonnées d'un fichier MP3
*/
public class FichierMP3 {

    protected String nom;
    protected Metadonnees metad;
    protected FluxAudio flux;
    protected String type;
    protected String chemin;

    /**
    * Constructeur qui crée un fichier MP3
    * @parametres métadonnees m, le flux audio f, le type t, le chemin c
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
    * Constructeur qui crée un fichier MP3 à partir de son chemin
    * @parametre le chemin 
    */
    public FichierMP3(String chemin){
        this.metad = new Metadonnees("", "", "", null, null, "mp3");
        this.flux = null;
        this.type = "mp3";
        this.chemin = chemin;

        File fichier = new File(chemin);
        this.nom = fichier.getName();

        try{
            this.extraireMD();
        } catch(Exception e){
            System.out.println("Erreur lors de l'extraction des métadonnées : " + e.getMessage());
        }
    }

    /**
    * Méthode qui permet d'extraire les métadonnées d'un fichier MP3
    * @throws une erreur si le tag ne correspond pas
    */
    public void extraireMD() throws Exception {
        Mp3File mp3 = new Mp3File(chemin);

        String titre = "";
        String artiste = "";
        String album = "";
        String annee = "";

        ImageIcon imageIcon = null;

        if (mp3.hasId3v2Tag()) {
            ID3v2 tag = mp3.getId3v2Tag();
            titre = tag.getTitle();
            artiste = tag.getArtist();
            album = tag.getAlbum();
            annee = tag.getYear();

            byte[] imageData = tag.getAlbumImage();
            if (imageData != null) {
                imageIcon = new ImageIcon(imageData);
            }

        } else if (mp3.hasId3v1Tag()) {
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
        if (imageIcon != null) this.metad.setImage(imageIcon);

        int totalSec = (int) mp3.getLengthInSeconds();
        int heures = totalSec / 3600;
        int minutes = (totalSec % 3600) / 60;
        int secondes = totalSec % 60;
        Duree d = new Duree(secondes, minutes, heures);
        this.metad.setD(d);
    }

    // Getters et Setters 

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
    public void setNom(String nom){
    	this.nom = nom;
    }

    /**
    * Méthode toString
    */
    public String toString(){
        return nom + " : \n" + metad + "\ntype : " + type + "\nchemin : " + chemin;
    }
}
