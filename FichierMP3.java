package projetpoo;

public class FichierMP3{
	//attributs
	protected Métadonnées metad;
	protected FluxAudio flux;
	protected String type;
	protected String chemin;
	
	
	public FichierMP3(Métadonnées m, FluxAudio f, String t, String c){
		this.metad = m;
		this.flux = f;
		this.type = t;
		this.chemin = c;
	}
	
	//public Métadonnées extraireMD(){}
	
	//public void chargerFichier(){}
	
	public Métadonnées getM(){
		return this.metad;
	}
	
	public FluxAudio getF(){
		return this.flux;
	}
	
	public String getT(){
		return this.type;
	}
	
	public String getC(){
		return this.chemin;
	}
	
	public void setM(Métadonnées m){
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
	
	//public String toString(){}
}