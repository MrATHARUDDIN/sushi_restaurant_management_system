package Resturante;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prenotazione extends JFrame implements ActionListener {

    private JPanel prenotazione;
    private JButton conferma, scegliTavolo, annulla;
    private JTextField nome, cellulare; 
    private JSpinner data;
    private JLabel name, date, phoneNo, img;

    public Prenotazione(String Titolo) {
        super(Titolo);

        prenotazione = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        prenotazione.setLayout(null);
        add(prenotazione);
        setBounds(500, 200, 750, 750);

        name = new JLabel("Nome");
        name.setBounds(50, 40, 150, 40);
        name.setFont(new Font("Arial", Font.BOLD, 35));
        name.setForeground(Color.WHITE);
        prenotazione.add(name);

        nome = new JTextField();
        nome.setBounds(260, 40, 320, 40);
        nome.setFont(new Font("Arial", Font.PLAIN, 20));
        prenotazione.add(nome);
        
        date = new JLabel("Data");
        date.setBounds(50, 100, 150, 40);
        date.setFont(new Font("Arial", Font.BOLD, 35));
        date.setForeground(Color.WHITE);
        prenotazione.add(date);
        
        SpinnerDateModel dateModel = new SpinnerDateModel();
        dateModel.setStart(new java.util.Date());
        
        data = new JSpinner(dateModel); 
        
        JSpinner.DateEditor editor = new JSpinner.DateEditor(data, "dd/MM/yyyy");
        data.setEditor(editor);
        data.setBounds(260, 100, 320, 40); 
        data.setFont(new Font("Arial", Font.PLAIN, 18));
        prenotazione.add(data);
        
        phoneNo = new JLabel("<html>Numero di<br>Telefono</html>");
        phoneNo.setBounds(50, 160, 300, 80);
        phoneNo.setFont(new Font("Arial", Font.BOLD, 35));
        phoneNo.setForeground(Color.WHITE);
        prenotazione.add(phoneNo);

        cellulare = new JTextField();
        cellulare.setBounds(260, 180, 320, 40);
        cellulare.setFont(new Font("Arial", Font.PLAIN, 20));
        prenotazione.add(cellulare);
        
        scegliTavolo = new RoundedButton("Scegli Tavolo", 30);
        scegliTavolo.setBounds(150, 380, 450, 50);
        scegliTavolo.setBackground(new Color(243, 156, 18));
        scegliTavolo.setFont(new Font("Arial", Font.BOLD, 20));
        scegliTavolo.setForeground(Color.white);
        scegliTavolo.addActionListener(this); 
        prenotazione.add(scegliTavolo);

        conferma = new RoundedButton("Conferma", 30);
        conferma.setBounds(150, 450, 200, 50);
        conferma.setBackground(new Color(46, 204, 113));
        conferma.setFont(new Font("Arial", Font.BOLD, 20));
        conferma.setForeground(Color.white);
        conferma.addActionListener(this);
        prenotazione.add(conferma);

        annulla = new RoundedButton("Annulla", 30);
        annulla.setBounds(400, 450, 200, 50);
        annulla.setBackground(new Color(231, 76, 60));
        annulla.setFont(new Font("Arial", Font.BOLD, 20));
        annulla.setForeground(Color.white);
        annulla.addActionListener(this);
        prenotazione.add(annulla);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("int.jpg"));
        img = new JLabel(icon);
        img.setBounds(0, 0, 750, 750);
        prenotazione.add(img);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conferma) {
            java.util.Date selectedDate = (java.util.Date) data.getValue();
            new UserPage();
            this.dispose();
            String userNome = nome.getText();
            JOptionPane.showMessageDialog(this, "Grazie " + userNome + "!\nPrenotazione confermata per il: " + selectedDate);
        } else if (e.getSource() == annulla) {
            new UserPage();
            this.dispose(); 
        } else if (e.getSource() == scegliTavolo) {
           new Tavoli();
           this.dispose();
        }
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
            if (getModel().isPressed()) g2.setColor(baseColor.darker().darker());
            else if (getModel().isRollover()) g2.setColor(baseColor.darker());
            else g2.setColor(baseColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            super.paintComponent(g2);
            g2.dispose();
        }
    }
}