package projetpoo;
import java.util.*;
import java.nio.file.*;
import java.io.*;


import projetpoo.FichierMP3;
import projetpoo.Playlist;

import java.io.*;

public class CLI {
    public static void main (String [] args) throws IOException{

        try{
            if (args.length==0){
                System.out.println("Aucun argument, veuillez saisir -h afin de connaître les differentes options.");
            }

            else if(args[0].equals("-h")){
                System.out.println("Voici les différentes options disponibles : \n");
                System.out.println("-d cheminDossier : permet d'afficher sur le terminal les métadonnées de tout les fichiers MP3 contenus dans le dossier.");
                System.out.println("-f cheminFichier : permet d'afficher sur le terminal les métadonnées du fichier s'il est de type MP3. ");
                System.out.println("--format -o cheminFichier2 : permet d'exporter la playlist des fichiers MP3 récupérés à avec les options \nprécédentes dans un fichier2 avec le format souhaité, xspf, jspf ou m3u8. \n");
            }

            else if (args[0].equals("-d") && args.length==2){
                Playlist play = new Playlist("playlist", args[1]);
                if (!play.getMusiques().isEmpty()){
                    for(FichierMP3 son : play.getMusiques()){
                        if (son.getM()==null)
                            System.out.println(son.getNom() + "\nPas de métadonnées.");
                        else
                            System.out.println(son.getNom()+ "\n" + son.getM());
                    }
                }
                else
                    System.out.println("Aucun fichier mp3 dans ce dossier.");
            }

            else if(args[0].equals("-f") && args.length==2){
                File f = new File(args[1]);
                Path path = f.toPath();
                String type = Files.probeContentType(path);
                if (f.getName().toLowerCase().endsWith(".mp3") && "audio/mpeg".equals(type)){      
                    FichierMP3 F = new FichierMP3(args[1]);
                    System.out.println(F.getNom() + "\n" + F.getM());  
                }
                else
                    System.out.println("Ce n'est pas un fichier MP3.");
            }

            else if (args[0].equals("-d") && args[3].equals("-o") && args.length==5){
                Playlist play = new Playlist("playlist", args[1]);
                if (!play.getMusiques().isEmpty()){

                    for(FichierMP3 son : play.getMusiques()){
                        if (son.getM()==null)
                            System.out.println(son.getNom() + "\nPas de métadonnées.");
                        else
                            System.out.println(son.getNom()+ "\n" + son.getM());
                    }

                    if (args[2].equals("--xspf")){
                        play.exportXSPF(args[4]);
                    }
                    else if (args[2].equals("--jspf")){
                        play.exportJSPF(args[4]);
                    }
                    else if (args[2].equals("--m3u8")){
                        play.exportM3U8(args[4]);
                    }
                }
                else
                    System.out.println("Aucun fichier mp3 dans ce dossier.");
            }

            else if(args[0].equals("-f") && args[3].equals("-o") && args.length==5){
                File f = new File(args[1]);
                Path path = f.toPath();
                String type = Files.probeContentType(path);
                if (f.getName().toLowerCase().endsWith(".mp3") && "audio/mpeg".equals(type)){    
                    Playlist Play = new Playlist("play") ;
                    Play.ajouterSon(args[1]);
                    FichierMP3 F = new FichierMP3(args[1]);
                    System.out.println(F.getNom() + "\n" + F.getM());  
                    if (args[2].equals("--xspf")){
                        Play.exportXSPF(args[4]);
                    }
                    else if (args[2].equals("--jspf")){
                        Play.exportJSPF(args[4]);
                    }
                    else if (args[2].equals("--m3u8")){
                        Play.exportM3U8(args[4]);
                    }
                    
                }
                else
                    System.out.println("Ce n'est pas un fichier MP3.");
            }

            else
                System.out.println("Problème d'arguments : veuillez saisir -h afin de connaître les differentes options.");
        } catch (IOException e){
                System.out.println("Erreur : " + e.getMessage());
        }
    }
} 
