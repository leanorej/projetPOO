package projetpoo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.*;

/**
 * classe permettant la gestion d'une playlist.
 */

public class Playlist{
	//attributs
	protected String nom;
	protected ArrayList<FichierMP3> musiques;
	protected int indiceCourant ;

	/**
	 * Constructeur qui crée une playlist vide avec un nom donné en paramètre.
	 */

	public Playlist(String n){
		this.nom = n;
		this.musiques = new ArrayList<>();
		this.indiceCourant = 0;
	}


	/**
	 * Constructeur qui crée une playlist composé de tout les fichiers mp3 contenu dans le chemin donné en paramètre et ayant un nom donné en paramètre.
	 */

	
	/*
	 * Constructeur de la classe playlist.
	 * cree un explorateur pour recuperer tout les fichiers MP3 contenue dans le chemin donné en paramètre pour ensuite recuperer cette liste et l'affecter à notre liste de musiques.
	 */

	public Playlist(String n, String chemin){
		this.nom=n;

		ExplorateurRep e = new ExplorateurRep();
		e.repertoire(chemin);
		this.musiques=e.getListeMP3();
		
		this.indiceCourant = 0;
	}

	/**
	 * Méthode permettant de supprimer une playlist en la vidant et en supprimant son nom.
	 */


	public void supprimerPlaylist(){
		this.nom = "" ;
		this.musiques.clear();
		this.indiceCourant=0;
	}

	/**
	 * Méthode permettant d'ajouter un son dans la playlist à partir de son chemin.
	 * @param cheminSon chemin du fichierMP3 à ajouter.
	 */

	// Methode qui transforme le chemin vers le son que l'on souhaite ajouter en fichierMP3 afin de pouvoir l'ajouter à notre attribut qui contient la liste de musiques.

	
	public void ajouterSon(String cheminSon) {
		FichierMP3 nvxSon = new FichierMP3(cheminSon);

		boolean trouve = false ;
		for (FichierMP3 son : musiques){
			if (son.getM().equals(nvxSon.getM()) || son.getNom().equals(nvxSon.getNom()))
				trouve = true ;
		}
		if (!trouve)
			musiques.add(nvxSon);
		else 
			System.out.println( nvxSon.getNom()+" existe déjà dans la playlist.");
		}

	
	/**
	 * Méthode permettant de supprimer un son de la playlist.
	 * @param f le fichierMP3 à supprimer.
	 */

	/*
	 * Méthode permettant de supprimer un son de la playlist.
	 * On vérifie d'abord que le fichier existe bien dans la playlist.
	 * si il existe on le retire, sinon on ne fait rien.
	*/

	public void supprimerSon(FichierMP3 f){
		int indiceSup = 0 ;
		boolean trouve = false ;
		while ( !trouve && indiceSup < musiques.size()){
			if (f.equals(musiques.get(indiceSup)))
				trouve = true ;
			else 
				indiceSup++ ;
		}
		if (trouve)
			musiques.remove(indiceSup);
	}


	/**
	 * Méthode permettant de passer au son suivant grâce à l'indice courant.
	 * @return FichierMP3 le fichier audio suivant.
	 */

	public FichierMP3 sonSuivant() {
		if (!musiques.isEmpty()){
			if(indiceCourant >= musiques.size() -1 ){
				System.out.println("Aucun son suivant, fin de la playlist.");
				return musiques.get(indiceCourant);
			}

			this.indiceCourant++ ;
			return musiques.get(indiceCourant);
		}
		System.out.println("Playlist vide");
		return null ;
	}
	
    

	/**
	 * Méthode permettant d'acceder au son courant.
	 * @return FichierMP3 le fichier audio courant.
	 */

	public FichierMP3 sonCourant() {
		if(!musiques.isEmpty())
				return musiques.get(indiceCourant);
		System.out.println("Playlist vide") ;
		return null ;
	}

	/**
	 * Méthode permettant de passer au son précedant grâce à l'indice courant.
	 * @return FichierMP3 le fichier audio précedant.
	 */

	public FichierMP3 sonPrecedent(){
		if (!musiques.isEmpty()){
			if(!(indiceCourant <= 0 )){
				this.indiceCourant-- ;
				return musiques.get(indiceCourant);
			}
			System.out.println("Aucun son précédent, début de la playlist.");
			return musiques.get(indiceCourant);
		}
		System.out.println("Playlist vide");
		return null ;
	}


	/*
	 * on crée un FileWriter pour pouvoir ecrire dans le fichier donné en paramètre.
	 * si le fichier existe, on écrase son contenu avec ce qu'on souhaite écrire.
	 * si le fichier n'existe pas, il en crée un.
	*/



	/**
	 * Méthode permettant d'exporter la playlist en format M3U8 vers un fichier choisi.
	 * @param cheminFichier le chemin du fichier dans lequel on souhaite exporter la playlist.
	 */
	
	public void exportM3U8(String cheminFichier){
		try(BufferedWriter buff = new BufferedWriter(new FileWriter(cheminFichier))){
			for (FichierMP3 son : this.musiques){
				buff.write(son.getC()+"\n");
			}
		} catch (IOException e){
			System.out.println("Erreur de fichier : " + e.getMessage());
		}
	}

	/**
	 * Méthode permettant d'exporter la playlist en format JSPF vers un fichier choisi.
	 * @param cheminFichier le chemin du fichier dans lequel on souhaite exporter la playlist.
	 */
	

	public void exportJSPF(String cheminFichier){
		try (BufferedWriter buff = new BufferedWriter(new FileWriter(cheminFichier))){

			buff.write("{\n\t\"playlist\": {\n\t\t\"track\": [");
			buff.write("{\n\t\"playlist\": {\n\t\t\"track\": [");
			
			Iterator<FichierMP3> ite = musiques.iterator();
			while(ite.hasNext()){
				buff.write("\n\t\t\t{ \"location\":"+ "\""+ite.next().getC()+"\""+" }");
				if (ite.hasNext())
					buff.write(",");
			}
			buff.write("\n\t\t]\n\t}\n}");

		} catch (IOException e){
			System.out.println("Erreur de fichier : " + e.getMessage());
		}
	}


	/**
	 * Méthode permettant d'exporter la playlist en format XSPF vers un fichier choisi.
	 * @param cheminFichier le chemin du fichier dans lequel on souhaite exporter la playlist.
	 */


	public void exportXSPF(String cheminFichier){
		try(BufferedWriter buff = new BufferedWriter(new FileWriter(cheminFichier))){
			buff.write("<playlist version=\"1\" xmlns=\"http://xspf.org/ns/0/\">\n\t<trackList>");

			Iterator<FichierMP3> ite = musiques.iterator();
			while(ite.hasNext()){
				buff.write("\n\t\t<track>\n\t\t\t<location>"+ ite.next().getC()+"</location>\n\t\t</track>");
			}
				buff.write("\n\t</trackList>\n</playlist>");
		} catch (IOException e){
			System.out.println("Erreur de fichier : " + e.getMessage());
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
	


	//On affiche en allant à la ligne, l'artiste et le titre de chaque musiques, selon s'ils sont chacun connus ou non.

	public String toString(){
		if (musiques.isEmpty())
			return "Playlist vide";
		else {
			String listeMusiques ="Playlist : " + getNom() + "\n\n";
			for (FichierMP3 son : musiques){
				if (son.getM().getTitre()==null && son.getM().getArt()==null)
					listeMusiques += "Artiste et titre inconnu" + "\n" ;
				else if (son.getM().getTitre()==null)
					listeMusiques += "titre inconnu " + son.getM().getArt() + "\n" ;
				else if (son.getM().getArt()==null)
					listeMusiques += son.getM().getTitre() + " artiste inconnu(e)" + "\n" ;
				else
					listeMusiques += son.getM().getTitre() + " " + son.getM().getArt() + "\n";
			}
			return listeMusiques ;
		}
	}

}