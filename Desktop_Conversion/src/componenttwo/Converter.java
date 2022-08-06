package componenttwo;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Converter {

	public static void main(String[] args) {
   CurrencyPanel frame=new CurrencyPanel();
		 //  Currency frame=new Currency();

    
    frame.setBackground(new Color(128, 128, 128));
    frame.setForeground(SystemColor.desktop);
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/munak/OneDrive/Documents/MyWorkspace/ComponentTwo/src/componenttwo/main.png"));
    frame.setTitle("WELCOME TO THE CURRENCY CONVERTER");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(100, 100, 594, 331);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);
	}

}

