package projetpoo;
import java.util.ArrayList;
import projetpoo.*;

public class TestExplorateur {
    public static void main(String[] args) {
        ExplorateurRep explorateur = new ExplorateurRep();
        explorateur.repertoire("/Users/nur/Desktop/testSon");

        ArrayList<String> cheminExp = explorateur.cheminMP3("/Users/nur/Desktop/testSon");

        ArrayList<FichierMP3> liste = explorateur.getListeMP3();
        
        for(FichierMP3 son : liste){
            System.out.println(son.getNom());
        }

    }
}