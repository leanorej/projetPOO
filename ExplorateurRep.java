package projetpoo;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;


public class ExplorateurRep {

    ArrayList<File> listeMP3;

    public ExplorateurRep() {
        this.listeMP3 = new ArrayList<File> ();
    }

    public ArrayList<File> repertoire(String chemin){
        File dossier = new File (chemin);

        if (!dossier.exists()){
            System.out.println("Le dossier n'existe pas, mauvais chemin.");
            return null;
        }
        else {
            FilenameFilter filtre = new FilenameFilter() {
                public boolean accept(File dossier, String nom){
                    return nom.endsWith(".MP3");
                }
            };
            
            File[] liste = dossier.listFiles(filtre);
            
            if (liste==null)
                return null;

            int i=0;
            while(i<liste.length){
                this.listeMP3.add(liste[i]);
                i++;
            }
            return this.listeMP3;
        }
    }

    public String[] getListeMP3(){
        return this.listeMP3;
    }
    
    public ArrayList <String> cheminMP3(String chemin){
        ExplorateurRep e = new ExplorateurRep(chemin);
        String[] liste = e.getListeMP3();
        int i = 0;
        ArrayList<String> chemins= new ArrayList<>();
        String nomChemin;
        while (i<liste.length){
            nomChemin=liste[i].getAbsolutePath();
            chemins.add(nomChemin);
            i++;
        }
        return chemins;
    }
}
