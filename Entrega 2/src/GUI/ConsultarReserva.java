package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConsultarReserva extends JDialog{
	private JLabel lbTitulo;
    private JLabel lbIDHabitacion;
    private JLabel lbFecha;
    private JTextField txtIDHabitacion;
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtAnio;
    private JButton btnConsultar;

    public ConsultarReserva() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 400));
        setResizable(false);
        getContentPane().setBackground(new Color(44, 120, 115));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title Label
        lbTitulo = new JLabel("Consultar Reserva");
        Font fuente = lbTitulo.getFont().deriveFont(25f);
        lbTitulo.setFont(fuente);
        lbTitulo.setForeground(Color.WHITE);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lbTitulo, gbc);

        Font labelFont = lbTitulo.getFont().deriveFont(15f);

        // ID de la Habitación Field
        lbIDHabitacion = new JLabel("ID Habitación:");
        lbIDHabitacion.setForeground(Color.WHITE);
        lbIDHabitacion.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(lbIDHabitacion, gbc);

        txtIDHabitacion = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtIDHabitacion, gbc);

        // Fecha Fields
        lbFecha = new JLabel("Fecha (dd/mm/aaaa):");
        lbFecha.setForeground(Color.WHITE);
        lbFecha.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(lbFecha, gbc);

        JPanel fechaPanel = new JPanel();
        fechaPanel.setLayout(new FlowLayout());
        fechaPanel.setBackground(new Color(44, 120, 115));
        fechaPanel.setPreferredSize(new Dimension(200, 40));

        txtDia = new JTextField(2);
        txtMes = new JTextField(2);
        txtAnio = new JTextField(4);

        fechaPanel.add(txtDia);
        JLabel separador1 = new JLabel("/");
        JLabel separador2 = new JLabel("/");
        separador1.setFont(fuente);
        separador1.setForeground(Color.WHITE);
        separador2.setFont(fuente);
        separador2.setForeground(Color.WHITE);
        
        fechaPanel.add(separador1);
        fechaPanel.add(txtMes);
        fechaPanel.add(separador2);
        fechaPanel.add(txtAnio);

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        add(fechaPanel, gbc);

        // Consultar Button
        btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(labelFont);
        btnConsultar.setBackground(new Color(118, 54, 38));
        btnConsultar.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnConsultar, gbc);

        pack();
        setVisible(true);
    }
}
