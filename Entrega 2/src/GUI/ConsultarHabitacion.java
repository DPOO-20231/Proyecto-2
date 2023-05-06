package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import modelo.PropertyManagementSystem;
public class ConsultarHabitacion extends JFrame implements ActionListener {
    private Color bBColor=new Color(Integer.parseInt("2C7873",16));
    private Color BColor=new Color(0x763626);
    private Color Ctexto = new Color(0xFFF9F3);
    private Color BRColor = new Color(0x021C1E);
    private Font garamond = new Font("Garamond", Font.PLAIN, 16);
    private Font Title=new Font("Garamond", Font.BOLD, 27);
    public ConsultarHabitacion(JFrame VentanaAnterior, PropertyManagementSystem PMS){
        VentanaAnterior.setVisible(false);
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize( new Dimension( 550, 680 ) );
		ventana.setTitle("Consultar Habitaciones");
        ventana.getContentPane().setBackground(bBColor);
        ventana.setLayout( null);
        ventana.setVisible(true);
        ventana.setResizable(false);
        PanelGraficos estetico=new PanelGraficos();

        JLabel titulo = new JLabel("Consultar Habitacion");
        titulo.setFont(Title);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Ctexto); 
        titulo.setBackground(bBColor);
        titulo.setBounds(10, 10, 510, 30); 

        JLabel ID = new JLabel("ID:");
        ID.setFont(garamond);
        ID.setHorizontalAlignment(SwingConstants.RIGHT);
        ID.setForeground(Ctexto); 
        ID.setBackground(bBColor);
        ID.setBounds(30, 50, 115, 30);
        JTextField IDParametro = new  JTextField( "" );
        IDParametro.setBounds(155, 60, 95, 20);
        IDParametro.setForeground(Ctexto); 
        IDParametro.setBackground(bBColor);
        
        JLabel Tipo= new JLabel("Tipo:");
        Tipo.setFont(garamond);
        Tipo.setHorizontalAlignment(SwingConstants.RIGHT);
        Tipo.setForeground(Ctexto); 
        Tipo.setBackground(bBColor);
        Tipo.setBounds(30, 80, 115, 30);
        JTextField TipoParametro= new  JTextField( "" );
        TipoParametro.setBounds(155, 90, 95, 20);
        TipoParametro.setForeground(Ctexto); 
        TipoParametro.setBackground(bBColor);
        TipoParametro.setEditable(false);
    
        JLabel Ubicacion= new JLabel("Ubicacion:");
        Ubicacion.setFont(garamond);
        Ubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
        Ubicacion.setForeground(Ctexto); 
        Ubicacion.setBackground(bBColor);
        Ubicacion.setBounds(30, 110, 115, 30);
        JTextField UbicacionParametro = new  JTextField( "" );
        UbicacionParametro.setBounds(155, 120, 95, 20);
        UbicacionParametro.setForeground(Ctexto); 
        UbicacionParametro.setBackground(bBColor);
        UbicacionParametro.setEditable(false);
    
        JLabel Capacidad= new JLabel("Capacidad:");
        Capacidad.setFont(garamond);
        Capacidad.setHorizontalAlignment(SwingConstants.RIGHT);
        Capacidad.setForeground(Ctexto); 
        Capacidad.setBackground(bBColor);
        Capacidad.setBounds(30, 140, 115, 30);
        JTextField CapacidadParametro = new  JTextField( "" );
        CapacidadParametro.setBounds(155, 150, 95, 20);
        CapacidadParametro.setForeground(Ctexto); 
        CapacidadParametro.setBackground(bBColor);
        CapacidadParametro.setEditable(false);
        
        JLabel Caracteristicas= new JLabel("Caracteristicas");
        Caracteristicas.setFont(garamond);
        Caracteristicas.setHorizontalAlignment(SwingConstants.CENTER);
        Caracteristicas.setForeground(Ctexto); 
        Caracteristicas.setBackground(bBColor);
        Caracteristicas.setBounds(290, 50, 230, 30);
        JCheckBox Balcon = new JCheckBox("Balcon");
        Balcon.setFont(garamond);
        Balcon.setForeground(Ctexto); 
        Balcon.setBackground(BRColor);
        Balcon.setBounds(290, 80, 200, 25);
        Balcon.setEnabled(false);
        JCheckBox Vista = new JCheckBox("Vista");
        Vista.setFont(garamond);
        Vista.setForeground(Ctexto); 
        Vista.setBackground(BRColor);
        Vista.setBounds(290, 105, 200, 25);
        Vista.setEnabled(false);
        JCheckBox Cocina = new JCheckBox("Cocina");
        Cocina.setFont(garamond);
        Cocina.setForeground(Ctexto); 
        Cocina.setBackground(BRColor);
        Cocina.setBounds(290, 130, 200, 25);
        Cocina.setEnabled(false);

        Balcon.setSelected(false);
        Vista.setSelected(false);
        Cocina.setSelected(true);

        JLabel titulo1 = new JLabel("Camas Disponibles en la Habitacion");
        titulo1.setFont(Title);
        titulo1.setHorizontalAlignment(SwingConstants.CENTER);
        titulo1.setForeground(Ctexto); 
        titulo1.setBackground(bBColor);
        titulo1.setBounds(20, 180, 510, 30); 


        JLabel TamañoCama= new JLabel("Tamaño:");
        TamañoCama.setFont(garamond);
        TamañoCama.setHorizontalAlignment(SwingConstants.RIGHT);
        TamañoCama.setForeground(Ctexto); 
        TamañoCama.setBackground(bBColor);
        TamañoCama.setBounds(20, 230, 105, 30);
        JTextField TipoSize = new  JTextField( "" );
        TipoSize.setBounds(135, 220, 115, 20);
        TipoSize.setForeground(Ctexto); 
        TipoSize.setBackground(bBColor);
        TipoSize.setEditable(false);

        JLabel CapacidadCama= new JLabel("Capacidad:");
        CapacidadCama.setFont(garamond);
        CapacidadCama.setHorizontalAlignment(SwingConstants.RIGHT);
        CapacidadCama.setForeground(Ctexto); 
        CapacidadCama.setBackground(bBColor);
        CapacidadCama.setBounds(20, 250, 105, 30);
        JTextField SizeNumCama = new  JTextField( "" );
        SizeNumCama.setBounds(135, 240, 115, 20);
        SizeNumCama.setForeground(Ctexto); 
        SizeNumCama.setBackground(bBColor);
        SizeNumCama.setEditable(false);

        JLabel TipoCama= new JLabel("Tipo Cama:");
        TipoCama.setFont(garamond);
        TipoCama.setHorizontalAlignment(SwingConstants.RIGHT);
        TipoCama.setForeground(Ctexto); 
        TipoCama.setBackground(bBColor);
        TipoCama.setBounds(20, 280, 105, 30);
        JTextField  TipoCama1 = new JTextField("");
        TipoCama1.setBounds(135, 290, 115, 20);
        TipoCama1.setForeground(BRColor); 
        TipoCama1.setBackground(bBColor);
        TipoCama1.setEditable(false);


        JLabel TamañoCama2= new JLabel("Tamaño:");
        TamañoCama2.setFont(garamond);
        TamañoCama2.setHorizontalAlignment(SwingConstants.RIGHT);
        TamañoCama2.setForeground(Ctexto); 
        TamañoCama2.setBackground(bBColor);
        TamañoCama2.setBounds(20, 350, 105, 30);
        JTextField TipoSize2 = new  JTextField( "" );
        TipoSize2.setBounds(135, 340, 115, 20);
        TipoSize2.setForeground(Ctexto); 
        TipoSize2.setBackground(bBColor);
        TipoSize2.setEditable(false);

        JLabel CapacidadCama2= new JLabel("Capacidad:");
        CapacidadCama2.setFont(garamond);
        CapacidadCama2.setHorizontalAlignment(SwingConstants.RIGHT);
        CapacidadCama2.setForeground(Ctexto); 
        CapacidadCama2.setBackground(bBColor);
        CapacidadCama2.setBounds(20, 380, 105, 30);
        JTextField SizeNumCama2 = new  JTextField( "" );
        SizeNumCama2.setBounds(135, 380, 115, 20);
        SizeNumCama2.setForeground(Ctexto); 
        SizeNumCama2.setBackground(bBColor);
        SizeNumCama2.setEditable(false);

        JLabel TipoCama2= new JLabel("Tipo Cama:");
        TipoCama2.setFont(garamond);
        TipoCama2.setHorizontalAlignment(SwingConstants.RIGHT);
        TipoCama2.setForeground(Ctexto); 
        TipoCama2.setBackground(bBColor);
        TipoCama2.setBounds(20, 410, 105, 30);
        JTextField  TipoCama12 = new JTextField("");
        TipoCama12.setBounds(135, 420, 115, 20);
        TipoCama12.setForeground(BRColor); 
        TipoCama12.setBackground(bBColor);
        TipoCama12.setEditable(false);

        JLabel TamañoCama3= new JLabel("Tamaño:");
        TamañoCama3.setFont(garamond);
        TamañoCama3.setHorizontalAlignment(SwingConstants.RIGHT);
        TamañoCama3.setForeground(Ctexto); 
        TamañoCama3.setBackground(bBColor);
        TamañoCama3.setBounds(285, 230, 105, 30);
        JTextField TipoSize3 = new  JTextField( "" );
        TipoSize3.setBounds(405, 220, 115, 20);
        TipoSize3.setForeground(Ctexto); 
        TipoSize3.setBackground(bBColor);
        TipoSize3.setEditable(false);

        JLabel CapacidadCama3= new JLabel("Capacidad:");
        CapacidadCama3.setFont(garamond);
        CapacidadCama3.setHorizontalAlignment(SwingConstants.RIGHT);
        CapacidadCama3.setForeground(Ctexto); 
        CapacidadCama3.setBackground(bBColor);
        CapacidadCama3.setBounds(285, 250, 105, 30);
        JTextField SizeNumCama3 = new  JTextField( "" );
        SizeNumCama3.setBounds(405, 240, 115, 20);
        SizeNumCama3.setForeground(Ctexto); 
        SizeNumCama3.setBackground(bBColor);
        SizeNumCama3.setEditable(false);

        JLabel TipoCama3= new JLabel("Tipo Cama:");
        TipoCama3.setFont(garamond);
        TipoCama3.setHorizontalAlignment(SwingConstants.RIGHT);
        TipoCama3.setForeground(Ctexto); 
        TipoCama3.setBackground(bBColor);
        TipoCama3.setBounds(285, 280, 105, 30);
        JTextField  TipoCama13 = new JTextField("");
        TipoCama13.setBounds(405, 290, 115, 20);
        TipoCama13.setForeground(BRColor); 
        TipoCama13.setBackground(bBColor);
        TipoCama13.setEditable(false);

        JLabel TamañoCama4= new JLabel("Tamaño:");
        TamañoCama4.setFont(garamond);
        TamañoCama4.setHorizontalAlignment(SwingConstants.RIGHT);
        TamañoCama4.setForeground(Ctexto); 
        TamañoCama4.setBackground(bBColor);
        TamañoCama4.setBounds(285, 350, 105, 30);
        JTextField TipoSize4 = new  JTextField( "" );
        TipoSize4.setBounds(405, 340, 115, 20);
        TipoSize4.setForeground(Ctexto); 
        TipoSize4.setBackground(bBColor);
        TipoSize4.setEditable(false);

        JLabel CapacidadCama4= new JLabel("Capacidad:");
        CapacidadCama4.setFont(garamond);
        CapacidadCama4.setHorizontalAlignment(SwingConstants.RIGHT);
        CapacidadCama4.setForeground(Ctexto); 
        CapacidadCama2.setBackground(bBColor);
        CapacidadCama4.setBounds(285, 380, 105, 30);
        JTextField SizeNumCama4 = new  JTextField( "" );
        SizeNumCama4.setBounds(405, 380, 115, 20);
        SizeNumCama4.setForeground(Ctexto); 
        SizeNumCama4.setBackground(bBColor);
        SizeNumCama4.setEditable(false);

        JLabel TipoCama4= new JLabel("Tipo Cama:");
        TipoCama4.setFont(garamond);
        TipoCama4.setHorizontalAlignment(SwingConstants.RIGHT);
        TipoCama4.setForeground(Ctexto); 
        TipoCama4.setBackground(bBColor);
        TipoCama4.setBounds(285, 410, 105, 30);
        JTextField  TipoCama14 = new JTextField("");
        TipoCama14.setBounds(405, 420, 115, 20);
        TipoCama14.setForeground(BRColor); 
        TipoCama14.setBackground(bBColor);
        TipoCama14.setEditable(false);
        

        JLabel Fecha= new JLabel("Fecha a Consultar");
        Fecha.setFont(garamond);
        Fecha.setHorizontalAlignment(SwingConstants.CENTER);
        Fecha.setForeground(Ctexto); 
        Fecha.setBackground(bBColor);
        Fecha.setBounds(30, 520, 245, 30);
        JTextField  Dia = new JTextField("");
        Dia.setBounds(35, 560, 70 , 20);
        Dia.setForeground(BRColor); 
        Dia.setBackground(bBColor);
        JTextField  Mes = new JTextField("");
        Mes.setBounds(115, 560, 70 , 20);
        Mes.setForeground(BRColor); 
        Mes.setBackground(bBColor);
        JTextField  Anio = new JTextField("");
        Anio.setBounds(195, 560, 70 , 20);
        Anio.setForeground(BRColor); 
        Anio.setBackground(bBColor);

        JLabel Precio= new JLabel("Precio Proyectado");
        Precio.setFont(garamond);
        Precio.setHorizontalAlignment(SwingConstants.CENTER);
        Precio.setForeground(Ctexto); 
        Precio.setBackground(bBColor);
        Precio.setBounds(285, 520, 245, 30);
        JTextField  PrecioT = new JTextField("");
        PrecioT.setBounds(285, 560, 245 , 20);
        PrecioT.setForeground(BRColor); 
        PrecioT.setBackground(bBColor);
        PrecioT.setEditable(false);
        JButton boton = new JButton("Consultar Habitacion");
        boton.setBackground(BColor);
        boton.setFont(garamond);
        boton.setForeground(Ctexto);
        boton.setBounds(150, 600, 250, 30); 
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

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
        ventana.add(titulo1);
        ventana.add(TamañoCama);
        ventana.add(TipoSize);
        ventana.add(TipoCama);
        ventana.add(TipoCama1);
        ventana.add(CapacidadCama);
        ventana.add(SizeNumCama);
        ventana.add(TamañoCama2);
        ventana.add(TipoSize2);
        ventana.add(TipoCama2);
        ventana.add(TipoCama12);
        ventana.add(CapacidadCama2);
        ventana.add(SizeNumCama2);
        ventana.add(TamañoCama3);
        ventana.add(TipoSize3);
        ventana.add(TipoCama3);
        ventana.add(TipoCama13);
        ventana.add(CapacidadCama3);
        ventana.add(SizeNumCama3);
        ventana.add(TamañoCama4);
        ventana.add(TipoSize4);
        ventana.add(TipoCama4);
        ventana.add(TipoCama14);
        ventana.add(CapacidadCama4);
        ventana.add(SizeNumCama4);
        ventana.add(Fecha);
        ventana.add(Dia);
        ventana.add(Mes);
        ventana.add(Anio);
        ventana.add(Precio);
        ventana.add(PrecioT);
        ventana.add(boton);
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
        Rectangle2D.Double rect1 = new Rectangle2D.Double(20, 50, 250, 120);
        Rectangle2D.Double rect2 = new Rectangle2D.Double(280, 50, 250, 120);
        Rectangle2D.Double rect3 = new Rectangle2D.Double(20, 220, 245, 110);
        Rectangle2D.Double rect4 = new Rectangle2D.Double(20, 340, 245, 110);
        Rectangle2D.Double rect5 = new Rectangle2D.Double(285, 220, 245, 110);
        Rectangle2D.Double rect6 = new Rectangle2D.Double(285, 340, 245, 110);
        Rectangle2D.Double rect7 = new Rectangle2D.Double(20, 460, 510, 90);

        g2d.setColor(BRColor);
        g2d.fill(rect1);
        g2d.fill(rect2);
        g2d.fill(rect3);
        g2d.fill(rect4);
        g2d.fill(rect5);
        g2d.fill(rect6);
        g2d.fill(rect7);

    }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}