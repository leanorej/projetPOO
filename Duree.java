package projetpoo;

/**
* Classe durée qui permet d'avoir la durée d'un son en heures, minutes et secondes
*/

public class Duree{
	
	protected int min;
	protected int sec;
	protected int h;
	
	/**
	* Constructeur d'une durée
	* Paramètres : les secondes, les minutes et les heures
	*/
	
	public Duree(int s, int m, int h){
		this.sec = s;
		this.min = m;
		this.h = h;
	}
	
	/**
	* Permet de modifier les secondes d'une durée
	* Paramètre : la nouvelle durée en secondes
	*/
	
	public void setS(int s){
		this.sec = s;
	}

	/**
	* Permet de modifier les minutes d'une durée
	* Paramètre : la nouvelle durée en minutes
	*/

	public void setM(int m){
		this.min = m;
	}
	
	public void setH(int h){
		this.h = h;
	}
	
	public int getS(){
		return this.sec;
	}
	
	public int getM(){
		return this.min;
	}
	
	public int getH(){
		return this.h;
	}
	
	public String toString(){
		if (h<10 && min<10 && sec<10)
			return "0"+h+" : "+"0"+min+" : " + "0" +sec ;
		if (h<10 && min<10)
			return "0"+h+" : "+"0"+min+" : " +sec ;
		if (h<10 && sec<10)
			return "0"+h+" : "+min+" : " + "0" +sec ;
		if (min<10 && sec<10)
			return h+" : "+"0"+min+" : " + "0" +sec ;
		if (h<10)
			return "0"+h+" : "+min+" : " + sec ;
		if (min<10)
			return h+" : "+"0"+min+" : " + sec ;
		if (sec<10)
			return h+" : "+min+" : " + "0" +sec ;
		return h +" : "+min+" : "+sec ;
	}

}