package Resturante;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminFrame extends JFrame implements ActionListener {

   private JPanel admin;
   private JButton aggiungiPiatti;
   private JButton rimuoviPiatti;
   private JButton modificaPiatti;
   private JButton prenotazione;
   private JButton MostraFeedback;
   private JButton logout;

   public AdminFrame(String titolo) {
       super(titolo);
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
       MostraFeedback = new JButton("Mostra Feedback");
       logout = new JButton("Logout");

       aggiungiPiatti.setBounds(250, 100, 200, 40);
       rimuoviPiatti.setBounds(250, 170, 200, 40);
       modificaPiatti.setBounds(250, 240, 200, 40);
       prenotazione.setBounds(250, 320, 200, 40);
       MostraFeedback.setBounds(250, 400, 200, 40);
       logout.setBounds(250, 480, 200, 40);

       aggiungiPiatti.setBackground(orange);
       rimuoviPiatti.setBackground(orange);
       modificaPiatti.setBackground(orange);
       prenotazione.setBackground(orange);
       MostraFeedback.setBackground(orange);
       logout.setBackground(new Color(255, 69, 0)); 

       aggiungiPiatti.setOpaque(true);
       rimuoviPiatti.setOpaque(true);
       modificaPiatti.setOpaque(true);
       prenotazione.setOpaque(true);
       MostraFeedback.setOpaque(true);
       logout.setOpaque(true);

       aggiungiPiatti.addActionListener(this);
       rimuoviPiatti.addActionListener(this);
       modificaPiatti.addActionListener(this);
       prenotazione.addActionListener(this);
       MostraFeedback.addActionListener(this);
       logout.addActionListener(this);

       admin.add(aggiungiPiatti);
       admin.add(rimuoviPiatti);
       admin.add(modificaPiatti);
       admin.add(prenotazione);
       admin.add(MostraFeedback);
       admin.add(logout);

       setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
       if(e.getSource() == aggiungiPiatti){
           new AggiungiPiatti();
           this.dispose();
       }

       if(e.getSource() == rimuoviPiatti){
           new RimovePiatti();
           this.dispose();
       }

       if(e.getSource() == modificaPiatti){
           new ModificaPiatti();
       }

       if(e.getSource() == MostraFeedback){
          new MostraFeedbackFrame();
       }

       if(e.getSource() == logout){
           new homeFrame("Casa");
           this.dispose();
       }
   }
}