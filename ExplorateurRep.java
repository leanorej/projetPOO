package projetpoo;
import java.io.*;
import java.nio.file.*;
import java.util.*;


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
                        try {
                            Path path = f.toPath();
                            String typeMime = Files.probeContentType(path);
    
                            if (f.getName().toLowerCase().endsWith(".mp3") && "audio/mpeg".equals(typeMime)){
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
    
    public ArrayList <String> cheminMP3(String chemin){
        ArrayList<FichierMP3> liste = this.listeMP3;

        ArrayList<String> chemins= new ArrayList<>();
        for (FichierMP3 f : liste)
            chemins.add(f.getC());
    
        return chemins;
    }

}
