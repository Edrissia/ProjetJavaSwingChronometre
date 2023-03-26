import javax.swing.*;//Le package javax.swing fournit des classes pour créer des interfaces utilisateur graphiques en Java. L'etoile (*) après le nom du package signifie que toutes les classes et interfaces du package seront importées

import java.awt.*;//Les packages "javax.swing" et "java.awt" sont tous les deux utilisés pour créer des interfaces graphiques en Java, mais ils ont des différences importantes.

import java.awt.event.*;//java.awt.event fournit des classes pour gérer les événements utilisateur dans les interfaces graphiques en Java.

public class StopWatch extends JFrame implements ActionListener {
    //Declaration des variables globales
    JLabel tempsLabel;
    JButton DemarrerButton, arretButton, reprButton;
    Timer timer;
    int heures, minutes, secondes;

    //Constructeur de la classe

    public StopWatch() {
        setTitle("Chronomètre");
        setSize(300, 200);//preciser la taille de la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //définir le comportement par défaut de fermeture d'une fenêtre JFrame en Java.
        setLayout(new GridLayout(2, 1));//signifie qu'il y aura deux composants dans la fenêtre, un en haut et un en bas.

        tempsLabel = new JLabel("00:00:00"); // Créer un nouvel objet JLabel avec le texte "00:00:00"
        tempsLabel.setHorizontalAlignment(JLabel.CENTER);// Définir l'alignement horizontal du texte dans l'objet JLabel au centre
        tempsLabel.setFont(new Font("Arial", Font.PLAIN, 40));//définir la police", "Arial" est le nom de la police, "Font.PLAIN" représente le style de la police (sans gras, italique ou souligné) et "40" est la taille de la police.
        add(tempsLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        DemarrerButton = new JButton("Démarrer");
        DemarrerButton.addActionListener(this);//signifie que le bouton "DemarrerButton" a un écouteur d'événement attaché à lui, et que cet écouteur est l'objet courant.


        arretButton = new JButton("Arreter");
        arretButton.addActionListener(this);


        reprButton = new JButton("Reprendre");
        reprButton.addActionListener(this);


        add(buttonPanel);

        timer = new Timer(1000, this);
        this.setResizable(false);
        buttonPanel.add(DemarrerButton);
        buttonPanel.add(arretButton);
        buttonPanel.add(reprButton);
    }

    public void actionPerformed(ActionEvent e) {
        //Si l'objet à l'origine de l'événement 'e' est égal au bouton "DemarrerButton"
        if (e.getSource() == DemarrerButton) {
            timer.start();
        } else if (e.getSource() == arretButton) {
            timer.stop();
        } else if (e.getSource() == reprButton) {
            timer.stop();
            heures = 0;
            minutes = 0;
            secondes = 0;
            updateTimeLabel();
        } else {
            secondes++;
            if (secondes == 60) {
                secondes = 0;
                minutes++;
            }
            if (minutes == 60) {
                minutes = 0;
                heures++;
            }
            updateTimeLabel();
        }
    }

    public void updateTimeLabel() {
        //met à jour le texte du label 'tempsLabel' avec une chaîne de caractères formatée qui représente l'heure en heures, minutes et secondes
        tempsLabel.setText(String.format("%02d:%02d:%02d", heures, minutes, secondes));
    }



}
