package projetpoo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.*;


public class TestPlaylist {
    public static void main (String [] args)throws IOException{

        // création d'un vrai dossier avec 5 fichiers dont 3 fichiers mp3
        //File dossier = new File ("testSon2");

        //dossier.mkdir();

        //File son1 = new File ("testSon2","son1.MP3");
        //    son1.createNewFile();
        //File son2 = new File ("testSon2","son2.mp3");
        //    son2.createNewFile();
        //File son3 = new File ("testSon2","fichier2.txt");
        //    son3.createNewFile();
        //File son4 = new File ("testSon2","fichier1.txt");
        //    son4.createNewFile();
        //File son5 = new File ("testSon2","son3.mP3");
        //    son5.createNewFile();
        //////////////////////////////////////////////////////////////////
        

        // création playlist avec tout les fichiers mp3 du dossier testSon2, puis affichage du contenu

        Playlist play = new Playlist("musique cool","/Users/nur/Desktop/testPlaylist");

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