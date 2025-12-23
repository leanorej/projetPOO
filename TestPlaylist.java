package projetpoo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.*;


public class TestPlaylist {
    public static void main (String [] args)throws IOException{

        // création playlist avec tout les fichiers mp3 du dossier projetPOO, puis affichage du contenu

        Playlist play = new Playlist("musique cool","/Users/nur/Desktop/projetPOO");

        System.out.println(play);        

        /////////////////////////////////////////////////////////////////

        // ajout d'un nouveau son, il n'apparaitra pas dans le dossier reel, puis affichage    

        play.ajouterSon("/Users/nur/Desktop/projetPOO/01WhatADay.mp3");

        System.out.println(play.toString());

        /////////////////////////////////////////////////////////////////
        
        File dossier = new File ("testSon2");
        dossier.mkdir();

        File playX = new File ("testSon2","play.xspf");
            playX.createNewFile();

        play.exportXSPF("testSon2/play.xspf");

        File playJ = new File ("testSon2","play.jspf");
            playJ.createNewFile();

        play.exportJSPF("testSon2/play.jspf");



        /////////////////////////////////////////////////////////////////


        File playM = new File ("testSon2","play.m3u8");
            playM.createNewFile();

        play.exportM3U8("testSon2/play.m3u8");


        
        // suppression de la playlist puis affichage pour verifier

        play.supprimerPlaylist();
        System.out.println(play.toString());

        /////////////////////////////////////////////////////////////////

    }
}