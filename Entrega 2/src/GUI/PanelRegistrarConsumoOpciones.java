package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelRegistrarConsumoOpciones extends JPanel{
	private JLabel lbTitulo;
	
	private ButtonGroup grpOpciones;
	
	private ArrayList<JRadioButton> serviciosHotel;
	
	private JButton btnCambiarPswrd;
	private JButton btnSalir;
	
	private Color rojo;
	private Color azul;
	private Color verde;

	public PanelRegistrarConsumoOpciones() {
		
		rojo = new Color(118, 54, 38);
		verde = new Color(44, 120, 115);
		azul = new Color(2, 28, 30);
		setPreferredSize(new Dimension(250, 450));
		setBackground(verde);
		setLayout(new GridBagLayout());
		
		lbTitulo = new JLabel("Servicios");
		Font fuente = lbTitulo.getFont();
		fuente = fuente.deriveFont(35f);
		lbTitulo.setFont(fuente);
		lbTitulo.setForeground(Color.WHITE);
		grpOpciones = new ButtonGroup();
		
		fuente = fuente.deriveFont(15f);
		
		JRadioButton btnRestaurante = new JRadioButton("Restaurante");
		btnRestaurante.setPreferredSize(new Dimension(150, 30));
		btnRestaurante.setFont(fuente);
		btnRestaurante.setForeground(Color.WHITE);
		btnRestaurante.setBackground(verde);
		btnRestaurante.setSelected(true);
		JRadioButton btnSPA = new JRadioButton("SPA");
		btnSPA.setPreferredSize(new Dimension(150, 30));
		btnSPA.setFont(fuente);
		btnSPA.setForeground(Color.WHITE);
		btnSPA.setBackground(verde);
		JRadioButton btnGuiaTuristica = new JRadioButton("GuiaTuristica");
		btnGuiaTuristica.setPreferredSize(new Dimension(150, 30));
		btnGuiaTuristica.setFont(fuente);
		btnGuiaTuristica.setForeground(Color.WHITE);
		btnGuiaTuristica.setBackground(verde);
		
		grpOpciones.add(btnRestaurante);
		grpOpciones.add(btnSPA);
		grpOpciones.add(btnGuiaTuristica);
		
		btnCambiarPswrd = new JButton("Cambiar Contraseña");
		btnCambiarPswrd.setBackground(rojo);
		btnCambiarPswrd.setFont(fuente);
		btnCambiarPswrd.setForeground(Color.WHITE);
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(rojo);
		btnSalir.setFont(fuente);
		btnSalir.setForeground(Color.WHITE);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 25, 5);
		c.gridx = 0;
		c.gridy = 0;
		add(lbTitulo, c);
		
		c.insets = new Insets(0, 5, 0, 5);
		c.gridx = 0;
		c.gridy = 1;
		add(btnRestaurante, c);
		
		c.gridx = 0;
		c.gridy = 2;
		add(btnSPA, c);
		
		c.gridx = 0;
		c.gridy = 3;
		add(btnGuiaTuristica, c);
		
		c.insets = new Insets(25, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 4;
		add(btnCambiarPswrd, c);
		
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 5;
		add(btnSalir, c);
	}
}
