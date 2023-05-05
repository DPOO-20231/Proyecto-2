package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InfoReserva extends JDialog{
	private JLabel lbTitulo;
	private JPanel panelIzq;
	private JPanel panelDrch;
	private JButton btnConfirmar;
	private JButton btnCancelarReserva;
	
	private Color rojo;
	private Color azul;
	private Color verde;
	
	public InfoReserva() {
		
		rojo = new Color(118, 54, 38);
		verde = new Color(44, 120, 115);
		azul = new Color(2, 28, 30);
		
		// Title Label
        lbTitulo = new JLabel("Reserva");
        Font fuente = lbTitulo.getFont().deriveFont(25f);
        lbTitulo.setFont(fuente);
        lbTitulo.setForeground(Color.WHITE);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
		panelIzq = new PanelIzqInfoReserva();
		panelDrch = new PanelDrchInfoReserva();
		
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		botones.setBackground(verde);
		
		fuente = fuente.deriveFont(15f);
		
		btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(fuente);
        btnConfirmar.setBackground(rojo);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setPreferredSize(new Dimension(300, 45));
		
        btnCancelarReserva = new JButton("Cancelar Reserva");
        btnCancelarReserva.setFont(fuente);
        btnCancelarReserva.setBackground(rojo);
        btnCancelarReserva.setForeground(Color.WHITE);
        btnCancelarReserva.setPreferredSize(new Dimension(300, 45));
        
        botones.add(btnConfirmar);
        botones.add(btnCancelarReserva);
        
        
		setPreferredSize(new Dimension(820, 450));
		getContentPane().setBackground(verde);
		setLayout(new BorderLayout());
		setResizable(false);
		
		add(lbTitulo, BorderLayout.NORTH);
		add(panelIzq, BorderLayout.WEST);
		add(panelDrch, BorderLayout.EAST);
		add(botones, BorderLayout.SOUTH);
		
		
		
		
		
		pack();
		setVisible(true);
	}
}
