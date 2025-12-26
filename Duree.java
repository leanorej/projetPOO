package projetpoo;

/**
 * Classe durée qui permet d'avoir la durée d'un son en heures, minutes et secondes
 */
public class Duree {
	
	protected int min;
	protected int sec;
	protected int h;
	
	/**
	 * Constructeur d'une durée
	 * @param s secondes
	 * @param m minutes
	 * @param h heures
	 */
	public Duree(int s, int m, int h){
		this.sec = s;
		this.min = m;
		this.h = h;
	}
	
	/**
	 * Définit le nombre de secondes
	 * @param s le nombre de secondes
	 */
	public void setS(int s){
		this.sec = s;
	}

	/**
	 * Définit le nombre de minutes
	 * @param m le nombre de minutes
	 */
	public void setM(int m){
		this.min = m;
	}
	
	/**
	 * Définit le nombre d'heures
	 * @param h le nombre d'heures
	 */
	public void setH(int h){
		this.h = h;
	}
	
	/**
	 * @return le nombre de secondes
	 */
	public int getS(){
		return this.sec;
	}
	
	/**
	 * @return le nombre de minutes
	 */
	public int getM(){
		return this.min;
	}
	
	/**
	 * @return le nombre d'heures
	 */
	public int getH(){
		return this.h;
	}
	
	/**
	 * Méthode toString
	 * @return une chaîne représentant la durée au format hh : mm : ss
	 */
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
