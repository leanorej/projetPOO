# Projet POO : métadonnées de fichiers MP3 et playlists

## Sommaire

1. Informations étudiants
2. Objectif
3. Importer le projet
4. Commandes de compilations et d'executions
5. Composition du dossier contenant le projet 


### Information étudiants

Groupe DL5
- Leanore **Jean**
- Nur **Chouaref**

### Objectif

Les objectifs principaux du projet sont **l'extraction des métadonnées de fichiers MP3** ainsi que **la création de playlist**.

Les fonctionnalités disponibles via l'**interface graphique** sont :
- la création d'une playlist par défaut ;
- la création d'une playlist vide ;
- l'ajout de fichier MP3 dans une playlist ;
- la suppression de fichier MP3 d'une playlist ;
- l'affichage des métadonnées.

Les fonctionnalités disponibles via le **mode console** sont :
- l'affichage des métadonnées d'un fichier MP3 ;
- l'affichage des métadonnées de tout les fichier MP3 d'un dossier ;
- l'exportation d'un fichier MP3 un format choisi (xspf/jspf/m3u8) vers un fichier ;
- l'exportation d'une playlist créée à partir de tous les fichiers MP3 d'un dossier dans un format choisi (xspf/jspf/m3u8) vers un fichier.

### Importer le projet

1. ouvrir le terminal
2. cd cheminRepertoireSouhaité
> Se place dans le repertoire où l'on souhaite importer le projet 
3. git clone https://github.com/leanorej/projetPOO.git
> Crée un dossier dans le repertoire courant et qui va contenir l'ensemble du contenu du projet
4. cd projetPOO
> Se place dans le dossier du projet
5. mkdir classesJava
> Crée le dossier dans lequel on placera les fichiers compilés


### Commandes de compilations et d'executions

- Compilation :
***
javac -d classesJava -cp "./lib/mp3agic-0.9.1.jar" *.java

- Lancer l'interface graphique (GUI) : 
***
java -cp "./classesJava:./lib/mp3agic-0.9.1.jar" projetpoo.GUI

- Lancer le mode console (CLI) :
***
java -cp "classesJava:lib/mp3agic-0.9.1.jar" projetpoo.CLI 

### Composition du dossier contenant le projet 

projetPOO
-> fichiers.java    : On retrouve directement l'ensemble des fichiers.java 
***
-> classesJava      : Sous dossier qui contient l'ensemble des fichiers.class (fichiers compilés)
***
-> fichiers mp3     : Sous dossier qui contient des fichiers MP3
-> lib              : Sous dossier qui contient le fichier mp3agic-0.9.1.jar qui sert pour l'extraction des métadonnées
***
-> README.md        : Contient la documentation d'utilisation du projet 

