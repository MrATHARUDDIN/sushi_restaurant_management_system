/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resturante;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Utente
 */
public class AdminFrame extends JFrame implements ActionListener {

   private JPanel admin;
    private JButton aggiungiPiatti;
    private JButton rimuoviPiatti;
    private JButton modificaPiatti;
    private JButton prenotazione;
    private JButton cronologia;
    
    
    public AdminFrame() {
        admin = new JPanel();
        add(admin);
        admin.setLayout(null);
        setBounds(500, 200, 750, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        Color orange = new Color(255, 140, 0);
        
        aggiungiPiatti = new JButton("Aggiungi Piatti");
        rimuoviPiatti = new JButton("Rimuovi Piatti");
        modificaPiatti = new JButton("Modifica Piatti");
        prenotazione = new JButton("Prenotazioni");
        cronologia = new JButton("Cronologia");

        aggiungiPiatti.setBounds(250, 100, 200, 40);
        rimuoviPiatti.setBounds(250, 170, 200, 40);
        modificaPiatti.setBounds(250, 240, 200, 40);
        prenotazione.setBounds(250, 320, 200, 40);
        cronologia.setBounds(250, 400, 200, 40);

        
        aggiungiPiatti.setBackground(orange);
        rimuoviPiatti.setBackground(orange);
        modificaPiatti.setBackground(orange);
        prenotazione.setBackground(orange);
        cronologia.setBackground(orange);

        aggiungiPiatti.setOpaque(true);
        rimuoviPiatti.setOpaque(true);
        modificaPiatti.setOpaque(true);
        prenotazione.setOpaque(true);
        cronologia.setOpaque(true);
        
         aggiungiPiatti.addActionListener(this);
        rimuoviPiatti.addActionListener(this);
        modificaPiatti.addActionListener(this);
        prenotazione.addActionListener(this);
        cronologia.addActionListener(this);
        
        admin.add(aggiungiPiatti);
        admin.add(rimuoviPiatti);
        admin.add(modificaPiatti);
        admin.add(prenotazione);
        admin.add(cronologia);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
