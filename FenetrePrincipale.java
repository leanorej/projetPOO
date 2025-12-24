package projetpoo;

import javax.swing.*;
import java.awt.*;

/**
 * FenetrePrincipale : classe de la fenêtre principale du lecteur MP3
 * On y retrouve deux zones principales, à droit le panel des playlists, à gauche le panel du lecteur
 * La fenêtre est initialisée avec un titre, une taille, une couleur de fond, et un layout en grille
 */
public class FenetrePrincipale extends JFrame {

    /**
     * Constructeur de la fenêtre principale
     * Cette méthode initialise le titre, la taille, le comportement à la fermeture, la position au centre de l'écran, le layout de la fenêtre, les panels, la couleur de fond et enfin, la fenêtre est rendue visible à l'écran
     */
    public FenetrePrincipale() {
        setTitle("Lecteur MP3 (Spotify en mieux)"); // Définit le titre de la fenêtre
        setSize(1000, 550); // Définit la largeur et la hauteur de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme l'application lorsque la fenêtre est fermée
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran

        setLayout(new GridLayout(1, 2, 10, 10)); // Utilise un GridLayout : 1 ligne, 2 colonnes, espace de 10px entre les panels

        PanelLecteur lecteur = new PanelLecteur(); // Panel de droite affichant le morceau en cours et ses métadonnées
        PanelPlaylist playlistPanel = new PanelPlaylist(lecteur); // Panel de gauche affichant les playlists et fichiers MP3. On lui passe la référence au lecteur pour pouvoir afficher les métadonnées

        add(playlistPanel); // Ajout du panel playlist à gauche
        add(lecteur); // Ajout du panel lecteur à droite

        getContentPane().setBackground(new Color(120, 135, 200)); // Couleur de fond globale de la fenêtre

        setVisible(true); // Rend la fenêtre visible
    }
}
