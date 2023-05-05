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

public class PanelDrchInfoReserva extends JPanel{
	public PanelDrchInfoReserva() {
		setPreferredSize(new Dimension(400, 300));
        setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10),BorderFactory.createLineBorder(Color.WHITE)));
        setBackground(new Color(2, 28, 30));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        // Habitaciones Label
        JLabel lbHabitaciones = new JLabel("Habitaciones:");
        lbHabitaciones.setForeground(Color.WHITE);
        Font fuente = lbHabitaciones.getFont().deriveFont(15f);
        lbHabitaciones.setFont(fuente);
        add(lbHabitaciones, gbc);

        // Lista Habitaciones
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Habitación 1");
        listModel.addElement("Habitación 2");
        listModel.addElement("Habitación 3");
        listModel.addElement("Habitación 4");
        listModel.addElement("Habitación 5");

        JList<String> lista = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(lista);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);
        

     // Precio Total Label
        JLabel lbPrecioTotal = new JLabel("Precio Total:");
        lbPrecioTotal.setFont(fuente);
        lbPrecioTotal.setForeground(Color.WHITE);
        gbc.gridy = 2;
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
    
	}
}
