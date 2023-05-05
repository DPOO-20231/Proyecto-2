package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class PanelDrchReserva extends JPanel{
	public PanelDrchReserva() {
        setPreferredSize(new Dimension(400, 300));
        setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10),BorderFactory.createLineBorder(Color.WHITE)));
        setBackground(new Color(2, 28, 30));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        // Habitaciones Label
        JLabel lbHabitaciones = new JLabel("Habitaciones:");
        lbHabitaciones.setForeground(Color.WHITE);
        Font fuente = lbHabitaciones.getFont().deriveFont(15f);
        lbHabitaciones.setFont(fuente);
        add(lbHabitaciones, gbc);

        // Habitaciones ComboBox
        JComboBox<String> habitacionesComboBox = new JComboBox<>();
        habitacionesComboBox.addItem("Habitación 1 - Tipo - Capacidad");
        habitacionesComboBox.addItem("Habitación 2 - Tipo - Capacidad");
        habitacionesComboBox.addItem("Habitación 3 - Tipo - Capacidad");
        gbc.gridy = 0;
        gbc.gridx = 1;
        add(habitacionesComboBox, gbc);
        gbc.gridwidth = 1;

        // Agregar Habitación Button
        JButton btnagregarHabi = new JButton("Agregar Habitación");
        btnagregarHabi.setFont(fuente);
        btnagregarHabi.setBackground(new Color(118, 54, 38));
        btnagregarHabi.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 5, 0);
        add(btnagregarHabi, gbc);
        gbc.gridwidth = 1;

        // Precio Total Label
        JLabel lbPrecioTotal = new JLabel("Precio Total:");
        lbPrecioTotal.setFont(fuente);
        lbPrecioTotal.setForeground(Color.WHITE);
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(lbPrecioTotal, gbc);

        // Precio Total TextField
        JTextField txtPrecioTotal = new JTextField();
        txtPrecioTotal.setPreferredSize(new Dimension(100, 45));
        gbc.insets = new Insets(0, 0, 0, 0);
        txtPrecioTotal.setEditable(false);
        gbc.gridy = 4;
        add(txtPrecioTotal, gbc);
    }
}
