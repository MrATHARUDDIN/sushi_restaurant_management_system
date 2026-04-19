package Resturante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class sushiFrame extends JFrame implements ActionListener {

    private JPanel sushi, grid, bottom, itemPanel, buttons;
    private JLabel background;
    private JButton orderBtn, backBtn;
    private ArrayList<JComboBox<String>> quantityBoxes = new ArrayList<>();
    private ArrayList<Piatto> sushiList;

    public sushiFrame(String titolo) {

        super(titolo);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(450, 50, 750, 750);

        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/Resturante/int.jpg"));
        background = new JLabel(bgIcon);
        background.setLayout(new BorderLayout());

        sushi = new JPanel(new BorderLayout());
        sushi.setOpaque(false);

        grid = new JPanel(new GridLayout(3, 3, 10, 10));
        grid.setOpaque(false);

        sushiList = Menu.getSushi();

        for (Piatto p : sushiList) {

            itemPanel = new JPanel(new BorderLayout());
            itemPanel.setOpaque(false);
            itemPanel.setBorder(new EmptyBorder(0, 20, 0, 20));

            JLabel imageLabel = new JLabel();

            String imagePath = "sushi/" + p.getImg();
            java.net.URL imgURL = getClass().getResource(imagePath);

            ImageIcon icon;
            if (getClass().getResource("/Resturante/sushi/" + p.getImg()) != null) {
                icon = new ImageIcon(getClass().getResource("/Resturante/sushi/" + p.getImg()));
            } else {
                icon = new ImageIcon();
                System.out.println("Image not found: " + p.getImg());
            }

            Image scaled = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));

            JLabel nameLabel = new JLabel(p.getNome(), JLabel.CENTER);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            nameLabel.setForeground(Color.WHITE);

            JLabel priceLabel = new JLabel("€ " + p.getPrezzo(), JLabel.CENTER);
            priceLabel.setForeground(Color.YELLOW);

            JComboBox<String> quantityBox = new JComboBox<>();
            for (int q = 0; q <= 5; q++) {
                quantityBox.addItem(String.valueOf(q));
            }

            bottom = new JPanel(new BorderLayout());
            bottom.setOpaque(false);

            bottom.add(nameLabel, BorderLayout.NORTH);
            bottom.add(priceLabel, BorderLayout.CENTER);
            bottom.add(quantityBox, BorderLayout.SOUTH);

            itemPanel.add(imageLabel, BorderLayout.CENTER);
            itemPanel.add(bottom, BorderLayout.SOUTH);

            grid.add(itemPanel);
            quantityBoxes.add(quantityBox);
        }

        buttons = new JPanel();
        buttons.setOpaque(false);

        orderBtn = new JButton("Ordina");
        backBtn = new JButton("Indietro");

        orderBtn.addActionListener(this);
        backBtn.addActionListener(this);

        buttons.add(backBtn);
        buttons.add(orderBtn);

        sushi.add(grid, BorderLayout.CENTER);
        sushi.add(buttons, BorderLayout.SOUTH);
        background.add(sushi, BorderLayout.CENTER);

        setContentPane(background);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == orderBtn) {
            if (e.getSource() == orderBtn) {

                ArrayList<Ordine> ordini = new ArrayList<>();

                for (int i = 0; i < sushiList.size(); i++) {

                    int quantita = Integer.parseInt((String) quantityBoxes.get(i).getSelectedItem());

                    if (quantita > 0) {
                        Piatto p = sushiList.get(i);
                        ordini.add(new Ordine(p.getNome(), quantita, p.getPrezzo()));
                    }
                }

                new Scontrino(ordini);
            }
        }
        if (e.getSource() == backBtn) {
            new Categoria("catagoria");
            this.dispose();
        }
    }
}
