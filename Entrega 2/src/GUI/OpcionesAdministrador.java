package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class OpcionesAdministrador extends JDialog implements ActionListener{
	
	public OpcionesAdministrador() {
	
        setTitle("Opciones Administrador");
        setPreferredSize(new Dimension(400, 500));
        setResizable(false);
        getContentPane().setBackground(new Color(44, 120, 115));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // Title Label
        JLabel lbTitulo = new JLabel("Bienvenido Admin");
        Font fuente = lbTitulo.getFont();
        fuente = fuente.deriveFont(25f);
        lbTitulo.setFont(fuente);
        lbTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 30, 10);
        add(lbTitulo, gbc);
        
        fuente = fuente.deriveFont(15f);
        // Habitaciones Button
        JButton btnConsultarHabitacion = new JButton("Habitaciones");
        btnConsultarHabitacion.setFont(fuente);
        btnConsultarHabitacion.setBackground(new Color(118, 54, 38));
        btnConsultarHabitacion.setForeground(Color.WHITE);
        btnConsultarHabitacion.setActionCommand("HABITACION");
        btnConsultarHabitacion.addActionListener(this);
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 15, 5, 15);
        add(btnConsultarHabitacion, gbc);

        // Personal Button
        JButton btnPersonal = new JButton("Personal");
        btnPersonal.setFont(fuente);
        btnPersonal.setBackground(new Color(118, 54, 38));
        btnPersonal.setForeground(Color.WHITE);
        btnPersonal.setActionCommand("PERSONAL");
        btnPersonal.addActionListener(this);
        gbc.gridy = 2;
        add(btnPersonal, gbc);

        // Consultar Reserva Button
        JButton btnConsultarReserva = new JButton("Servicio/Consumo");
        btnConsultarReserva.setFont(fuente);
        btnConsultarReserva.setBackground(new Color(118, 54, 38));
        btnConsultarReserva.setForeground(Color.WHITE);
        btnConsultarReserva.setActionCommand("SERVICIOS");
        btnConsultarReserva.addActionListener(this);
        gbc.gridy = 3;
        add(btnConsultarReserva, gbc);

        // Registrar Huésped Button
        JButton btnGuardarDatos = new JButton("Guardar Datos");
        btnGuardarDatos.setFont(fuente);
        btnGuardarDatos.setBackground(new Color(118, 54, 38));
        btnGuardarDatos.setForeground(Color.WHITE);
        btnGuardarDatos.setActionCommand("GUARDAR");
        btnGuardarDatos.addActionListener(this);
        gbc.gridy = 4;
        add(btnGuardarDatos, gbc);

        // Salir Button
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(fuente);
        btnSalir.setBackground(new Color(118, 54, 38));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setActionCommand("SALIR");
        btnSalir.addActionListener(this);
        gbc.insets = new Insets(5, 15, 5, 15);
        gbc.gridy = 6;
        add(btnSalir, gbc);
        
        pack();
        setVisible(true);
        		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

	    switch (comando) {
	        case "HABITACION":
	            // Acciones a realizar cuando se presione el botón "Consultar Habitación"
	            break;
	        case "PERSONAL":
	            // Acciones a realizar cuando se presione el botón "Realizar Reserva"
	            break;
	        case "SERVICIOS":
	            // Acciones a realizar cuando se presione el botón "Consultar Reserva"
	            break;
	        case "GUARDAR":
	            // Acciones a realizar cuando se presione el botón "Registrar Huésped"
	            break;
	        case "SALIR":
	            // Acciones a realizar cuando se presione el botón "Salir"
	            dispose(); // Cierra el diálogo
	            break;
	        default:
	            break;
	    }
	}
}
