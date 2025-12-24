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

    private DefaultListModel<Playlist> modelePlaylists;
    private JList<Playlist> listePlaylists;
    private DefaultListModel<FichierMP3> modeleMP3;
    private JList<FichierMP3> listeMP3;
    private JTextField recherche;
    private PanelLecteur lecteur;

    /**
     * Constructeur de PanelPlaylist
     * Initialise tous les composants graphiques et les modèles de données
     * @parametres lecteur référence au panel lecteur pour afficher les métadonnées du fichier MP3 sélectionné
     */
    public PanelPlaylist(PanelLecteur lecteur) {
        this.lecteur = lecteur;

        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 240, 230));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        modelePlaylists = new DefaultListModel<>();
        listePlaylists = new JList<>(modelePlaylists);
        listePlaylists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listePlaylists.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) rafraichirMP3();
        });

        modeleMP3 = new DefaultListModel<>();
        listeMP3 = new JList<>(modeleMP3);
        listeMP3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeMP3.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                FichierMP3 selected = listeMP3.getSelectedValue();
                if (selected != null) lecteur.afficherMetadonnees(selected.getM());
            }
        });

        recherche = new JTextField();
        recherche.setEnabled(false);

        JLabel titre = new JLabel("Playlists");
        titre.setFont(new Font("Arial", Font.BOLD, 20));
        titre.setForeground(new Color(240, 190, 80));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        top.add(titre, BorderLayout.NORTH);
        top.add(new JScrollPane(listePlaylists), BorderLayout.CENTER);

        JButton btnCreer = new JButton("Créer playlist");
        btnCreer.addActionListener(e -> {
            String nom = JOptionPane.showInputDialog(this, "Nom de la playlist :", "Playlist par défaut");
            if (nom != null && !nom.trim().isEmpty()) {
                modelePlaylists.addElement(new Playlist(nom.trim()));
            }
        });

        JButton btnAjouter = new JButton("Ajouter MP3");
        btnAjouter.addActionListener(e -> {
            Playlist selectedPlaylist = listePlaylists.getSelectedValue();
            if (selectedPlaylist != null) ajouterMP3(selectedPlaylist);
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

        JSplitPane split = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                top,
                new JScrollPane(listeMP3)
        );
        split.setDividerLocation(200);

        add(split, BorderLayout.CENTER);
        add(boutons, BorderLayout.SOUTH);

        Playlist defaut = new Playlist("Playlist par défaut", ".");
        modelePlaylists.addElement(defaut);
        listePlaylists.setSelectedIndex(0);
    }

	/**
	* Méthode ajouterMP3 qui permet d'ajouter un fihicer MP3 à la playlist séléctionnée
	* @parametres une playlist p séléctionnée
	*/
    private void ajouterMP3(Playlist p) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            for (File f : chooser.getSelectedFiles()) {
                p.ajouterSon(f.getAbsolutePath());
            }
            rafraichirMP3();
        }
    }
	/**
	* Méthode rafraichirMP3
	*/
    private void rafraichirMP3() {
        modeleMP3.clear();
        Playlist selected = listePlaylists.getSelectedValue();
        if (selected != null) {
            for (FichierMP3 f : selected.getMusiques()) {
                modeleMP3.addElement(f);
            }
        }
    }
}
