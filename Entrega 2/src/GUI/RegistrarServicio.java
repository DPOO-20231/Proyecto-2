package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistrarServicio extends JDialog implements ActionListener{
	private Color rojo;
	private Color azul;
	private Color verde;
	
	private JLabel lbTitulo;
	private JLabel lbID;
	private JLabel lbPrecio;
	private JLabel lbNombre;
	private JLabel lbIDHabi;
	
	private JTextField txtID;
	private JTextField txtPrecio;
	private JTextField txtNombre;
	private JTextField txtIDHabi;
	
	private JRadioButton rbtnGrupal;
	private JRadioButton rbtnIndividual;
	private JRadioButton rbtnHabitacion;
	
    public RegistrarServicio() {
    	rojo = new Color(118, 54, 38);
		verde = new Color(44, 120, 115);
		azul = new Color(2, 28, 30);
    	
        setPreferredSize(new Dimension(400, 400));
        setResizable(false);
        getContentPane().setBackground(new Color(44, 120, 115));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Title Label
        lbTitulo = new JLabel("Registrar Consumo");
        Font fuente = lbTitulo.getFont();
        fuente = fuente.deriveFont(20f);
        lbTitulo.setFont(fuente);
        lbTitulo.setForeground(Color.WHITE);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lbTitulo, gbc);

        
        fuente = fuente.deriveFont(15f);
        // ID Field
        lbID = new JLabel("ID:");
        lbID.setForeground(Color.WHITE);
        lbID.setFont(fuente);
        gbc.insets = new Insets(25, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(lbID, gbc);

        txtID = new JTextField();
        txtID.setEditable(false);
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtID, gbc);

        // Precio Field
        lbPrecio = new JLabel("Precio:");
        lbPrecio.setForeground(Color.WHITE);
        lbPrecio.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lbPrecio, gbc);

        txtPrecio = new JTextField();
        txtPrecio.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtPrecio, gbc);

        // Radio Buttons
        rbtnGrupal = new JRadioButton("Grupal");
        rbtnGrupal.setFont(fuente);
        rbtnGrupal.setBackground(verde);
        rbtnGrupal.setForeground(Color.WHITE);
        rbtnGrupal.setActionCommand("GRUPAL");
        rbtnGrupal.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(rbtnGrupal, gbc);

        rbtnIndividual = new JRadioButton("Individual");
        rbtnIndividual.setFont(fuente);
        rbtnIndividual.setBackground(verde);
        rbtnIndividual.setForeground(Color.WHITE);
        rbtnGrupal.setActionCommand("INDIVIDUAL");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(rbtnIndividual, gbc);

        rbtnHabitacion = new JRadioButton("Agregar a la habitación");
        rbtnHabitacion.setFont(fuente);
        rbtnHabitacion.setBackground(verde);
        rbtnHabitacion.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(rbtnHabitacion, gbc);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(rbtnGrupal);
        radioGroup.add(rbtnIndividual);

        // Nombre Field
        lbNombre = new JLabel("Nombre:");
        lbNombre.setForeground(Color.WHITE);
        lbNombre.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(lbNombre, gbc);

        txtNombre = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(txtNombre, gbc);

        // ID-Habitación Field
        lbIDHabi = new JLabel("ID-habitación:");
        lbIDHabi.setFont(fuente);
        lbIDHabi.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(lbIDHabi, gbc);

        txtIDHabi = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(txtIDHabi, gbc);

        // Registrar Consumo Button
        JButton registrarConsumoButton = new JButton("Registrar Consumo");
        registrarConsumoButton.setFont(fuente);
        registrarConsumoButton.setBackground(rojo);
        registrarConsumoButton.setForeground(Color.WHITE);;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 5, 0);
        add(registrarConsumoButton, gbc);
        
        pack();
        setVisible(true);
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("GRUPAl")){
			
		} else if (cmd.equals("INDIVIDUAL")) {
			
		}
	}

}
