package Resturante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Categoria extends JFrame implements ActionListener {

    private JPanel mainLayout;
    private JPanel grid;
    private JLabel titolo, background;
    private JButton annullaBtn;

    public Categoria(String Titolo) {
        super(Titolo);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(750, 750);

        URL bgUrl = getClass().getResource("int.jpg");
        if (bgUrl == null) {
            System.out.println("Background image not found!");
        }

        ImageIcon bgIcon = new ImageIcon(bgUrl);
        Image bgImg = bgIcon.getImage().getScaledInstance(750, 750, Image.SCALE_SMOOTH);
        background = new JLabel(new ImageIcon(bgImg));
        background.setLayout(new BorderLayout());
        setContentPane(background);

        // Main layout
        mainLayout = new JPanel(new BorderLayout(10, 10));
        mainLayout.setOpaque(false);

        // Title
        titolo = new JLabel("CATEGORIE", SwingConstants.CENTER);
        titolo.setFont(new Font("Arial", Font.BOLD, 40));
        titolo.setForeground(Color.WHITE);
        mainLayout.add(titolo, BorderLayout.NORTH);

        // Grid
        grid = new JPanel(new GridLayout(3, 3, 18, 18));
        grid.setOpaque(false);

        String[] labels = {
            "Sushi", "Sashimi", "Soup",
            "Ramen", "Soba", "Udon",
            "Mochi", "Sake", "Rice"
        };

        String[] images = {
            "sushitavola.jpg", "sashimi.jpg", "soup.jpg",
            "ramen.jpg", "soba.jpg", "udon.jpeg",
            "mochi.jpg", "sake.jpg", "rice.jpg"
        };

        for (int i = 0; i < labels.length; i++) {

            JButton btn = new JButton(labels[i]);

            // Safe image loading
            URL imgUrl = getClass().getResource(images[i]);
            if (imgUrl == null) {
                System.out.println("Image not found: " + images[i]);
            } else {
                ImageIcon icon = new ImageIcon(imgUrl);
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(img));
            }

            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setVerticalTextPosition(SwingConstants.BOTTOM);

            btn.setActionCommand(labels[i]);
            btn.addActionListener(this);
            
            
            annullaBtn = new JButton("Annulla");
            annullaBtn.setFont(new Font("Arial", Font.BOLD, 18));
            annullaBtn.setBackground(Color.RED);
            annullaBtn.setForeground(Color.WHITE);
            annullaBtn.addActionListener(this);

            grid.add(btn);
        }

        mainLayout.add(grid, BorderLayout.CENTER);
        mainLayout.add(annullaBtn, BorderLayout.SOUTH);
        background.add(mainLayout, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == annullaBtn){
            new homeFrame("Home");
                this.dispose();
        }
        
        String categoria = e.getActionCommand();

        switch (categoria) {
            case "Sushi":
                new sushiFrame("Sushi Frame");
                break;
            case "Sashimi":
                new Tavoli();
                break;
        }

        this.dispose();
    }
}
