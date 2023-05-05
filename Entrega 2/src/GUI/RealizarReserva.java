package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RealizarReserva extends JDialog{
	private JLabel lbTitulo;
	private JPanel panelIzq;
	private JPanel panelDrch;
	private JButton btnCrearReserva;
	
	private Color rojo;
	private Color azul;
	private Color verde;
	
	public RealizarReserva() {
		
		rojo = new Color(118, 54, 38);
		verde = new Color(44, 120, 115);
		azul = new Color(2, 28, 30);
		
		// Title Label
        lbTitulo = new JLabel("Consultar Reserva");
        Font fuente = lbTitulo.getFont().deriveFont(25f);
        lbTitulo.setFont(fuente);
        lbTitulo.setForeground(Color.WHITE);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
		panelIzq = new PanelIzqReserva();
		panelDrch = new PanelDrchReserva();
		btnCrearReserva = new JButton("Consultar");
        btnCrearReserva.setFont(fuente);
        btnCrearReserva.setBackground(rojo);
        btnCrearReserva.setForeground(Color.WHITE);
        btnCrearReserva.setPreferredSize(new Dimension(100, 45));
		
		setPreferredSize(new Dimension(820, 450));
		getContentPane().setBackground(verde);
		setLayout(new BorderLayout());
		setResizable(false);
		
		add(lbTitulo, BorderLayout.NORTH);
		add(panelIzq, BorderLayout.WEST);
		add(panelDrch, BorderLayout.EAST);
		add(btnCrearReserva, BorderLayout.SOUTH);
		
		
		
		
		
		pack();
		setVisible(true);
	}
	
}
