package projetpoo;

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
	
	/**
	* Constructeur qui crée des métadonnées
	* Paramètres : le titre, l'artiste, l'album, la durée et l'année de sortie
	*/
	
	public Metadonnees(String t, String art, String alb, Duree d, Integer an ){
		this.titre = t;
		this.artiste = art;
		this.album = alb;
		this.duree = d;
		this.annee = an;
	}
	/**
	* Constructeur qui crée des métadonnées
	* Paramètres : le titre, l'artiste, l'album, la durée, l'année de sortie et le type
	*/

	public Metadonnees(String t, String art, String alb, Duree d, Integer an, String type ){

		this.titre = t;
		this.artiste = art;
		this.album = alb;
		this.duree = d;
		this.annee = an;
		this.type = type;
	}

	/**
	* Permet de récupérer le titre dans les métadonnées d'un fichierMP3
	* Renvoie le titre des métadonnées d'un fichierMP3
	*/
		
	public String getTitre(){
		return this.titre;
	}
	
	/**
	* Permet de récupérer l'artiste dans les métadonnées d'un fichierMP3
	* Renvoie l'artiste des métadonnées d'un fichierMP3
	*/

	public String getArt(){
		return this.artiste;
	}
	
	/**
	* Permet de récupérer l'album dans les métadonnées d'un fichierMP3
	* Renvoie le titre des métadonnées d'un fichierMP3
	*/
	
	public String getAlb(){
		return this.album;
	}
	
	/**
	* Permet de récupérer la durée dans les métadonnées d'un fichierMP3
	* Renvoie la durée des métadonnées d'un fichierMP3
	*/
	
	public Duree getDuree(){
		return this.duree;
	}

	/**
	* Permet de récupérer l'année de sortie dans les métadonnées d'un fichierMP3
	* Renvoie le titre des métadonnées d'un fichierMP3
	*/
	
	public Integer getAn(){
		return this.annee;
	}
	
	/**
	* Permet de récupérer le type dans les métadonnées d'un fichierMP3
	* Renvoie le titre des métadonnées d'un fichierMP3
	*/
	
	public String getType(){
		return this.type;
	}

	/**
	* Permet de modifier le titre dans les métadonnées d'un fichierMP3
	* Paramètre : le nouveau titre
	*/
		
	public void setTitre(String t){
		this.titre = t;
	}
	
	/**
	* Permet de modifier l'artiste' dans les métadonnées d'un fichierMP3
	* Paramètre : le nouvel artiste
	*/
	
	public void setArt(String art){
		this.artiste = art;
	}
	
	/**
	* Permet de modifier l'album dans les métadonnées d'un fichierMP3
	* Paramètre : le nouvel album
	*/
	
	public void setAlb(String alb){
		this.album = alb;
	}
	
	/**
	* Permet de modifier la durée dans les métadonnées d'un fichierMP3
	* Paramètre : la nouvelle durée
	*/
	
	public void setD(Duree d){
		this.duree = d;
	}
	
	/**
	* Permet de modifier l'année dans les métadonnées d'un fichierMP3
	* Paramètre : la nouvelle année
	*/
	
	public void setAn(Integer an){
		this.annee = an;
	}
	
	/**
	* Permet de modifier l'année de sortie dans les métadonnées d'un fichierMP3 de type Integer
	* Paramètre : la nouvelle année de sortie
	* Vérifie le type sinon année = null
	*/
	
	public void setAnneeSortie(String an) {
        try { this.annee = Integer.parseInt(an); }
        catch(Exception e) { this.annee = null; }
    }
	
	/**
	* Méthode to string
	* Renvoie les m"tadonnées, c'est à dire le titre, l'artiste, l'album, la durée, l'année de sortie et le type
	*/
		
	public String toString () {
		return "titre : " + titre + "\nartiste : " + artiste + "\nalbum : " +this.album + "\ndurée : "+ duree + "\nannée de sortie : " + annee + "\ntype : " + type + "\n";
	}
	
	/**
	* Permet de modifier le type dans les métadonnées d'un fichierMP3
	* Paramètre : le nouveau type
	*/
	
	public void setType(String type){
		this.type = type;
	}

	
}

