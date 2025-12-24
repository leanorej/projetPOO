package projetpoo;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * classe permettant de gérer et filtrer les fichiers MP3 d'un dossier.
 */

public class ExplorateurRep {

    /**
     * Attribut de la classe qui contient une liste de fichiers mp3.
     */

    ArrayList <FichierMP3> listeMP3;

    /**
     * Constructeur
     * Crée une liste vide prête à être remplie de fichiers mp3.
     */

    public ExplorateurRep() {
        this.listeMP3 = new ArrayList<FichierMP3> ();
    }


    /** 
     * méthode permettant de recuperer tout les fichiers mp3 contenu dans un chemin donné, donc dans le dossier et les sous dossiers, de manière recursive, en verifiant bien le type mime et le nom du fichier. 
     * @param chemin le chemin que l'on souhaite explorer. 
     * @return la liste de tout les fichiers MP3 dans le chemin donné. 
     */

    public ArrayList<FichierMP3> repertoire (String chemin){

        File dossier = new File (chemin);

        if (!dossier.exists()){
            System.out.println("Le dossier n'existe pas, mauvais chemin.");
            return this.listeMP3;
        }
        else {
            File[] liste = dossier.listFiles();
            
            if (liste !=null){

                for (File f : liste){

                    if (f.isDirectory())
                        repertoire(f.getAbsolutePath());

                    if(f.isFile()){
                        try {
                            Path path = f.toPath();
                            String type = Files.probeContentType(path);
    
                            if (f.getName().toLowerCase().endsWith(".mp3") && "audio/mpeg".equals(type)){
                                this.listeMP3.add(new FichierMP3(f.getAbsolutePath()));
                                }
                            }
                        catch(IOException e){
                            System.out.println("Erreur : " + e.getMessage());
                        }
                    }
                }
            }
            
            return this.listeMP3;
        }
    }

    public ArrayList<FichierMP3> getListeMP3(){
        return this.listeMP3;
    }
    

    /**
     * méthode permettant de renvoyer une liste contenant les chemins de tout les fichiers mp3 contenue dans notre attribut.
     * @return chemins la liste des chemins.
     */

    public ArrayList <String> cheminMP3(){

        ArrayList<String> chemins= new ArrayList<>();
        for (FichierMP3 f : this.listeMP3)
            chemins.add(f.getC());
    
        return chemins;
    }

}
