package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class RegistrarConsumo extends JDialog{
	private JPanel panelOpciones;
	private JPanel panelRestaurante;
	
	private Color rojo;
	private Color azul;
	private Color verde;
	
	
	public RegistrarConsumo() {
		rojo = new Color(118, 54, 38);
		verde = new Color(44, 120, 115);
		azul = new Color(2, 28, 30);
		
		panelOpciones = new PanelRegistrarConsumoOpciones();
		panelRestaurante = new PanelResgistrarConsumo();
		setPreferredSize(new Dimension(900, 450));
		getContentPane().setBackground(verde);
		setLayout(new BorderLayout());
		setResizable(false);
		
		add(panelOpciones, BorderLayout.WEST);
		add(panelRestaurante, BorderLayout.EAST);
		
		
		
		
		
		pack();
		setVisible(true);
	}
}
