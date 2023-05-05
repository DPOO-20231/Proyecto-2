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
import javax.swing.JTextField;

public class CambiarPassword extends JDialog implements ActionListener{
	private JLabel lbTitle;
	private JLabel lbPswrdNew;
	private JLabel lbPswrdC;
	private JLabel lbIncorrecto;
	
	private JTextField txtPswrdNew;
	private JTextField txtPswrdC;
	
	private JButton btnCambiar;
	
	private Color rojo;
	private Color azul;
	private Color verde;
	
	
	public CambiarPassword() {
		rojo = new Color(118, 54, 38);
		verde = new Color(44, 120, 115);
		azul = new Color(2, 28, 30);
		
		setPreferredSize(new Dimension(400, 500));
		getContentPane().setBackground(verde);
		setLayout(new GridBagLayout());
		setResizable(false);
		
		
		lbTitle = new JLabel("Cambiar Contraseña");
		lbPswrdNew = new JLabel("Nueva Contraseña");
		lbPswrdC = new JLabel("Confirmar Contraseña");
		lbIncorrecto = new JLabel();
		
		txtPswrdNew = new JTextField();
		txtPswrdNew.setPreferredSize(new Dimension(200, 35));
		txtPswrdC = new JTextField();
		txtPswrdC.setPreferredSize(new Dimension(200, 35));
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.setBackground(rojo);
		btnCambiar.setActionCommand("CAMBIAR");
		btnCambiar.addActionListener(this);
		
		
		
		Font fuente = lbTitle.getFont();
		fuente = fuente.deriveFont(25f);
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setFont(fuente);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 20, 5);
		c.gridx = 0;
		c.gridy = 0;
		add(lbTitle, c);
		
		fuente = fuente.deriveFont(15f);
		lbPswrdNew.setFont(fuente);
		lbPswrdNew.setForeground(Color.WHITE);
		lbPswrdC.setFont(fuente);
		lbPswrdC.setForeground(Color.WHITE);
		btnCambiar.setFont(fuente);
		btnCambiar.setForeground(Color.WHITE);
		lbIncorrecto.setFont(fuente);
		lbIncorrecto.setForeground(Color.WHITE);
		
		c.insets = new Insets(5, 5, 0, 5);
		c.gridx = 0;
		c.gridy = 1;
		add(lbPswrdNew, c);
		
		c.gridx = 0;
		c.gridy = 2;
		add(txtPswrdNew, c);
		
		c.gridx = 0;
		c.gridy = 3;
		add(lbPswrdC, c);
		
		c.gridx = 0;
		c.gridy = 4;
		add(txtPswrdC, c);
		
		c.insets = new Insets(32, 5, 0, 5);
		c.gridx = 0;
		c.gridy = 5;
		add(btnCambiar, c);
		
	
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(5, 5, 0, 5);
		add(lbIncorrecto, c);

		pack();
		setVisible(true);
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
	
		if (cmd.equals("CAMBIAR")){
			if (txtPswrdNew.getText().equals(txtPswrdC.getText())) {
				lbIncorrecto.setText("Cambio Exitoso");
			}else {
				lbIncorrecto.setText("Ups... parece que las contraseñas no son iguales");
			}
		}
		
	}
}
