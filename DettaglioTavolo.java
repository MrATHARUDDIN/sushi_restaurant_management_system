package Resturante;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AggiungiPiatti extends JFrame implements ActionListener {

    private JPanel panel;

    private JLabel imgLabel, categoryLabel, nameLabel, priceLabel, descLabel, imgUrlLabel;
    private JButton importaBtn, eliminaBtn, salvaBtn, annullaBtn;
    private JTextField nameField, priceField, imgField;
    private JTextArea descArea;
    private JComboBox<String> categoryBox;

    public AggiungiPiatti() {
        super("Add Item page");

        panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        setBounds(500, 200, 750, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // IMAGE PREVIEW
        imgLabel = new JLabel("IMG", SwingConstants.CENTER);
        imgLabel.setBounds(100, 20, 300, 120);
        imgLabel.setOpaque(true);
        imgLabel.setBackground(new Color(102, 204, 102));
        imgLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(imgLabel);

        // IMAGE URL
        imgUrlLabel = new JLabel("Image URL");
        imgUrlLabel.setBounds(50, 160, 100, 25);
        panel.add(imgUrlLabel);

        imgField = new JTextField();
        imgField.setBounds(150, 160, 300, 25);
        panel.add(imgField);

        importaBtn = new JButton("Importa");
        importaBtn.setBounds(120, 200, 100, 30);
        importaBtn.setBackground(Color.GREEN);
        importaBtn.addActionListener(this);
        panel.add(importaBtn);

        eliminaBtn = new JButton("Elimina");
        eliminaBtn.setBounds(260, 200, 100, 30);
        eliminaBtn.setBackground(Color.RED);
        eliminaBtn.setForeground(Color.WHITE);
        eliminaBtn.addActionListener(this);
        panel.add(eliminaBtn);

        // CATEGORY
        categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(50, 250, 100, 25);
        panel.add(categoryLabel);

        categoryBox = new JComboBox<>(new String[]{
            "Sushi",
            "Sashimi",
            "Ramen",
            "Udon",
            "Soba",
            "Traditional Japanese Rice Dishes",
            "Traditional Japanese Desserts",
            "Traditional Japanese Alcoholic Drinks"
        });

        categoryBox.setBounds(150, 250, 200, 25);
        panel.add(categoryBox);

        // NAME
        nameLabel = new JLabel("Nome");
        nameLabel.setBounds(50, 290, 100, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 290, 200, 25);
        panel.add(nameField);

        // PRICE
        priceLabel = new JLabel("Price");
        priceLabel.setBounds(50, 330, 100, 25);
        panel.add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(150, 330, 200, 25);
        panel.add(priceField);

        // DESCRIPTION (TEXT AREA)
        descLabel = new JLabel("Descrizione");
        descLabel.setBounds(50, 370, 100, 25);
        panel.add(descLabel);

        descArea = new JTextArea();
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(descArea);
        scrollPane.setBounds(150, 370, 300, 80);
        panel.add(scrollPane);

        // BUTTONS
        salvaBtn = new JButton("Salva");
        salvaBtn.setBounds(100, 480, 100, 30);
        salvaBtn.setBackground(Color.GREEN);
        salvaBtn.addActionListener(this);
        panel.add(salvaBtn);

        annullaBtn = new JButton("Annulla");
        annullaBtn.setBounds(250, 480, 100, 30);
        annullaBtn.setBackground(Color.RED);
        annullaBtn.setForeground(Color.WHITE);
        annullaBtn.addActionListener(this);
        panel.add(annullaBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == importaBtn) {
            try {
                URL url = new URL(imgField.getText());

                Image image = ImageIO.read(url);

                if (image == null) {
                    JOptionPane.showMessageDialog(this, "Immagine non trovata!");
                    return;
                }

                Image scaled = image.getScaledInstance(
                        imgLabel.getWidth(),
                        imgLabel.getHeight(),
                        Image.SCALE_SMOOTH
                );

                imgLabel.setIcon(new ImageIcon(scaled));
                imgLabel.setText("");
                imgLabel.setBackground(null);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Errore caricamento immagine!");
            }
        }

        if (e.getSource() == eliminaBtn) {
            imgLabel.setIcon(null);
            imgLabel.setText("IMG");
        }

if (e.getSource() == salvaBtn) {

    try {
        String category = (String) categoryBox.getSelectedItem();
        String nome = nameField.getText();
        String descrizione = descArea.getText();
        String imgUrl = imgField.getText();

        double prezzo = Double.parseDouble(priceField.getText());

        Menu.addPiatto(
            new Piatto(nome, category, (int) prezzo, descrizione, imgUrl)
        );

        JOptionPane.showMessageDialog(this, "Piatto aggiunto con successo!");

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Prezzo non valido!");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Errore durante il salvataggio!");
    }
}

        if (e.getSource() == annullaBtn) {
            new AdminFrame("Admin page");
            this.dispose();
        }
    }
}
