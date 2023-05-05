package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class PanelDrchCheckOut extends JPanel{
	public PanelDrchCheckOut() {
		setPreferredSize(new Dimension(400, 300));
        setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10),BorderFactory.createLineBorder(Color.WHITE)));
        setBackground(new Color(2, 28, 30));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);
        
     // Precio Total Label
        JLabel lbPrecioHabi = new JLabel("Precio Habitación:");
        Font fuente = lbPrecioHabi.getFont();
        fuente = fuente.deriveFont(15f);
        lbPrecioHabi.setFont(fuente);
        lbPrecioHabi.setForeground(Color.WHITE);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        add(lbPrecioHabi, gbc);

        // Precio Habitación TextField
        JTextField txtPrecioHabi = new JTextField();
        txtPrecioHabi.setEditable(false);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        add(txtPrecioHabi, gbc);

        
     // Precio Reserva Label
        JLabel lbPrecioReserva = new JLabel("Precio Reserva:");
        lbPrecioReserva.setFont(fuente);
        lbPrecioReserva.setForeground(Color.WHITE);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        add(lbPrecioReserva, gbc);

        // Precio Reserva TextField
        JTextField txtPrecioReserva = new JTextField();
        txtPrecioReserva.setEditable(false);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        add(txtPrecioReserva, gbc);
        
     // Precio Servicios Adicionales Label
        JLabel lbPrecioAdicionales = new JLabel("Precio Adicionales:");
        lbPrecioAdicionales.setFont(fuente);
        lbPrecioAdicionales.setForeground(Color.WHITE);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        add(lbPrecioAdicionales, gbc);

        // Precio Servicios Adicionales TextField
        JTextField txtPrecioAdicionales = new JTextField();
        txtPrecioReserva.setEditable(false);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        add(txtPrecioAdicionales, gbc);
        
        
        // Precio Total Label
        JLabel lbPrecioTotal = new JLabel("Precio Total:");
        lbPrecioTotal.setFont(fuente);
        lbPrecioTotal.setForeground(Color.WHITE);
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        add(lbPrecioTotal, gbc);

        // Precio Total TextField
        JTextField txtPrecioTotal = new JTextField();
        txtPrecioTotal.setEditable(false);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        add(txtPrecioTotal, gbc);
        
	
        
        // Agregar Habitación Button
        JButton btnFinalizar = new JButton("Agregar Habitación");
        btnFinalizar.setFont(fuente);
        btnFinalizar.setBackground(new Color(118, 54, 38));
        btnFinalizar.setForeground(Color.WHITE);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 5, 0);
        add(btnFinalizar, gbc);
        gbc.gridwidth = 1;
    
	}
}
