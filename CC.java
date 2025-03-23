import javax.swing.*; 
import java.awt.event.*; 

public class CC {
    private static final double EXCHANGE_RATE = 82.50; // Updated exchange rate
    
    public static void converter() { 
        JFrame f = new JFrame("Currency Converter"); 
        JLabel l1, l2; 
        JTextField t1, t2; 
        JButton b1, b2, b3; 

        l1 = new JLabel("Rupees:"); 
        l1.setBounds(20, 40, 80, 30); 
        l2 = new JLabel("Dollars:"); 
        l2.setBounds(170, 40, 80, 30); 

        t1 = new JTextField("0"); 
        t1.setBounds(100, 40, 80, 30); 
        t2 = new JTextField("0"); 
        t2.setBounds(260, 40, 80, 30); 

        b1 = new JButton("Convert to USD"); 
        b1.setBounds(50, 100, 140, 30); 
        b2 = new JButton("Convert to INR"); 
        b2.setBounds(200, 100, 140, 30); 
        b3 = new JButton("Close"); 
        b3.setBounds(150, 160, 80, 30); 

        b1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                try {
                    double inr = Double.parseDouble(t1.getText()); 
                    double usd = inr / EXCHANGE_RATE; 
                    t2.setText(String.format("%.2f", usd)); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Invalid input! Please enter a valid number.");
                }
            } 
        }); 

        b2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                try {
                    double usd = Double.parseDouble(t2.getText()); 
                    double inr = usd * EXCHANGE_RATE; 
                    t1.setText(String.format("%.2f", inr)); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Invalid input! Please enter a valid number.");
                }
            } 
        }); 

        b3.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                f.dispose(); 
            } 
        }); 

        f.addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent e) { 
                System.exit(0); 
            } 
        }); 

        f.add(l1); 
        f.add(t1); 
        f.add(l2); 
        f.add(t2); 
        f.add(b1); 
        f.add(b2); 
        f.add(b3); 
        f.setLayout(null); 
        f.setSize(400, 250); 
        f.setVisible(true); 
    } 

    public static void main(String args[]) { 
        converter(); 
    } 
}