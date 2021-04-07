import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
class text extends JFrame implements ActionListener {
    static JTextField t1;
    static JTextField t2;
    static JFrame f;
    static JButton b;
    static JLabel l1;
    static JLabel l2;
    text()
    {
    }
    public static void main(String[] args)
    {
        f = new JFrame("Task");
        l1 = new JLabel("Enter the name");
        l2 = new JLabel("Enter the age");
        
        b = new JButton("submit");
        b.addActionListener(new text()); //add action to button
  
        text te = new text();
  
        t1 = new JTextField(16);
        t2 = new JTextField(16);
  
        JPanel p = new JPanel();
 
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(b);
       
        f.add(p);
        f.setSize(300, 300);
        f.show();
    }
  
    public void actionPerformed(ActionEvent e)
    {
        	Random r = new Random();
        	int upperBound = 100;
        	int random = r.nextInt(upperBound);
            f=new JFrame();  
            JOptionPane.showMessageDialog(f,"The Random number is \n"+String.valueOf(random));
    }
}