package Resturante;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsegnaDomicilio extends JFrame implements ActionListener {

    private JTextField nomeField, indirizzoField, telefonoField;
    private JTextArea ordineArea;
    private JButton confermaBtn, annullaBtn;

    public ConsegnaDomicilio() {

        setTitle("Consegna a Domicilio");
        setBounds(500, 200, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Pannello principale
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Etichette e campi
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(30, 30, 80, 25);
        panel.add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(120, 30, 200, 25);
        panel.add(nomeField);

        JLabel indirizzoLabel = new JLabel("Indirizzo:");
        indirizzoLabel.setBounds(30, 70, 80, 25);
        panel.add(indirizzoLabel);

        indirizzoField = new JTextField();
        indirizzoField.setBounds(120, 70, 200, 25);
        panel.add(indirizzoField);

        JLabel telefonoLabel = new JLabel("Telefono:");
        telefonoLabel.setBounds(30, 110, 80, 25);
        panel.add(telefonoLabel);

        telefonoField = new JTextField();
        telefonoField.setBounds(120, 110, 200, 25);
        panel.add(telefonoField);

        // Area ordine
        ordineArea = new JTextArea();
        ordineArea.setBorder(BorderFactory.createTitledBorder("Ordine"));
        ordineArea.setBounds(30, 150, 290, 120);
        panel.add(ordineArea);

        // Pulsanti
        confermaBtn = new JButton("Conferma");
        confermaBtn.setBounds(50, 300, 120, 40);
        confermaBtn.setBackground(Color.GREEN);
        confermaBtn.addActionListener(this);
        panel.add(confermaBtn);

        annullaBtn = new JButton("Annulla");
        annullaBtn.setBounds(200, 300, 120, 40);
        annullaBtn.setBackground(Color.RED);
        annullaBtn.addActionListener(this);
        panel.add(annullaBtn);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == confermaBtn) {
            String nome = nomeField.getText();
            String indirizzo = indirizzoField.getText();
            String telefono = telefonoField.getText();
            String ordine = ordineArea.getText();

            JOptionPane.showMessageDialog(this,
                    "Ordine confermato!\n\nNome: " + nome +
                    "\nIndirizzo: " + indirizzo +
                    "\nTelefono: " + telefono +
                    "\nOrdine:\n" + ordine);
            
                        new UserPage();
                        this.dispose();

        }

        if (e.getSource() == annullaBtn) {
            new UserPage();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new ConsegnaDomicilio();
    }
}