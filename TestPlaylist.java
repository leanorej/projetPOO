package projetpoo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.*;


public class TestPlaylist {
    public static void main (String [] args)throws IOException{

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

        Playlist play = new Playlist("musique cool","testSon");

        System.out.println(play);        

        play.ajouter("testSon/son6.mp3");

        System.out.println(play.toString());



        File playX = new File ("testSon","play.xspf");
            playX.createNewFile();

        play.exportXSPF("testSon/play.xspf");

        File playJ = new File ("testSon","play.jspf");
            playJ.createNewFile();

        play.exportJSPF("testSon/play.jspf");

        File playM = new File ("testSon","play.m3u8");
            playM.createNewFile();

        play.exportM3U8("testSon/play.m3u8");



    }
}