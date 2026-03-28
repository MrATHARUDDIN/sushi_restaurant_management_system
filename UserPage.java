package Resturante;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserPage extends JFrame implements ActionListener {
    private JPanel userpage;
    private JButton prenotazione, feedback, consegnaDomicilio;
    private JLabel img;

    public UserPage() {
        // --- Frame & Panel Setup ---
        setTitle("Sushi User Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500, 200, 750, 750);

        userpage = new JPanel(null);
        add(userpage);

        prenotazione      = createButton("Prenotazione", 200);
        feedback          = createButton("Feedback", 300);
        consegnaDomicilio = createButton("Consegna a Domicilio", 400);

        userpage.add(prenotazione);
        userpage.add(feedback);
        userpage.add(consegnaDomicilio);

        ImageIcon icon = new ImageIcon(getClass().getResource("int.jpg"));
        img = new JLabel(icon);
        img.setBounds(0, 0, 750, 750);
        userpage.add(img);

        setVisible(true);
    }

    private JButton createButton(String text, int y) {
        RoundedButton btn = new RoundedButton(text, 40);
        btn.setBounds(215, y, 270, 75);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBackground(new Color(243, 156, 18));
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    class RoundedButton extends JButton {
        private int radius;
        
        public RoundedButton(String label, int radius) {
            super(label);
            this.radius = radius;
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            Color baseColor = getBackground();
            if (getModel().isPressed()) {
                g2.setColor(baseColor.darker().darker());
            } else if (getModel().isRollover()) {
                g2.setColor(baseColor.darker());
            } else {
                g2.setColor(baseColor);
            }

            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            super.paintComponent(g2);
            g2.dispose();
        }
    }
}
