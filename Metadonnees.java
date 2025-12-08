package projetpoo;

public class Metadonnees {
	//attributs
	protected String titre;
	protected String artiste;
	protected String album;
	protected Duree duree;
	protected Integer annee;
	protected String type;
	

	public Metadonnees(String t, String art, String alb, Duree d, Integer an ){}

	public Metadonnees(String t, String art, String alb, Duree d, Integer an, String type ){

		this.titre = t;
		this.artiste = art;
		this.album = alb;
		this.duree = d;
		this.annee = an;
		this.type = type;
	}
	
	public String getTitre(){
		return this.titre;
	}
	
	public String getArt(){
		return this.artiste;
	}
	
	public String getAlb(){
		return this.album;
	}
	
	public Duree getD(){
		return this.duree;
	}
	
	public Integer getAn(){
		return this.annee;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setTitre(String t){
		this.titre = t;
	}
	
	public void setArt(String art){
		this.artiste = art;
	}
	
	public void sertAlb(String alb){
		this.album = alb;
	}
	
	public void setD(Duree d){
		this.duree = d;
	}
	
	public void setAn(Integer an){
		this.annee = an;
	}
		
	public String toString () {
		return "titre : " + titre + "\nartiste : " + artiste + "\nalbum : " +this.album + "\ndurée : "+ duree + "\nannée de sortie : " + annee + "\ntype : " + type + "\n";
	}
	
	public void setType(String type){
		this.type = type;
	}

	
}

