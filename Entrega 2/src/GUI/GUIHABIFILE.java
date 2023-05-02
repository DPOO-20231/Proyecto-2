package GUI;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUIHABIFILE extends JFrame {
    public GUIHABIFILE (){
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize( new Dimension( 1060, 950 ) );
        ventana.setLayout(null);
		ventana.setTitle("Crear Habitaciones Desde Archivo");
		ventana.setBackground(new Color(0x2C7873));
        ventana.setLayout(null); 
        ventana.setVisible(true);
        Color BColor=new Color(0x763626);
		Color Ctexto = new Color(0xFFF9F3);
		Font garamond = new Font("Garamond", Font.PLAIN, 12);
		Border bordeExt = new LineBorder(BColor, 1);
        Border bordeInt = BorderFactory.createEmptyBorder(5, 15, 5, 15); 

        Rectangle2D.Double rect1=new Rectangle2D.Double(0, 0, 400, 400);

        JLabel titulo = new JLabel("Crear Habitaciones Desde Archivo", SwingConstants.CENTER);
		titulo.setFont(new Font("Garamond", Font.BOLD, 20));
		titulo.setForeground(Ctexto); 
        titulo.setBounds(50, 100, 100, 30);
        

    }
}
