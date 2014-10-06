/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flickr;

import  javax.swing.*;
import  java.awt.*;

/**
 *
 * @author Vincent
 */
public final class Interface extends JFrame{
    JPanel pan;
    
    public Interface(){
        //Défini le titre de la fenêtre
        super("Flickr");                 
        setFenetre();
        hautFenetre(pan);
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
        JTextField  tf = new JTextField("#Tag");
        tf.setPreferredSize( new Dimension(500 , 50 ));
        pan.add(tf);                 

        //Bouton Rechercher
        JButton recherche = new JButton("Rechercher");
        recherche.setPreferredSize( new Dimension(100 , 50 ));
        pan.add(recherche); 
        
        //Bouton Favoris
        JButton favoris = new JButton("Favoris");
        favoris.setPreferredSize( new Dimension(100 , 50 ));
        pan.add(favoris);  
    }
       
}
