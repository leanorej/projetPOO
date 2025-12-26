
package projetpoo;

import javax.swing.ImageIcon;

/**
* Classe qui contient les métadonnées d'un fichier MP3
*/
public class Metadonnees {

	protected String titre;
	protected String artiste;
	protected String album;
	protected Duree duree;
	protected Integer annee;
	protected String type;
	protected ImageIcon image; 

	/**
	* Constructeur qui crée des métadonnées
	* @parametres : le titre, l'artiste, l'album, la durée et l'année de sortie
	*/
	public Metadonnees(String t, String art, String alb, Duree d, Integer an) {
		this.titre = t;
		this.artiste = art;
		this.album = alb;
		this.duree = d;
		this.annee = an;
		this.type = null;
		this.image = null; // pas d'image par défaut
	}

	/**
	* Constructeur qui crée des métadonnées
	* @parametres : le titre, l'artiste, l'album, la durée, l'année de sortie et le type
	*/
	public Metadonnees(String t, String art, String alb, Duree d, Integer an, String type) {
		this.titre = t;
		this.artiste = art;
		this.album = alb;
		this.duree = d;
		this.annee = an;
		this.type = type;
		this.image = null; // pas d'image par défaut
	}

	/**
	* Permet de récupérer le titre dans les métadonnées
	*/
	public String getTitre() {
		return this.titre;
	}

	/**
	* Permet de récupérer l'artiste
	*/
	public String getArt() {
		return this.artiste;
	}

	/**
	* Permet de récupérer l'album
	*/
	public String getAlb() {
		return this.album;
	}

	/**
	* Permet de récupérer la durée
	*/
	public Duree getDuree() {
		return this.duree;
	}

	/**
	* Permet de récupérer l'année de sortie
	*/
	public Integer getAn() {
		return this.annee;
	}

	/**
	* Permet de récupérer le type
	*/
	public String getType() {
		return this.type;
	}

	/**
	* Permet de récupérer l'image de couverture
	*/
	public ImageIcon getImage() {
		return this.image;
	}

	/**
	* Permet de modifier le titre
	*/
	public void setTitre(String t) {
		this.titre = t;
	}

	/**
	* Permet de modifier l'artiste
	*/
	public void setArt(String art) {
		this.artiste = art;
	}

	/**
	* Permet de modifier l'album
	*/
	public void setAlb(String alb) {
		this.album = alb;
	}

	/**
	* Permet de modifier la durée
	*/
	public void setD(Duree d) {
		this.duree = d;
	}

	/**
	* Permet de modifier l'année de sortie à partir d'une chaîne
	*/
	public void setAnneeSortie(String an) {
		try {
			this.annee = Integer.parseInt(an);
		} catch (Exception e) {
			this.annee = null;
		}
	}

	/**
	* Permet de modifier le type du fichier
	*/
	public void setType(String type) {
		this.type = type;
	}

	/**
	* Permet de définir l'image de couverture
	*/
	public void setImage(ImageIcon image) {
		this.image = image;
	}

	/**
	* Méthode toString
	* @return les métadonnées, c'est à dire le titre, l'artiste, l'album, la durée, l'année de sortie et le type
	*/
	public String toString() {
		return "titre : " + titre +
			   "\nartiste : " + artiste +
			   "\nalbum : " + album +
			   "\ndurée : " + duree +
			   "\nannée de sortie : " + annee +
			   "\ntype : " + type + "\n";
	}
}
