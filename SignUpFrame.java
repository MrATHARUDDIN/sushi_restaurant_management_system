package Resturante;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RimovePiatti extends JFrame {

    private JPanel mainPanel;

    public RimovePiatti() {
        super("Remove Piatti");

        setSize(600, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton annullaBtn = new JButton("Annulla");
        annullaBtn.setBackground(Color.LIGHT_GRAY);

        annullaBtn.addActionListener(e -> {
            new AdminFrame("Admin page");
            this.dispose();
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(annullaBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        loadPiatti();

        setVisible(true);
    }

    private void loadPiatti() {
        mainPanel.removeAll();

        for (Piatto p : Menu.getMenu()) {
            mainPanel.add(createCard(p));
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private JPanel createCard(Piatto p) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // IMAGE
        JLabel imgLabel = new JLabel();
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imgLabel.setPreferredSize(new Dimension(120, 80));

        try {
            Image img;

            if (p.getImg().startsWith("http")) {
                img = ImageIO.read(new URL(p.getImg()));
            } else {
                img = ImageIO.read(getClass().getResource("sushi/" + p.getImg()));
            }

            Image scaled = img.getScaledInstance(120, 80, Image.SCALE_SMOOTH);
            imgLabel.setIcon(new ImageIcon(scaled));

        } catch (Exception e) {
            imgLabel.setOpaque(true);
            imgLabel.setBackground(new Color(255, 153, 51));
        }

        card.add(imgLabel, BorderLayout.CENTER);

        JButton removeBtn = new JButton("Remove");
        removeBtn.setBackground(new Color(255, 69, 0));
        removeBtn.setForeground(Color.WHITE);

        removeBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Rimuovere " + p.getNome() + "?",
                    "Conferma",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                Menu.removePiatto(p);
                loadPiatti();
            }
        });

        card.add(removeBtn, BorderLayout.SOUTH);

        return card;
    }
}