package projetpoo;

import javax.swing.SwingUtilities;

/** 
* On lance l'interface graphique et on crée la fenêtre
*/
public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FenetrePrincipale();
        });
    }
}
