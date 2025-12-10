package projetpoo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class FichierMP3{
	//attributs
	protected String nom;
	protected Metadonnees metad;
	protected FluxAudio flux;
	protected String type;
	protected String chemin;
	
	
	public FichierMP3(Metadonnees m, FluxAudio f, String t, String c){
		this.metad = m;
		this.flux = f;
		this.type = t;
		this.chemin = c;
		File file = new File(c);
        this.nom = file.getName();
	}
	
	public void extraireMD() throws IOException {
		File f = new File(chemin);
		if(!f.exists()){
			return;
		}
		try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
			raf.seek(raf.length() - 128);
			byte[] buffer = new byte[128];
            raf.read(buffer);
            
            String tag = new String(buffer, 0, 3);
            if (!tag.equals("TAG")) {
                System.out.println("Aucun tag ID3v1 trouvé.");
                return;
            }
            
            String titre   = new String(buffer, 3, 30).trim();
            String artiste = new String(buffer, 33, 30).trim();
            String album   = new String(buffer, 63, 30).trim();
            String anneeS = new String(buffer, 93, 4).trim();

            Integer annee = null;
            try { annee = Integer.parseInt(anneeS); } catch (Exception e) {}

            Duree d = new Duree(0, 0, 0);

            this.metad = new Metadonnees(titre, artiste, album, d, annee);
        }
		
	}
	
	//public void chargerFichier(){}
	
	public Metadonnees getM(){
		return this.metad;
	}
	
	public FluxAudio getF(){
		return this.flux;
	}
	
	public String getNom(){
		return this.nom;
	}

	public String getT(){
		return this.type;
	}
	
	public String getC(){
		return this.chemin;
	}
	
	public void setM(Metadonnees m){
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
	
	public String toString(){
		return nom + " : \n" + metad + "\ntype : " + type + "\nchemin : " + chemin;
	}
}