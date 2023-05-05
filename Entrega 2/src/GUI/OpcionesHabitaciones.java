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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OpcionesHabitaciones extends JDialog implements ActionListener{
	
	public OpcionesHabitaciones() {
	
        setTitle("Opciones de las Habitaciones");
        setPreferredSize(new Dimension(400, 500));
        setResizable(false);
        getContentPane().setBackground(new Color(44, 120, 115));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // Title Label
        JLabel lbTitulo = new JLabel("¿Qué Deseas Hacer?");
        Font fuente = lbTitulo.getFont();
        fuente = fuente.deriveFont(25f);
        lbTitulo.setFont(fuente);
        lbTitulo.setForeground(Color.WHITE);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 30, 10);
        add(lbTitulo, gbc);
        
        fuente = fuente.deriveFont(15f);
        // Agregar habitaciones mediante archivo Button
        JButton btnCargar = new JButton("Cargar Archivo de Habitaciones");
        btnCargar.setFont(fuente);
        btnCargar.setBackground(new Color(118, 54, 38));
        btnCargar.setForeground(Color.WHITE);
        btnCargar.setActionCommand("CARGAR");
        btnCargar.addActionListener(this);
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 15, 5, 15);
        add(btnCargar, gbc);

        // Crear a mano las habitaciones Button
        JButton btnCrear = new JButton("Crear Manualmente una Habitación");
        btnCrear.setFont(fuente);
        btnCrear.setBackground(new Color(118, 54, 38));
        btnCrear.setForeground(Color.WHITE);
        btnCrear.setActionCommand("CREAR");
        btnCrear.addActionListener(this);
        gbc.gridy = 2;
        add(btnCrear, gbc);

        // Modificar Habitación Button
        JButton btnModificar = new JButton("Modificar Habitación");
        btnModificar.setFont(fuente);
        btnModificar.setBackground(new Color(118, 54, 38));
        btnModificar.setForeground(Color.WHITE);
        btnModificar.setActionCommand("MODIFICAR");
        btnModificar.addActionListener(this);
        gbc.gridy = 3;
        add(btnModificar, gbc);

        // Consultar Habitaciones Button
        JButton btnConsultar = new JButton("Consultar las Habitaciones");
        btnConsultar.setFont(fuente);
        btnConsultar.setBackground(new Color(118, 54, 38));
        btnConsultar.setForeground(Color.WHITE);
        btnConsultar.setActionCommand("CONSULTAR");
        btnConsultar.addActionListener(this);
        gbc.gridy = 4;
        add(btnConsultar, gbc);

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
	        case "CARGAR":
	            // Acciones a realizar cuando se presione el botón "Consultar Habitación"
	            break;
	        case "CREAR":
	            // Acciones a realizar cuando se presione el botón "Realizar Reserva"
	            break;
	        case "MODIFICAR":
	            // Acciones a realizar cuando se presione el botón "Consultar Reserva"
	            break;
	        case "CONSULTAR":
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
