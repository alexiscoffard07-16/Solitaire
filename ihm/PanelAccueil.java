package ihm;

import controleur.Controleur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;

public class PanelAccueil extends JPanel implements ActionListener
{
    private Controleur ctrl;
    private FrameJeu   frame;
    private int        indice;

    private JButton    btnJouer;
    private JButton    btnQuitter;

    private JLabel lblTitre;

    private ImageIcon imgEventail;
    private ImageIcon imgPioche;
    private ImageIcon imgFiligrane;
    private ImageIcon imgBordureSupGauche;
    private ImageIcon imgBordureSupDroit ;
    private ImageIcon imgBordureInfGauche;
    private ImageIcon imgBordureInfDroit ;

    public PanelAccueil(Controleur ctrl, FrameJeu frame, int indice)
    {
        this.setLayout(new GridBagLayout());
        this.setBackground(ConstantesIHM.COULEUR_FOND);

        this.ctrl   = ctrl;
        this.frame  = frame;
        this.indice = indice;

        /*-------------------------------*/
        /*   Création des composants     */
        /*-------------------------------*/

        this.creerComposants();

        /*-------------------------------*/
        /* Positionnement des composants */
        /*-------------------------------*/
        
        this.positionnerComposants();

        /* ----------------------------- */
        /* Activation des Composants     */
        /* ----------------------------- */

        this.activerComposants();

        this.setVisible(true);
    }

    @Override
    public void actionPerformed ( ActionEvent e )
	{
        /*if (e.getSource() == this.btnJouer)
        {
            this.frame.creerPanelChoixDiff();
            this.frame.setPnl(this.frame.getPnl(this.indice + 1));
        }*/

        if (e.getSource() == this.btnQuitter)
        {
            System.exit(0);
        }
    }

    /*-------------------------------*/
    /*      Méthodes utilitaires     */
    /*-------------------------------*/

    // Méthode qui crée les composants de l'interface
    private void creerComposants()
    {
        this.lblTitre   = new JLabel(new ImageIcon("./images/logos/Solitaire.png"));
        this.lblTitre   .setFont(new Font("Noto Serif Display Black", Font.BOLD, 80));

        this.btnJouer   = new JButton("Jouer !");
        this.btnJouer   .setFont(new Font("Sans-Serif", Font.PLAIN, 24));
        this.btnJouer   .setBackground(ConstantesIHM.COULEUR_FOND_BOUTON_ACCUEIL);
        this.btnJouer   .setBorder(BorderFactory.createCompoundBorder(ConstantesIHM.RELIEF, ConstantesIHM.MARGE));
        this.btnJouer   .setFocusPainted(false);
        this.btnJouer   .setPreferredSize(new Dimension(250, 60)); 
        //this.btnJouer   .setIcon(new ImageIcon(this.frame.creerImages("./images/icones/jouer.png", 30, 25)));

        this.btnQuitter = new JButton("Quitter");
        this.btnQuitter .setFont(new Font("Sans-Serif", Font.PLAIN, 24));
        this.btnQuitter .setBackground(ConstantesIHM.COULEUR_FOND_BOUTON_ACCUEIL);
        this.btnQuitter .setBorder(BorderFactory.createCompoundBorder(ConstantesIHM.RELIEF, ConstantesIHM.MARGE));
        this.btnQuitter .setFocusPainted(false);
        this.btnQuitter .setPreferredSize(new Dimension(250, 60));
        //this.btnQuitter .setIcon(new ImageIcon(this.frame.creerImages("./images/icones/quitter.png", 30, 25)));

        this.imgBordureInfDroit = new ImageIcon("./images/logos/bord-inf-droit.png");
        this.imgEventail = new ImageIcon("./images/logos/eventail-cartes.png");
        this.imgPioche  = new ImageIcon("./images/logos/pioche.png");
        this.imgBordureSupGauche = new ImageIcon("./images/logos/bord-sup-gauche.png");
        this.imgBordureSupDroit  = new ImageIcon("./images/logos/bord-sup-droit.png");
        this.imgFiligrane = new ImageIcon("./images/logos/filigrane-symboles.png");
        this.imgBordureInfGauche = new ImageIcon("./images/logos/bord-inf-gauche.png");
    }

    // Méthode qui positionne les composants de l'interface
    private void positionnerComposants()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Tout sera empilé dans la même colonne
        gbc.anchor = GridBagConstraints.CENTER; // Centré horizontalement

        // Le Titre
        gbc.gridy = 0; // Tout en haut de notre grille
        // Insets(Haut, Gauche, Bas, Droite) = grand espace sous le titre
        gbc.insets = new Insets(130, 0, 150, 0);
        this.add(this.lblTitre, gbc);

        // Le bouton Jouer
        gbc.gridy = 1; // En dessous du titre
        gbc.insets = new Insets(50, 0, 20, 0); // Petit espace de 20px sous ce bouton
        this.add(this.btnJouer, gbc);

        // Le bouton Quitter
        gbc.gridy = 2; // Tout en bas
        gbc.insets = new Insets(0, 0, 0, 0); // Pas d'espace en dessous
        this.add(this.btnQuitter, gbc);

        // 4. LE RESSORT INVISIBLE
        gbc.gridy = 3; // On le place sur une 4ème ligne
        gbc.weighty = 1.0; // Il aspire tout l'espace vertical restant
        this.add(new JLabel(""), gbc); // On ajoute un texte vide
    }

    // Méthode qui active les composants de l'interface
    private void activerComposants()
    {
        this.btnJouer.addActionListener(this);
        this.btnJouer.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                btnJouer.setBackground(ConstantesIHM.COULEUR_GRIS_SURVOL);
                btnJouer.setForeground(Color.BLACK); 
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                btnJouer.setBackground(ConstantesIHM.COULEUR_FOND_BOUTON_ACCUEIL);
                btnJouer.setForeground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                btnJouer.setBackground(ConstantesIHM.COULEUR_FOND_BOUTON_ACCUEIL);
                btnJouer.setForeground(Color.BLACK);
            }
        });
        
        this.btnQuitter.addActionListener(this);
        this.btnQuitter.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                btnQuitter.setBackground(ConstantesIHM.COULEUR_GRIS_SURVOL);
                btnQuitter.setForeground(Color.BLACK); // Pour que le texte reste lisible
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                btnQuitter.setBackground(ConstantesIHM.COULEUR_FOND_BOUTON_ACCUEIL);
                btnQuitter.setForeground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                btnQuitter.setBackground(Color.WHITE);
                btnQuitter.setForeground(Color.BLACK);
            }
        });
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Bordure Dorée Supérieure Gauche
        g.drawImage(this.imgBordureSupGauche.getImage(), 0, 0, this);

        // Bordure Dorée Supérieure Droite
        int xBordSupDroit = this.getWidth() - this.imgBordureSupDroit.getIconWidth();
        g.drawImage(this.imgBordureSupDroit.getImage(), xBordSupDroit, 0, this);

        // Bordure Dorée Inférieure Droite
        int xBordInfDroit = this.getWidth() - this.imgBordureInfDroit.getIconWidth();
        int yBordInfDroit = this.getHeight() - this.imgBordureInfDroit.getIconHeight();
        g.drawImage(this.imgBordureInfDroit.getImage(), xBordInfDroit, yBordInfDroit, this);

        // Bordure Inférieure Gauche
        int yBordInfGauche = this.getHeight() - this.imgBordureInfGauche.getIconHeight();
        g.drawImage(this.imgBordureInfGauche.getImage(), 0, yBordInfGauche, this);
        
        // Filigrane
        int lMotif = this.imgFiligrane.getIconWidth() > 0 ? this.imgFiligrane.getIconWidth() : 0;

        for (int i = 0; i <= this.getWidth(); i += lMotif)
        {
            g.drawImage(this.imgFiligrane.getImage(), i, 2, this);
        }

        // Eventail 
        
        int xEventail   = this.getWidth() - this.imgEventail.getIconWidth() + 80;
        int yEventail   = this.getHeight() - this.imgEventail.getIconHeight() + 80;

        g.drawImage(this.imgEventail.getImage()             , xEventail , yEventail , this);

        // Pioche
        int xPioche     = 20;
        int yPioche     = this.getHeight() - this.imgPioche.getIconHeight() - 20;

        g.drawImage(this.imgPioche.getImage()               , xPioche   , yPioche   , this);

    }
}