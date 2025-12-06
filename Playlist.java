package projetpoo;
import java.util.ArrayList;
import java.io.*;

public class Playlist{
	//attributs
	protected String nom;
	protected ArrayList<FichierMP3> musiques;
	
	public Playlist(String n){
		this.nom = n;
		this.musiques = new ArrayList<>();
	}
	
	public void ajouter(FichierMP3 f){
		musiques.add(f);
	}
	
	public void supprimer(FichierMP3 f){
		musiques.remove(f);
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