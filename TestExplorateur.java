package projetpoo;

import java.util.ArrayList;
import projetpoo.*;
import java.io.*;


public class TestExplorateur {
    public static void main(String[] args) throws IOException {
        File dossier = new File ("testSon");

        dossier.mkdir();

        File son1 = new File ("testSon","son1.MP3");
        son1.createNewFile();

        File son2 = new File ("testSon","son2.mp3");
        son2.createNewFile();

        File son3 = new File ("testSon","fichier2.txt");
        son3.createNewFile();

        File son4 = new File ("testSon","fichier1.txt");
        son4.createNewFile();

        File son5 = new File ("testSon","son3.mP3");
        son5.createNewFile();


        ExplorateurRep explorateur = new ExplorateurRep();
        explorateur.repertoire(dossier.getAbsolutePath());

        ArrayList<String> cheminExp = explorateur.cheminMP3(dossier.getAbsolutePath());

        ArrayList<FichierMP3> liste = explorateur.getListeMP3();
        
        for(FichierMP3 son : liste){
            System.out.println(son.getNom());
        }

        for(String chem : cheminExp){
            System.out.println(chem);
        }
    }
}