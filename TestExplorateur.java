package projetpoo;

import java.util.ArrayList;
import projetpoo.*;
import java.io.*;


public class TestExplorateur {
    public static void main(String[] args) throws IOException {
        
        ExplorateurRep explorateur = new ExplorateurRep();

        explorateur.repertoire("/Users/nur/Desktop/projetPOO");

        ArrayList<String> cheminExp = explorateur.cheminMP3();

        ArrayList<FichierMP3> liste = explorateur.getListeMP3();
        
        for(FichierMP3 son : liste){
            System.out.println(son.getNom());
        }

        for(String chem : cheminExp){
            System.out.println(chem);
        }
    }
}