package projetpoo;

import projetpoo.FichierMP3;
import projetpoo.Metadonnees;
import projetpoo.FluxAudio;
import projetpoo.Duree;

public class TestFichierMP3 {

    public static void main(String[] args) {
        String cheminTest = "/Users/leanore.j/Documents/projetPOO/01WhatADay.mp3";
        Metadonnees m = new Metadonnees("", "", "", new Duree(0, 0, 0), null);
        FluxAudio f = new FluxAudio(" ");
        FichierMP3 mp3 = new FichierMP3(m, f, " ", cheminTest);

        try {
            mp3.extraireMD();
        } catch (Exception e) {
            System.err.println("Erreur lors de la lecture des métadonnées : " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println(mp3);
        System.out.println("Nom du fichier  : " + mp3.getNom());
        System.out.println("Chemin          : " + mp3.getC());
        System.out.println("Type MIME       : " + mp3.getT());
        System.out.println("Métadonnées     : " + mp3.getM());
    }
}