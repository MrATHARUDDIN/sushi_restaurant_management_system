package Resturante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DettaglioTavolo extends JFrame implements ActionListener {

    private JComboBox<Integer> comboPersone;
    private JRadioButton generale, allYouCanEat;
    private JButton conferma, annulla;

    private ClasseTavolo tavolo;
    private JButton bottone;

    public DettaglioTavolo(ClasseTavolo tavolo, JButton bottone) {
        this.tavolo = tavolo;
        this.bottone = bottone;

        setTitle("Tavolo " + tavolo.getNumeroTavolo());
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblPersone = new JLabel("Persone:");
        lblPersone.setBounds(30, 20, 100, 25);
        add(lblPersone);

        Integer[] numeri = {1,2,3,4,5,6,7,8};
        comboPersone = new JComboBox<>(numeri);
        comboPersone.setBounds(120, 20, 150, 25);
        add(comboPersone);

        JLabel lblMenu = new JLabel("Tipo di Menu:");
        lblMenu.setBounds(30, 60, 150, 25);
        add(lblMenu);

        generale = new JRadioButton("Generale");
        generale.setBounds(30, 90, 120, 25);

        allYouCanEat = new JRadioButton("All you can eat");
        allYouCanEat.setBounds(30, 120, 150, 25);

        ButtonGroup gruppo = new ButtonGroup();
        gruppo.add(generale);
        gruppo.add(allYouCanEat);

        add(generale);
        add(allYouCanEat);

        conferma = new JButton("Conferma");
        conferma.setBounds(40, 160, 120, 30);
        conferma.setBackground(Color.GREEN);
        conferma.addActionListener(this);

        annulla = new JButton("annulla");
        annulla.setBounds(180, 160, 120, 30);
        annulla.setBackground(Color.RED);
        annulla.addActionListener(this);

        add(conferma);
        add(annulla);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == conferma) {

            int persone = (int) comboPersone.getSelectedItem();
            String menu = generale.isSelected() ? "Generale" : "All you can eat";

            tavolo.setPersone(persone);
            tavolo.setTipoMenu(menu);
            tavolo.setOccupato(true);

            bottone.setBackground(Color.RED);

            JOptionPane.showMessageDialog(this,
                    "Salvato!\nPersone: " + persone + "\nMenu: " + menu);
            new Prenotazione("Prenota");
            this.dispose();
        }

        if (e.getSource() == annulla) {
            this.dispose();
        }
    }
}