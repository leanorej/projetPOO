package test;

import projetpoo.FichierMP3;
import projetpoo.Metadonnees;
import projetpoo.FluxAudio;
import projetpoo.Duree;

import java.io.IOException;

public class TestFichierMP3 {

    public static void main(String[] args) {
        String cheminTest = "/Users/leanorej/Documents/musique4.mp3";
        Metadonnees m = new Metadonnees("", "", "", new Duree(0,0,0), null);
        FluxAudio f = new FluxAudio("Flux audio non chargé");
        FichierMP3 mp3 = new FichierMP3(m, f, "audio/mpeg", cheminTest);
        try {
            mp3.extraireMD();
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        System.out.println(mp3);
        System.out.println("Nom du fichier : " + mp3.getNom());
        System.out.println("Chemin         : " + mp3.getC());
        System.out.println("Type MIME      : " + mp3.getT());
        System.out.println("Métadonnées    : " + mp3.getM());
    }
}