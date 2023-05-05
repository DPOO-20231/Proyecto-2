package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModificarHabitacion extends JFrame implements ActionListener{

    public ModificarHabitacion(JFrame VentanaAnterior){
        VentanaAnterior.setVisible(false);
        JFrame ventana = new JFrame();
        Color bBColor=new Color(Integer.parseInt("2C7873",16));
		Color BColor=new Color(0x763626);
		Color Ctexto = new Color(0xFFF9F3);
		Font garamond = new Font("Garamond", Font.PLAIN, 20);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize( new Dimension( 450, 400 ) );
		ventana.setTitle("Modificar Habitaciones");
        ventana.getContentPane().setBackground(bBColor);
        ventana.setLayout( null);
        ventana.setVisible(true);
        ventana.setResizable(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
