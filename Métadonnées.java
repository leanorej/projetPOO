package projetpoo;

public class Métadonnées {
	//attributs
	protected String titre;
	protected String artiste;
	protected String album;
	protected Duree duree;
	protected int annee;
	
	public Métadonnées(String t, String art, String alb, Duree d, int an ){
		this.titre = t;
		this.artiste = art;
		this.album = alb;
		this.duree = d;
		this.annee = an;
	}
	
	//public void afficher(){}
	
	public String getT(){
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
	
	public int getAn(){
		return this.annee;
	}
	
	public void setT(String t){
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
	
	public void setAn(int an){
		this.annee = an;
	}
	
	//public String toString(){}
	
}