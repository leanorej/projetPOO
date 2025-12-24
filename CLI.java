package projetpoo;
import java.util.*;
import java.nio.file.*;
import java.io.*;


/**
 * mode console  
 */

public class CLI {
    public static void main (String [] args){

            try{

                /**
                 * Si il n'y a pas d'argument dans la ligne de commande, 
                 */

                if (args.length==0){
                        System.out.println("\nAucun argument, veuillez saisir -h afin de connaître les differentes options.\n");
                    }

                else if(args.length==1 && args[0].equals("-h")){
                    System.out.println("\nVoici les différentes options disponibles : \n");
                    System.out.println(" -d cheminDossier                                : Permet d'afficher sur le terminal les métadonnées de tout les fichiers MP3 contenus dans le dossier.");
                    System.out.println(" -f cheminFichierMP3                             : Permet d'afficher sur le terminal les métadonnées du fichier s'il est de type MP3. ");
                    System.out.println(" -f cheminFichierMP3 --format -o cheminFichier2  : Permet d'exporter le fichier MP3 dans un fichier2 dans le format souhaité : xspf, jspf ou m3u8.");
                    System.out.println(" -d cheminDossier --format -o cheminFichier2     : Permet d'exporter les fichiers MP3 contenus dans le dossier dans le format souhaité : xspf, jspf ou m3u8.\n\n");
                }

                else if (args.length==2 && args[0].equals("-d")){
                    Playlist play = new Playlist("playlist", args[1]);
                    if (!play.getMusiques().isEmpty()){
                        for(FichierMP3 son : play.getMusiques()){
                            if (son.getM()==null)
                                System.out.println(son.getNom() + "\nPas de métadonnées.");
                            else
                                System.out.println(son.getNom()+ "\n" + son.getM());
                        }
                    }
                    else {
                        System.out.println("\nAucun fichier mp3 dans ce dossier.\n");
                    }
                }

                else if(args.length==2 && args[0].equals("-f")){
                    File f = new File(args[1]);
                    Path path = f.toPath();
                    String type = Files.probeContentType(path);
                    if (f.getName().toLowerCase().endsWith(".mp3") && "audio/mpeg".equals(type)){      
                        FichierMP3 F = new FichierMP3(args[1]);
                        System.out.println(F.getNom() + "\n" + F.getM());  
                    }
                    else{
                        System.out.println("\nCe n'est pas un fichier MP3.\n");
                    }
                }

                else if (args.length==5 && args[0].equals("-d") && args[3].equals("-o")){
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
                        else 
                            System.out.println("Mauvais format, veuillez saisir -h afin de connaître les differentes options.\n");
                    }
                    else{
                        System.out.println("\nAucun fichier mp3 dans ce dossier.\n");
                    }
                }

                else if(args.length==5 && args[0].equals("-f") && args[3].equals("-o")){
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
                        else 
                            System.out.println("Mauvais format, veuillez saisir -h afin de connaître les differentes options.\n");
                    }                    
                    else{
                        System.out.println("\nCe n'est pas un fichier MP3.\n");
                    }
                }
                else 
                    System.out.println("\nProblème d'arguments : veuillez saisir -h afin de connaître les differentes options.\n");
        } catch (IOException e){
            System.out.println("Problème de fichier : " + e.getMessage());
    }
    }       
}

