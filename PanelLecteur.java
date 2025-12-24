package projetpoo;

import javax.swing.*;
import java.awt.*;

/**
 * PanelLecteur : panel principal à droite de la fenêtre
 * Ce panel affiche le morceau en cours et ses métadonnées
 * Il contient un label pour le titre, un panel pour l'image, un panel pour les boutons de controles
 * Le panel utilise un BorderLayout pour organiser les éléments
 */
public class PanelLecteur extends JPanel {

	private JLabel titreLabel; // Label affichant le titre du morceau en cours
	private JPanel imagePanel; // Panel affichant la pochette ou une zone graphique pour le morceau
	private JPanel controlesPanel; // Panel contenant les boutons de contrôle (précédent, lecture, suivant)

	/**
	 * Constructeur de PanelLecteur.
	 * Initialise le layout, la couleur de fond, les marges, et les composants graphiques
	 * Les boutons sont créés mais ne sont pas encore fonctionnels pour la lecture
	 */
	public PanelLecteur() {
		setLayout(new BorderLayout(10, 10)); // Layout principal : BorderLayout avec 10px de marge
		setBackground(new Color(245, 240, 230)); // Fond clair pour contraste avec PanelPlaylist
		setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Marge intérieure autour des composants

		/**
		 * Label pour le titre du morceau
		 * Centré, avec une police colorée
		 */
		titreLabel = new JLabel("Son en cours", SwingConstants.CENTER);
		titreLabel.setFont(new Font("Arial", Font.BOLD, 20));
		titreLabel.setForeground(new Color(240, 190, 80));

		/**
		 * Panel pour l'image
		 * Zone carrée avec un cadre violet
		 */
		imagePanel = new JPanel(new BorderLayout());
		imagePanel.setPreferredSize(new Dimension(200, 200));
		imagePanel.setBorder(BorderFactory.createLineBorder(new Color(160, 140, 220), 4));
		// Placeholder par défaut
		JLabel placeholder = new JLabel("Pas d'image", SwingConstants.CENTER);
		placeholder.setOpaque(true);
		placeholder.setBackground(new Color(220, 220, 220));
		imagePanel.add(placeholder, BorderLayout.CENTER);

		/**
		 * Panel pour les boutons de contrôle
		 */
		controlesPanel = new JPanel();
		controlesPanel.setOpaque(false);
		controlesPanel.add(new JButton("⏮")); // Bouton précédent
		controlesPanel.add(new JButton("⏯")); // Bouton lecture/pause
		controlesPanel.add(new JButton("⏭")); // Bouton suivant

		/**
		 * Ajout des composants au panel principal
		 */
		add(titreLabel, BorderLayout.NORTH);
		add(imagePanel, BorderLayout.CENTER);
		add(controlesPanel, BorderLayout.SOUTH);
	}

	/**
	 * Met à jour le panel pour afficher les métadonnées d'un MP3
	 * @parametres md objet Metadonnees du MP3 sélectionné
	 */
	public void afficherMetadonnees(Metadonnees md) {
		imagePanel.removeAll();

		if (md != null) {
			titreLabel.setText(md.getTitre() != null ? md.getTitre() : "Titre inconnu");

			if (md.getImage() != null) {
				Image img = md.getImage().getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
				JLabel imgLabel = new JLabel(new ImageIcon(img));
				imagePanel.add(imgLabel, BorderLayout.CENTER);
			} else {
				JLabel placeholder = new JLabel("Pas d'image", SwingConstants.CENTER);
				placeholder.setOpaque(true);
				placeholder.setBackground(new Color(220, 220, 220));
				imagePanel.add(placeholder, BorderLayout.CENTER);
			}

		} else {
			JLabel placeholder = new JLabel("Pas d'image", SwingConstants.CENTER);
			placeholder.setOpaque(true);
			placeholder.setBackground(new Color(220, 220, 220));
			imagePanel.add(placeholder, BorderLayout.CENTER);
			titreLabel.setText("Son en cours");
		}

		imagePanel.revalidate();
		imagePanel.repaint();
	}

	/**
	 * Méthode permettant de mettre à jour le titre affiché dans le panel lorsqu'un MP3 est sélectionné
	 * @parametres titre Titre du morceau à afficher
	 */
	public void setTitre(String titre) {
		titreLabel.setText(titre);
	}

	/**
	 * Méthode permettant d'accéder au panel image (potentielle pochette) pour éventuellement y afficher une image ou un visuel
	 * @return JPanel imagePanel
	 */
	public JPanel getImagePanel() {
		return imagePanel;
	}
}
