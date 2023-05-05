package GUI;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class HabitacionDesdeArchivo extends JFrame implements ActionListener {
    private Color bBColor=new Color(Integer.parseInt("2C7873",16));
    private Color BColor=new Color(0x763626);
    private Color Ctexto = new Color(0xFFF9F3);
    private Color BRColor = new Color(0x021C1E);
    private Font garamond = new Font("Garamond", Font.PLAIN, 20);
    private Font Title=new Font("Garamond", Font.BOLD, 35);
    public HabitacionDesdeArchivo (){
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize( new Dimension( 550, 680) );
        ventana.setTitle("Crear Nuevas Habitaciones");
        ventana.getContentPane().setBackground(bBColor);
        ventana.setLayout( null);
        ventana.setVisible(true);
        ventana.setResizable(false);  
        
        PanelGraficos estetico=new PanelGraficos();
        JLabel titulo = new JLabel("Crear Habitaciones Desde Archivo");
        titulo.setFont(Title);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Ctexto); 
        titulo.setBackground(bBColor);
        titulo.setBounds(20, 20, 510, 50);
        
        JLabel rutaFile = new JLabel("Ruta Archivo:");
        rutaFile.setFont(garamond);
        rutaFile.setHorizontalAlignment(SwingConstants.RIGHT);
        rutaFile.setForeground(Ctexto); 
        rutaFile.setBackground(bBColor);
        rutaFile.setBounds(20, 100, 120, 30);
        JTextField RutaParametro = new  JTextField( "" );
        RutaParametro.setBounds(155, 100, 370, 20);
        RutaParametro.setForeground(Ctexto); 
        RutaParametro.setBackground(bBColor);

        JButton boton1 = new JButton("Cargar Informacion");
        boton1.setBackground(BColor);
        boton1.setFont(garamond);
        boton1.setForeground(Ctexto);
        boton1.setBounds(150, 130, 250, 30); 
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JLabel titulo1 = new JLabel("Crear Habitaciones Desde Archivo");
        titulo1.setFont(garamond);
        titulo1.setHorizontalAlignment(SwingConstants.CENTER);
        titulo1.setForeground(Ctexto); 
        titulo1.setBackground(bBColor);
        titulo1.setBounds(20, 190, 490, 30);


        JButton boton2 = new JButton("Crear Habitaciones");
        boton2.setBackground(BColor);
        boton2.setFont(garamond);
        boton2.setForeground(Ctexto);
        boton2.setBounds(150, 600, 250, 30); 
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        ventana.add(titulo);
        ventana.add(rutaFile);
        ventana.add(RutaParametro);
        ventana.add(boton1);
        ventana.add(titulo1);
        ventana.add(boton2);
        ventana.add(estetico);
    }
    private class PanelGraficos extends JPanel {
        public PanelGraficos() {
            setSize(550, 680);
            this.setBackground(bBColor);
        }
        
        public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(BRColor);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(20, 80, 510, 90);
        Rectangle2D.Double rect2 = new Rectangle2D.Double(20, 180, 510, 410);
        g2d.setColor(BRColor);
        g2d.fill(rect1);
        g2d.fill(rect2);
    }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
