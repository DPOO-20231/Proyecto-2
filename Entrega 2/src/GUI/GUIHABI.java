package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import GUI.GUIHABIFILE;




public class GUIHABI extends JFrame implements ActionListener{
	public GUIHABI() {
		JFrame ventana = new JFrame();
        Color bBColor=new Color(Integer.parseInt("2C7873",16));
		Color BColor=new Color(0x763626);
		Color Ctexto = new Color(0xFFF9F3);
		Font garamond = new Font("Garamond", Font.PLAIN, 20);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize( new Dimension( 820, 700 ) );
		ventana.setTitle("Opciones Habitacion");
		ventana.setBackground(bBColor);
        ventana.getContentPane().setBackground(bBColor);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        ventana.setLayout( gridbag );
        ventana.setVisible(true);
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
		JLabel titulo = new JLabel("¿Qué quieres hacer con las Habitaciones?");
		titulo.setFont(garamond);
		titulo.setForeground(Ctexto); 
        titulo.setBackground(bBColor);
        gridbag.setConstraints( titulo,gbc );
        ventana.add(titulo);

		JButton boton1 = new JButton("Crear mediante Archivo");
        boton1.setBackground(BColor);
        boton1.setFont(garamond);
        boton1.setForeground(Ctexto);
        boton1.setBounds(100, 160, 445, 108); 
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
                new GUIHABIFILE();
                new GUIHABI();
            }
        });

        JButton boton2 = new JButton("Crear Manualmente");
        boton2.setContentAreaFilled(false);
        boton2.setBackground(BColor);
        boton2.setFont(garamond);
        boton2.setForeground(Ctexto);
        boton2.setBounds(100, 280, 445, 108); 
        
        JButton boton3 = new JButton("Modificar Habitacion");
        boton3.setContentAreaFilled(false);
        boton3.setBackground(BColor);
        boton3.setFont(garamond);
        boton3.setForeground(Ctexto);
        boton3.setBounds(100, 400, 445, 108); 

        JButton boton4 = new JButton("Consultar Habitacion");
        boton4.setContentAreaFilled(false);
        boton4.setBackground(BColor);
        boton4.setFont(garamond);
        boton4.setForeground(Ctexto);
        boton4.setBounds(100, 520, 445, 108); 


        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);
        ventana.add(boton4);
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
        new GUIHABI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
