import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.text.JTextComponent;
class text extends JFrame implements ActionListener {
    static JTextField t1;
    static JTextField t2;
    static JFrame f;
    static JButton b, b1;
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
        
        b = new JButton("Submit");
        b1 = new JButton("Clear");
         //add action to button

//        t2.addKeyListener(new text());
  
        text te = new text();
  
        t1 = new JTextField(16);
        t2 = new JTextField(16);
  
        JPanel p = new JPanel();
 
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(b);
        p.add(b1);
       
        f.add(p);
        f.setSize(300, 300);
        f.show();
        
        b.addActionListener(new text());
//        b1.addActionListener(new text());
        t2.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
		           String value = t2.getText();
//		           int l = value.length();
		           if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9'|| e.getKeyChar()==(char)8) {
		              t2.setEditable(true);
//		              l2.setText("");
		           } else {
		              t2.setEditable(false);
		              l2.setText("* Enter only numeric digits(0-9)");
		           }
			}
		}); 
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
				t1.setText("");
				t2.setText("");
                //textfield.setText(null); //or use this
            }
        });
        
    }
    public void actionPerformed(ActionEvent e)
    {
    	String textFieldValue = t1.getText();
        	Random r = new Random();
        	int upperBound = 100;
        	int random = r.nextInt(upperBound);
            f=new JFrame();  
			JOptionPane.showMessageDialog(f,"The chances of winning of "+textFieldValue+" is "+String.valueOf(random)+" %");
    }

}
