package projetpoo;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;


public class ExplorateurRep {

    ArrayList<FichierMP3> listeMP3;

    public ExplorateurRep() {
        this.listeMP3 = new ArrayList<FichierMP3> ();
    }

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
                        if (f.getName().toLowerCase().endsWith(".mp3")){
                            this.listeMP3.add(new FichierMP3(f.getAbsolutePath()));
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
    
    public ArrayList <String> cheminMP3(String chemin){
        ExplorateurRep e = new ExplorateurRep();
        e.repertoire(chemin);

        ArrayList<FichierMP3> liste = e.getListeMP3();

        ArrayList<String> chemins= new ArrayList<>();
        for (FichierMP3 f : liste)
            chemins.add(f.getC());
    
        return chemins;
    }

}
