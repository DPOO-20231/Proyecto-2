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
import GUI.OpcionesAdministrador;
import GUI.OpcionesRecepcionista;
import GUI.OpcionesRecepcionista;
import modelo.PropertyManagementSystem;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener {
    private PropertyManagementSystem PMS= new PropertyManagementSystem();
	public Login() {
		JFrame ventana = new JFrame();
        Color bBColor=new Color(Integer.parseInt("2C7873",16));
		Color BColor=new Color(0x763626);
		Color Ctexto = new Color(0xFFF9F3);
		Font garamond = new Font("Garamond", Font.PLAIN, 20);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize( new Dimension( 820, 700 ) );
		ventana.setTitle("	INICIAR SESION");
		ventana.setBackground(bBColor);
        ventana.getContentPane().setBackground(bBColor);
        ventana.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        
        JLabel titulo = new JLabel("Iniciar Sesion");
        titulo.setFont(garamond);
		titulo.setForeground(Ctexto); 
        titulo.setBackground(bBColor);
        
        JLabel titulo1 = new JLabel("Usuario");
        titulo1.setFont(garamond);
		titulo1.setForeground(Ctexto); 
        titulo1.setBackground(bBColor);
        
        JLabel titulo2 = new JLabel("Contraseña");
        titulo2.setFont(garamond);
		titulo2.setForeground(Ctexto); 
        titulo2.setBackground(bBColor);
        
        JTextField User = new  JTextField( "" );
        JTextField Contraseña = new  JTextField( "" );
        JButton boton1 = new JButton("Ingresar");
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rol = PMS.login(User.getText(), Contraseña.getText());
                if (rol.equals("Administrador")){
                    ventana.dispose();
                    new OpcionesAdministrador(PMS);
                }
                else if(rol.equals("Recepcionista")){
                    ventana.dispose();
                    new OpcionesRecepcionista(PMS);
                }
                else{
                    VentanaAviso(rol);
                }
                new HabitacionDesdeManual(); 
            }
        });
        boton1.setBackground(BColor);
        boton1.setFont(garamond);
        boton1.setForeground(Ctexto);
        ventana.add(titulo);
        ventana.add(titulo1);
        ventana.add(User);
        ventana.add(titulo2);
        ventana.add(Contraseña);
        ventana.add(boton1);
        
	}
    
private void VentanaAviso (String mensaje){

        // Mostrar ventana de aviso
        JOptionPane.showMessageDialog(null, mensaje, "Aviso", JOptionPane.INFORMATION_MESSAGE);

        // Mostrar ventana de aviso con botón de aceptar
        int opcion = JOptionPane.showOptionDialog(null, mensaje,
                "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                 new Object[]{"Aceptar"}, null);

        // Verificar la opción seleccionada
        if (opcion == JOptionPane.OK_OPTION) {
            System.out.println("El usuario seleccionó 'Aceptar'.");
        }
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public static void main(String[] args) {
        new Login();
    }
}
