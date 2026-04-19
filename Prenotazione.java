package Resturante;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.URL;

public class ModificaPiatti extends JFrame {

    private JPanel listPanel;
    private JPanel editPanel;

    private JTextField nameField, priceField, imgField;
    private JTextArea descArea;
    private JComboBox<String> categoryBox;

    private Piatto selectedPiatto;
    private JButton annullaBtn;

    public ModificaPiatti() {
        super("Modifica Piatti");

        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2));

        listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(0, 1, 10, 10));

        JScrollPane scroll = new JScrollPane(listPanel);

        editPanel = new JPanel();
        editPanel.setLayout(null);
        editPanel.setVisible(false);

        add(scroll);
        add(editPanel);

        buildEditPanel();
        loadPiatti();

        setVisible(true);
    }

    private void loadPiatti() {
        listPanel.removeAll();

        for (Piatto p : Menu.getMenu()) {
            listPanel.add(createCard(p));
        }

        listPanel.revalidate();
        listPanel.repaint();
    }

    private JPanel createCard(Piatto p) {

        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // 🔥 FIXED IMAGE LOADING (same as RimovePiatti)
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
            imgLabel.setText("No Image");
            imgLabel.setOpaque(true);
            imgLabel.setBackground(Color.LIGHT_GRAY);
        }

        JLabel name = new JLabel(p.getNome(), SwingConstants.CENTER);
        name.setFont(new Font("Arial", Font.BOLD, 14));

        JButton modifyBtn = new JButton("Modify");

        modifyBtn.addActionListener(e -> openEditPanel(p));

        JPanel bottom = new JPanel(new GridLayout(2, 1));
        bottom.add(name);
        bottom.add(modifyBtn);

        card.add(imgLabel, BorderLayout.CENTER);
        card.add(bottom, BorderLayout.SOUTH);

        return card;
    }

    private void buildEditPanel() {

        categoryBox = new JComboBox<>(new String[]{
            "Sushi", "Sashimi", "Ramen", "Udon", "Soba"
        });
        categoryBox.setBounds(50, 70, 200, 25);
        editPanel.add(categoryBox);

        nameField = new JTextField();
        nameField.setBounds(50, 110, 200, 25);
        editPanel.add(nameField);

        priceField = new JTextField();
        priceField.setBounds(50, 150, 200, 25);
        editPanel.add(priceField);

        imgField = new JTextField();
        imgField.setBounds(50, 190, 200, 25);
        editPanel.add(imgField);

        descArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(descArea);
        scroll.setBounds(50, 230, 250, 100);
        editPanel.add(scroll);

        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(50, 350, 100, 30);
        editPanel.add(saveBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(160, 350, 100, 30);
        editPanel.add(cancelBtn);

        
        annullaBtn = new JButton("Annulla");
annullaBtn.setFont(new Font("Arial", Font.BOLD, 18));
annullaBtn.setBackground(Color.RED);
annullaBtn.setBounds(270, 350, 100, 30);
annullaBtn.setForeground(Color.WHITE);
editPanel.add(annullaBtn);


        saveBtn.addActionListener(e -> {

            if (selectedPiatto != null) {

                selectedPiatto.setNome(nameField.getText());
                selectedPiatto.setCategoria((String) categoryBox.getSelectedItem());
                selectedPiatto.setPrezzo(Integer.parseInt(priceField.getText()));
                selectedPiatto.setImg(imgField.getText());
                selectedPiatto.setDescrizione(descArea.getText());

                JOptionPane.showMessageDialog(this, "Updated!");

                loadPiatti();
                editPanel.setVisible(false);
            }
        });
        
        saveBtn.addActionListener(e -> {
    this.dispose();               
});
        

        cancelBtn.addActionListener(e -> editPanel.setVisible(false));
    }

    private void openEditPanel(Piatto p) {

        selectedPiatto = p;

        nameField.setText(p.getNome());
        priceField.setText(String.valueOf(p.getPrezzo()));
        imgField.setText(p.getImg());
        descArea.setText(p.getDescrizione());
        categoryBox.setSelectedItem(p.getCategoria());

        editPanel.setVisible(true);
    }
}