package flickr;

import  javax.swing.*;
import  java.awt.*;

/**
 *
 * @author Vincent
 */
public final class Interface extends JFrame{
    JPanel pan;
    JTextField  tf;
    JButton recherche;
    JButton favoris;
            
    public Interface(){
        //Défini le titre de la fenêtre
        super("Flickr");                 
        setFenetre();
        hautFenetre(pan);
        milieuFenetre(pan);
    }
    
    protected void setFenetre(){
        //Défini la taille de la fenêtre
        setSize(new Dimension(800,600));               

        //Création du JPanel
        pan = new JPanel();               
        
        FlowLayout experimentLayout = new FlowLayout();
        pan.setLayout(experimentLayout);

        pan.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //Défini le panel de la JFrame
        setContentPane(pan);
        //Affiche la JFrame
        setVisible(true); 
        //opération par défaut a la fermeture
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
    
    public void hautFenetre(JPanel pan){
        //Champ texte pour le tag
        tf = new JTextField("#Tag");
        tf.setPreferredSize( new Dimension(500 , 50 ));
        pan.add(tf);                 

        //Bouton Rechercher
        recherche = new JButton("Rechercher");
        recherche.setPreferredSize( new Dimension(100 , 50 ));
        pan.add(recherche); 
        
        //Bouton Favoris
        favoris = new JButton("Favoris");
        favoris.setPreferredSize( new Dimension(100 , 50 ));
        pan.add(favoris); 
        
        pan.revalidate();
    }
    
    public void milieuFenetre(JPanel pan){
        JLabel image = new JLabel(new ImageIcon( "~/Users/Vincent/Pictures/Avatar.png"));
        image.setPreferredSize(new Dimension(200,200));
        JPanel panel = new JPanel(); 
        panel.setPreferredSize(new Dimension(550,300));
        panel.setBackground(Color.CYAN);  
        panel.add(image);
        panel.revalidate();
        pan.add(panel);
        
        JPanel infos = new JPanel(); 
        infos.setPreferredSize(new Dimension(200,300));
        infos.setBackground(Color.RED);  
        pan.add(infos);
        
        JPanel caroussel = new JPanel(new GridLayout(0,6)); 
        caroussel.setPreferredSize(new Dimension(750,200));
        caroussel.setBackground(Color.GREEN);  
        pan.add(caroussel);
        pan.revalidate(); 
    }
       
}
