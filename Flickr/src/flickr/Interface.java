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
    
    public Interface(){
        super("Flickr");                 //défini le titre
        setFenetre();
    }
    
    protected void setFenetre(){
        setSize(new Dimension(800,600));        //la taille       

        JPanel pan=new JPanel();              //panel 
        
        FlowLayout experimentLayout = new FlowLayout();
        pan.setLayout(experimentLayout);

        JTextField  tf = new JTextField("#Tag"); //un champ texte!
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

        pan.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setContentPane(pan);        //defini le panel de la JFrame
        setVisible(true);           //affiche la JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //opération par défaut a la fermeture
    } 
       
}
