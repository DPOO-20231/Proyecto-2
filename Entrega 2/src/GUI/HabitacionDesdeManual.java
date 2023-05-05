package GUI;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HabitacionDesdeManual extends JFrame implements ActionListener{
    private Color bBColor=new Color(Integer.parseInt("2C7873",16));
    private Color BColor=new Color(0x763626);
    private Color Ctexto = new Color(0xFFF9F3);
    private Color BRColor = new Color(0x021C1E);
    private Font garamond = new Font("Garamond", Font.PLAIN, 20);
    private Font Title=new Font("Garamond", Font.BOLD, 35);

    public HabitacionDesdeManual(){
    JFrame ventana = new JFrame();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize( new Dimension( 550, 680) );
    ventana.setTitle("Crear Nueva Habitacion");
    ventana.getContentPane().setBackground(bBColor);
    ventana.setLayout( null);
    ventana.setVisible(true);
    ventana.setResizable(false);

    JLabel titulo = new JLabel("Crear Habitacion");
    titulo.setFont(Title);
    titulo.setHorizontalAlignment(SwingConstants.CENTER);
    titulo.setForeground(Ctexto); 
    titulo.setBackground(bBColor);
    titulo.setBounds(20, 20, 510, 50); 

    JLabel ID = new JLabel("ID:");
    ID.setFont(garamond);
    ID.setHorizontalAlignment(SwingConstants.RIGHT);
    ID.setForeground(Ctexto); 
    ID.setBackground(bBColor);
    ID.setBounds(30, 90, 115, 40);
    JTextField IDParametro = new  JTextField( "" );
    IDParametro.setBounds(155, 100, 95, 20);
    IDParametro.setForeground(Ctexto); 
    IDParametro.setBackground(bBColor);

    JLabel Tipo= new JLabel("Tipo:");
    Tipo.setFont(garamond);
    Tipo.setHorizontalAlignment(SwingConstants.RIGHT);
    Tipo.setForeground(Ctexto); 
    Tipo.setBackground(bBColor);
    Tipo.setBounds(30, 130, 115, 40);
    String[] Tipos = {"estándar", "suite","suite doble"};
    JComboBox<String> TipoParametro = new JComboBox<>(Tipos);
    TipoParametro.setBounds(155, 140, 95, 20);
    TipoParametro.setForeground(BRColor); 
    Tipo.setBackground(bBColor);
    TipoParametro.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String TipoHabitacion = (String) TipoParametro.getSelectedItem();
        }
    });

    JLabel Ubicacion= new JLabel("Ubicacion:");
    Ubicacion.setFont(garamond);
    Ubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
    Ubicacion.setForeground(Ctexto); 
    Ubicacion.setBackground(bBColor);
    Ubicacion.setBounds(30, 170, 115, 40);
    JTextField UbicacionParametro = new  JTextField( "" );
    UbicacionParametro.setBounds(155, 180, 95, 20);
    UbicacionParametro.setForeground(Ctexto); 
    UbicacionParametro.setBackground(bBColor);

    JLabel Capacidad= new JLabel("Capacidad:");
    Capacidad.setFont(garamond);
    Capacidad.setHorizontalAlignment(SwingConstants.RIGHT);
    Capacidad.setForeground(Ctexto); 
    Capacidad.setBackground(bBColor);
    Capacidad.setBounds(30, 220, 115, 40);
    JTextField CapacidadParametro = new  JTextField( "" );
    CapacidadParametro.setBounds(155, 230, 95, 20);
    CapacidadParametro.setForeground(Ctexto); 
    CapacidadParametro.setBackground(bBColor);
    
    JLabel Caracteristicas= new JLabel("Caracteristicas");
    Caracteristicas.setFont(garamond);
    Caracteristicas.setHorizontalAlignment(SwingConstants.CENTER);
    Caracteristicas.setForeground(Ctexto); 
    Caracteristicas.setBackground(bBColor);
    Caracteristicas.setBounds(290, 90, 230, 40);
    JCheckBox Balcon = new JCheckBox("Balcon");
    Balcon.setFont(garamond);
    Balcon.setForeground(Ctexto); 
    Balcon.setBackground(BRColor);
    Balcon.setBounds(290, 130, 200, 30);
    JCheckBox Vista = new JCheckBox("Vista");
    Vista.setFont(garamond);
    Vista.setForeground(Ctexto); 
    Vista.setBackground(BRColor);
    Vista.setBounds(290, 170, 200, 30);
    JCheckBox Cocina = new JCheckBox("Cocina");
    Cocina.setFont(garamond);
    Cocina.setForeground(Ctexto); 
    Cocina.setBackground(BRColor);
    Cocina.setBounds(290, 210, 200, 30);
    

    JLabel TitleCama= new JLabel("Caracteristicas Camas");
    TitleCama.setFont(garamond);
    TitleCama.setHorizontalAlignment(SwingConstants.CENTER);
    TitleCama.setForeground(Ctexto); 
    TitleCama.setBackground(bBColor);
    TitleCama.setBounds(30, 300, 280, 40);

    JLabel TamañoCama= new JLabel("Tamaño:");
    TamañoCama.setFont(garamond);
    TamañoCama.setHorizontalAlignment(SwingConstants.RIGHT);
    TamañoCama.setForeground(Ctexto); 
    TamañoCama.setBackground(bBColor);
    TamañoCama.setBounds(30, 330, 115, 30);
    String[] Size = {"Sencilla", "Soble","Queen", "King"};
    JComboBox<String> TipoSize = new JComboBox<>(Size);
    TipoSize.setBounds(155, 340, 95, 20);
    TipoSize.setForeground(BRColor); 
    TipoSize.setBackground(bBColor);

    JLabel CapacidadCama= new JLabel("Capacidad:");
    CapacidadCama.setFont(garamond);
    CapacidadCama.setHorizontalAlignment(SwingConstants.RIGHT);
    CapacidadCama.setForeground(Ctexto); 
    CapacidadCama.setBackground(bBColor);
    CapacidadCama.setBounds(30, 380, 115, 30);
    JTextField SizeNumCama = new  JTextField( "" );
    SizeNumCama.setBounds(155, 390, 95, 20);
    SizeNumCama.setForeground(Ctexto); 
    SizeNumCama.setBackground(bBColor);

    JLabel TipoCama= new JLabel("Tipo Cama:");
    TipoCama.setFont(garamond);
    TipoCama.setHorizontalAlignment(SwingConstants.RIGHT);
    TipoCama.setForeground(Ctexto); 
    TipoCama.setBackground(bBColor);
    TipoCama.setBounds(30, 440, 115, 30);
    String[] TypeCama= {"Individual", "Grupal"};
    JComboBox<String> TipoCama1 = new JComboBox<>(TypeCama);
    TipoCama1.setBounds(155, 450, 95, 20);
    TipoCama1.setForeground(BRColor); 
    TipoCama1.setBackground(bBColor);

    JButton boton1 = new JButton("Guardar");
    boton1.setBackground(BColor);
    boton1.setFont(garamond);
    boton1.setForeground(Ctexto);
    boton1.setBounds(30, 480, 280, 30); 
    boton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ventana.dispose();
                       
        }
    });

    JButton boton2 = new JButton("Guardar, Agregar Nueva Cama");
    boton2.setBackground(BColor);
    boton2.setFont(garamond);
    boton2.setForeground(Ctexto);
    boton2.setBounds(30, 520, 280, 30); 
    boton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ventana.dispose();
        }
    });

    JLabel Precio= new JLabel("Precio");
    Precio.setFont(garamond);
    Precio.setHorizontalAlignment(SwingConstants.CENTER);
    Precio.setForeground(Ctexto); 
    Precio.setBackground(bBColor);
    Precio.setBounds(340, 300, 180, 40);
    JTextField PrecioT = new  JTextField( "$ " );
    PrecioT.setBounds(340, 400, 180, 40);
    PrecioT.setForeground(Ctexto); 
    PrecioT.setBackground(bBColor);
    PrecioT.setEditable(false);

    JButton boton3 = new JButton("Crear Habitacion");
    boton3.setBackground(BColor);
    boton3.setFont(garamond);
    boton3.setForeground(Ctexto);
    boton3.setBounds(150, 600, 250, 30); 
    boton3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        }
    });
    PanelGraficos estetico=new PanelGraficos();
    
    ventana.add(titulo);
    ventana.add(ID);
    ventana.add(IDParametro);
    ventana.add(Tipo);
    ventana.add(TipoParametro);
    ventana.add(Ubicacion);
    ventana.add(UbicacionParametro);
    ventana.add(Capacidad);
    ventana.add(CapacidadParametro);
    ventana.add(Caracteristicas);
    ventana.add(Balcon);
    ventana.add(Vista);
    ventana.add(Cocina);
    ventana.add(TitleCama);
    ventana.add(TamañoCama);
    ventana.add(TipoSize);
    ventana.add(TipoCama);
    ventana.add(TipoCama1);
    ventana.add(CapacidadCama);
    ventana.add(SizeNumCama);
    ventana.add(Precio);
    ventana.add(PrecioT);
    ventana.add(boton1);
    ventana.add(boton2);
    ventana.add(boton3);
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
    Rectangle2D.Double rect1 = new Rectangle2D.Double(10, 80, 260, 200);
    Rectangle2D.Double rect2 = new Rectangle2D.Double(280, 80, 250, 200);
    Rectangle2D.Double rect3 = new Rectangle2D.Double(10, 290, 310, 300);
    Rectangle2D.Double rect4 = new Rectangle2D.Double(330, 290, 200, 300);
    g2d.setColor(BRColor);
    g2d.fill(rect1);
    g2d.fill(rect2);
    g2d.fill(rect3);
    g2d.fill(rect4);
}
}



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
