package projetpoo;

public class Commandes {
	//attributs
    private String mode;
    private String nomF;
    private String dossier;

    public Commandes(String m, String n, String d) {
        this.mode = m;
        this.nomF = n;
        this.dossier = d;
    }

    public void setM(String m){
    	this.mode = m; 
    }
    public void setN(String n){
    	 this.nomF = n;
   	}
    public void setD(String d){
    	this.dossier = d;
    }

    public String getM(){
    	 return mode;
    }
    	 
    public String getN(){
    	 return nomF;
    }
    	 
    public String getD(){ 
    	return dossier;
    }

    public String toString(){
        return "mode : " + mode + "\nnom du fichier : " + nomF + "\ndossier : " + dossier  ;
    }

}