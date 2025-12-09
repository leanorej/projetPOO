package projetpoo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.*;

public class Playlist{
	//attributs
	protected String nom;
	protected ArrayList<FichierMP3> musiques;
	protected ListIterator<FichierMP3> it ;


	public Playlist(String n){
		this.nom = n;
		this.musiques = new ArrayList<>();
		this.it=musiques.listIterator();
	}

	public Playlist(String n, String chemin){
		this.nom=n;
		ExplorateurRep e = new ExplorateurRep();
		e.repertoire(chemin);
		this.musiques=e.getListeMP3();
		this.it=musiques.listIterator();
	}

	
	public void ajouter(FichierMP3 f){
		this.it=musiques.listIterator();
		if (f!=null)
			musiques.add(f);
		else 
			System.out.println("Impossible d'ajouter, problème de fichier.");
    }
	
	public void supprimer(FichierMP3 f){
		this.it=musiques.listIterator();
		if (f!=null)
			musiques.remove(f);
		else 
			System.out.println("Impossible de supprimer, problème de fichier.");
	}

	public void sonSuivant(){
		if (it.hasNext())
			it.next();
		else 
			System.out.println("Pas de son suivant.");
    }

	public void sonPrecedent(){
		if (it.hasPrevious())
			it.previous();
		else 
			System.out.println("Pas de son précedent.");
    }
	
	public void exportM3U8(String cheminFichier){
		try(FileWriter ecrire = new FileWriter(cheminFichier)){
		for (FichierMP3 son : this.musiques){
			ecrire.write(son.getAbsolutePath()+"\n");
			}
		}
	}

	public void exportJSPF(String cheminFichier){
		try(FileWriter ecrire = new FileWriter(cheminFichier)){
		
		ecrire.write("{\n\t\"playlist\": {\n\t\t\"track\": [");
		
		Iterator<FichierMP3> ite = musiques.iterator();


		while(ite.hasNext()){
			ecrire.write("\n\t\t\t{ \"location\":"+ "\""+ite.next().getAbsolutePath()+"\""+" }");
			if (ite.hasNext())
				ecrire.write(",");
		}

		ecrire.write("\n\t\t]\n\t}\n}");
		}
	}

	public void exportXSPF(String cheminFichier){
		try(FileWriter ecrire = new FileWriter(cheminFichier)){
			ecrire.write("<playlist version=\"1\" xmlns=\"http://xspf.org/ns/0/\">\n\t<trackList>");

			Iterator<FichierMP3> ite = musiques.iterator();


			while(ite.hasNext()){
				ecrire.write("\n\t\t<track>\n\t\t\t<location>"+ ite.next().getAbsolutePath()+"</location>\n\t\t</track>");
			}
				ecrire.write("\n\t</trackList>\n</playlist>");
		}
	}
	
	public void setNom(String n){
		this.nom = n;
	}
	
	public void setM(ArrayList<FichierMP3> m){
		this.musiques = m;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public ArrayList<FichierMP3> getMusiques(){
		return this.musiques;
	}
	
	//methode toString
}