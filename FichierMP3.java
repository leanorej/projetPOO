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
     * @param m les métadonnées du fichier MP3
     * @param f le flux audio du fichier MP3
     * @param t le type du fichier (ex: "mp3")
     * @param c le chemin complet du fichier
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
     * @param chemin le chemin complet du fichier
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
     * @throws Exception si le tag ne correspond pas ou si le fichier MP3 est invalide
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

    // Getters et Setters avec documentation

    /**
     * @return les métadonnées du fichier MP3
     */
    public Metadonnees getM(){
        return this.metad; 
    }

    /**
     * @return le flux audio du fichier MP3
     */
    public FluxAudio getF(){
        return this.flux;
    }

    /**
     * @return le nom du fichier MP3
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * @return le type du fichier MP3
     */
    public String getT(){
        return this.type;
    }

    /**
     * @return le chemin complet du fichier MP3
     */
    public String getC(){
        return this.chemin;
    }

    /**
     * Définit les métadonnées du fichier MP3
     * @param m les nouvelles métadonnées
     */
    public void setM(Metadonnees m){
        this.metad = m;
    }

    /**
     * Définit le flux audio du fichier MP3
     * @param f le nouveau flux audio
     */
    public void setF(FluxAudio f){
        this.flux = f;
    }

    /**
     * Définit le type du fichier MP3
     * @param t le type
     */
    public void setT(String t){
        this.type = t;
    }

    /**
     * Définit le chemin du fichier MP3
     * @param c le chemin complet
     */
    public void setC(String c){
        this.chemin = c;
    }

    /**
     * Définit le nom du fichier MP3
     * @param nom le nouveau nom
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Méthode toString
     * @return une chaîne représentant le fichier MP3 et ses métadonnées
     */
    public String toString(){
        return nom + " : \n" + metad + "\ntype : " + type + "\nchemin : " + chemin;
    }
}
