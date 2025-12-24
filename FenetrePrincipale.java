package projetpoo;

import javax.swing.*;
import java.awt.*;

/**
 * FenetrePrincipale : fenêtre principale du lecteur MP3
 * Contient le panel de gauche (playlists) et le panel de droite (lecteur)
 */
public class FenetrePrincipale extends JFrame {

    /**
     * Constructeur : initialise la fenêtre principale
     */
    public FenetrePrincipale() {
        setTitle("Lecteur MP3 (Spotify en mieux)");
        setSize(1000, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2, 10, 10));

        // Création du panel lecteur et playlist
        PanelLecteur lecteur = new PanelLecteur();
        add(new PanelPlaylist(lecteur));
        add(lecteur);

        getContentPane().setBackground(new Color(120, 135, 200));
        setVisible(true);
    }
}

