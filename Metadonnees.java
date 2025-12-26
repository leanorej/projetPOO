
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
	 * @param t le titre du morceau
	 * @param art l'artiste
	 * @param alb l'album
	 * @param d la durée
	 * @param an l'année de sortie
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
	 * @param t le titre du morceau
	 * @param art l'artiste
	 * @param alb l'album
	 * @param d la durée
	 * @param an l'année de sortie
	 * @param type le type de fichier (ex: "mp3")
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
	 * @return le titre du morceau
	 */
	public String getTitre() {
		return this.titre;
	}

	/**
	 * @return l'artiste
	 */
	public String getArt() {
		return this.artiste;
	}

	/**
	 * @return l'album
	 */
	public String getAlb() {
		return this.album;
	}

	/**
	 * @return la durée
	 */
	public Duree getDuree() {
		return this.duree;
	}

	/**
	 * @return l'année de sortie
	 */
	public Integer getAn() {
		return this.annee;
	}

	/**
	 * @return le type du fichier
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @return l'image de couverture
	 */
	public ImageIcon getImage() {
		return this.image;
	}

	/**
	 * Modifie le titre
	 * @param t le nouveau titre
	 */
	public void setTitre(String t) {
		this.titre = t;
	}

	/**
	 * Modifie l'artiste
	 * @param art le nouvel artiste
	 */
	public void setArt(String art) {
		this.artiste = art;
	}

	/**
	 * Modifie l'album
	 * @param alb le nouvel album
	 */
	public void setAlb(String alb) {
		this.album = alb;
	}

	/**
	 * Modifie la durée
	 * @param d la nouvelle durée
	 */
	public void setD(Duree d) {
		this.duree = d;
	}

	/**
	 * Modifie l'année de sortie à partir d'une chaîne
	 * @param an l'année de sortie sous forme de chaîne
	 */
	public void setAnneeSortie(String an) {
		try {
			this.annee = Integer.parseInt(an);
		} catch (Exception e) {
			this.annee = null;
		}
	}

	/**
	 * Modifie le type du fichier
	 * @param type le type de fichier
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Définit l'image de couverture
	 * @param image l'image du morceau
	 */
	public void setImage(ImageIcon image) {
		this.image = image;
	}

	/**
	 * Méthode toString
	 * @return les métadonnées : titre, artiste, album, durée, année de sortie et type
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
