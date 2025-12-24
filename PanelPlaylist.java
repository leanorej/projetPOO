package projetpoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * PanelPlaylist, panel principal à gauche de la fenêtre
 * Permet de gérer la création de playlist, l'affichage des playlists existantes, les fichiers MP3 qu'une playlist contient, l'ajout et la suppression d'un fichier MP3, la recherche de MP3
 * Les playlists sont affichées dans une JList
 * La sélection d'une playlist déclenche l'affichage des fichiers MP3 dans la partie inférieure
 * La sélection d'un MP3 met à jour le PanelLecteur pour afficher ses métadonnées
 */
public class PanelPlaylist extends JPanel {

    private DefaultListModel<Playlist> modelePlaylists; // Modèle de données pour la JList des playlists
    private JList<Playlist> listePlaylists; // Composant graphique affichant les playlists
    private DefaultListModel<FichierMP3> modeleMP3; // Modèle de données pour la JList des fichiers MP3
    private JList<FichierMP3> listeMP3; // Composant graphique affichant les fichiers MP3
    private JTextField recherche; // Champ texte pour filtrer les MP3
    private PanelLecteur lecteur; // Référence au panel lecteur pour mise à jour des métadonnées

    /**
     * Constructeur de PanelPlaylist
     * Initialise tous les composants graphiques et les modèles de données
     * @param lecteur référence au panel lecteur pour afficher les métadonnées du fichier MP3 sélectionné
     */
    public PanelPlaylist(PanelLecteur lecteur) {
        this.lecteur = lecteur;

        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 240, 230));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Liste des playlists
        modelePlaylists = new DefaultListModel<>();
        listePlaylists = new JList<>(modelePlaylists);
        listePlaylists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listePlaylists.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) rafraichirMP3();
        });

        // Liste des fichiers MP3
        modeleMP3 = new DefaultListModel<>();
        listeMP3 = new JList<>(modeleMP3);
        listeMP3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeMP3.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                FichierMP3 selected = listeMP3.getSelectedValue();
                if (selected != null) lecteur.afficherMetadonnees(selected.getM());
            }
        });

        // Barre de recherche
        recherche = new JTextField();
        recherche.setToolTipText("Rechercher une musique par nom...");
        recherche.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) { filtrerMP3(); }
        });

        // Panel du haut avec titre et recherche
        JLabel titre = new JLabel("Playlists");
        titre.setFont(new Font("Arial", Font.BOLD, 20));
        titre.setForeground(new Color(240, 190, 80));
        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        top.add(titre, BorderLayout.NORTH);
        top.add(recherche, BorderLayout.SOUTH);

        // Boutons
        JButton btnCreer = new JButton("Créer playlist");
        btnCreer.addActionListener(e -> {
            String nom = JOptionPane.showInputDialog(this, "Nom de la playlist :", "Playlist par défaut");
            if (nom != null && !nom.trim().isEmpty()) {
                Playlist p = new Playlist(nom.trim());
                modelePlaylists.addElement(p);
            }
        });

        JButton btnAjouter = new JButton("Ajouter MP3");
        btnAjouter.addActionListener(e -> {
            Playlist selectedPlaylist = listePlaylists.getSelectedValue();
            if (selectedPlaylist == null) JOptionPane.showMessageDialog(this, "Sélectionnez d'abord une playlist !");
            else ajouterMP3(selectedPlaylist);
        });

        JButton btnSupprimer = new JButton("Supprimer MP3");
        btnSupprimer.addActionListener(e -> {
            Playlist selectedPlaylist = listePlaylists.getSelectedValue();
            FichierMP3 selectedMP3 = listeMP3.getSelectedValue();
            if (selectedPlaylist != null && selectedMP3 != null) {
                selectedPlaylist.supprimerSon(selectedMP3);
                rafraichirMP3();
            }
        });

        JPanel boutons = new JPanel();
        boutons.setOpaque(false);
        boutons.add(btnCreer);
        boutons.add(btnAjouter);
        boutons.add(btnSupprimer);

        // SplitPane : playlists en haut, MP3 en bas
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(listePlaylists),
                new JScrollPane(listeMP3));
        split.setDividerLocation(150);

        add(top, BorderLayout.NORTH);
        add(split, BorderLayout.CENTER);
        add(boutons, BorderLayout.SOUTH);
    }

    /**
     * Ajoute des fichiers MP3 à une playlist
     * @param p Playlist cible
     */
    private void ajouterMP3(Playlist p) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) { return f.isDirectory() || f.getName().toLowerCase().endsWith(".mp3"); }
            @Override
            public String getDescription() { return "Fichiers MP3 (*.mp3)"; }
        });

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File[] fichiers = chooser.getSelectedFiles();
            for (File f : fichiers) p.ajouterSon(f.getAbsolutePath());
            rafraichirMP3();
        }
    }

    /**
     * Met à jour la liste des MP3 affichés selon la playlist sélectionnée
     */
    private void rafraichirMP3() {
        Playlist selected = listePlaylists.getSelectedValue();
        modeleMP3.clear();
        if (selected != null) {
            for (FichierMP3 f : selected.getMusiques()) modeleMP3.addElement(f);
        }
    }

    /**
     * Filtre les MP3 affichés selon le texte saisi dans la barre de recherche
     */
    private void filtrerMP3() {
        Playlist selected = listePlaylists.getSelectedValue();
        if (selected == null) return;
        String texte = recherche.getText().toLowerCase();
        modeleMP3.clear();
        for (FichierMP3 f : selected.getMusiques()) {
            if (f.getNom().toLowerCase().contains(texte)) modeleMP3.addElement(f);
        }
    }
}

