package projetpoo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.*;

public class Playlist{
	//attributs
	protected String nom;
	protected ArrayList<FichierMP3> musiques;
	
	ListIterator<FichierMP3> it = musiques.listIterator() ;

	public Playlist(String n){
		this.nom = n;
		this.musiques = new ArrayList<>();
	}

	
	public void ajouter(FichierMP3 f){
		if (f!=NULL)
			musiques.add(f);
		else 
			System.out.println("Impossible d'ajouter, problème de fichier.");
    }
	
	public void supprimer(FichierMP3 f){
		if (f!=NULL)
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
	
	//public String toString(){}
}