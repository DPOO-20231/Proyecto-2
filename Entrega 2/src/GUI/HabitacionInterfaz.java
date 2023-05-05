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
import GUI.*;




public class HabitacionInterfaz extends JFrame implements ActionListener{
	public HabitacionInterfaz() {
		JFrame ventana = new JFrame();
        Color bBColor=new Color(Integer.parseInt("2C7873",16));
		Color BColor=new Color(0x763626);
		Color Ctexto = new Color(0xFFF9F3);
		Font garamond = new Font("Garamond", Font.PLAIN, 20);
        Font Title=new Font("Garamond", Font.BOLD, 35);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize( new Dimension( 450, 400 ) );
		ventana.setTitle("Opciones Habitacion");
        ventana.getContentPane().setBackground(bBColor);
        ventana.setLayout( null);
        ventana.setVisible(true);
        ventana.setResizable(false);
        
       
        
		JLabel titulo = new JLabel("¿Qué quieres hacer con");
		titulo.setFont(Title);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Ctexto); 
        titulo.setBackground(bBColor);
        titulo.setBounds(20, 20, 410, 50); 

        JLabel titulo1 = new JLabel("las Habitaciones?");
		titulo1.setFont(Title);
        titulo1.setHorizontalAlignment(SwingConstants.CENTER);
		titulo1.setForeground(Ctexto); 
        titulo1.setBackground(bBColor);
        titulo1.setBounds(50, 80, 350, 50); 
        

		JButton boton1 = new JButton("Crear mediante Archivo");
        boton1.setBackground(BColor);
        boton1.setFont(garamond);
        boton1.setForeground(Ctexto);
        boton1.setBounds(100, 160, 250, 40); 
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
                new HabitacionDesdeArchivo();
                
            }
        });

        JButton boton2 = new JButton("Crear Manualmente");
        boton2.setBackground(BColor);
        boton2.setFont(garamond);
        boton2.setForeground(Ctexto);
        boton2.setBounds(100, 210, 250, 40); 
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
                new HabitacionDesdeManual(); 
            }
        });
        
        JButton boton3 = new JButton("Modificar Habitacion");
        boton3.setBackground(BColor);
        boton3.setFont(garamond);
        boton3.setForeground(Ctexto);
        boton3.setBounds(100, 260, 250, 40); 
        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModificarHabitacion(ventana);
            }
        });

        JButton boton4 = new JButton("Consultar Habitacion");
        boton4.setBackground(BColor);
        boton4.setFont(garamond);
        boton4.setForeground(Ctexto);
        boton4.setBounds(100, 310, 250, 40); 
        boton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsultarHabitacion(ventana);
            }
        });

        ventana.add(titulo);
        ventana.add(titulo1);
        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);
        ventana.add(boton4);
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
        new HabitacionInterfaz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
