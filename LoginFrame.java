package Resturante;

import javax.swing.*;

public class FeedbackFrame extends JFrame {

    JTextField nome;
    JComboBox<String> comboBox;
    JTextArea experienceArea;
    JButton postBtn, cancelBtn;
    JComboBox<String> ratingBox;

    public FeedbackFrame() {
        setTitle("Consegna a Domicilio");
        setBounds(500, 200, 750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("int.jpg"));
        JLabel background = new JLabel(icon);
        setContentPane(background);
        background.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 750, 750);
        panel.setOpaque(false);

        nome = new JTextField("Nome");
        nome.setBounds(50, 30, 150, 30);
        panel.add(nome);

        String[] options = {"Menu Generale", "All You Can eat"};
        comboBox = new JComboBox<>(options);
        comboBox.setBounds(220, 30, 150, 30);
        panel.add(comboBox);

        experienceArea = new JTextArea("Experience");
        JScrollPane scroll = new JScrollPane(experienceArea);
        scroll.setBounds(50, 80, 320, 120);
        panel.add(scroll);

        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(50, 220, 100, 30);
        panel.add(ratingLabel);

        String[] ratings = {"⭐", "⭐⭐", "⭐⭐⭐", "⭐⭐⭐⭐", "⭐⭐⭐⭐⭐"};
        ratingBox = new JComboBox<>(ratings);
        ratingBox.setBounds(120, 220, 150, 30);
        panel.add(ratingBox);

        postBtn = new JButton("Post");
        postBtn.setBounds(80, 300, 100, 30);
        postBtn.addActionListener(e -> {

            String nomeText = nome.getText();
            String menu = (String) comboBox.getSelectedItem();
            String esperienza = experienceArea.getText();
            int rating = ratingBox.getSelectedIndex() + 1;

            Feedback f = new Feedback(nomeText, menu, esperienza, rating);

            FeedbackManager.addFeedback(f);

            JOptionPane.showMessageDialog(this,
                    "Feedback salvato!\nRating: " + rating + " stelle");

            new UserPage();
            this.dispose();
        });

        panel.add(postBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(220, 300, 100, 30);
        cancelBtn.addActionListener(e -> {
            new UserPage();
            this.dispose();
        });
        panel.add(cancelBtn);

        background.add(panel);

        setVisible(true);
    }

}
