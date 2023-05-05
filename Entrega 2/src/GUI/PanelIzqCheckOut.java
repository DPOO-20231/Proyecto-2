package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class PanelIzqCheckOut extends JPanel {
	public PanelIzqCheckOut() {
    	setBackground(new Color(2, 28, 30));
    	setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10),BorderFactory.createLineBorder(Color.WHITE)));
    	setPreferredSize(new Dimension(400, 300));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        // Fecha de Inicio
        JLabel lbFechaInicio = new JLabel("Fecha de Inicio:");
        lbFechaInicio.setForeground(Color.WHITE);
        add(lbFechaInicio, gbc);
        
        Font fuente = lbFechaInicio.getFont().deriveFont(15f);
        lbFechaInicio.setFont(fuente);
        
        JTextField txtDiaInicio = new JTextField(2);
        txtDiaInicio.setEditable(false);
        JTextField txtMesInicio = new JTextField(2);
        txtMesInicio.setEditable(false);
        JTextField txtAnioInicio = new JTextField(4);
        txtAnioInicio.setEditable(false);
        
        JLabel separador1 = new JLabel("/");
        separador1.setFont(fuente);
        separador1.setForeground(Color.WHITE);
        JLabel separador2 = new JLabel("/");
        separador2.setFont(fuente);
        separador2.setForeground(Color.WHITE);
        
        JPanel fechaInicio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fechaInicio.setBackground(new Color(2, 28, 30));
        fechaInicio.add(txtDiaInicio);
        fechaInicio.add(separador1);
        fechaInicio.add(txtMesInicio);
        fechaInicio.add(separador2);
        fechaInicio.add(txtAnioInicio);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(fechaInicio, gbc);
        gbc.gridwidth = 1;
        
        // ID Grupo
        JLabel lbIDGrupo = new JLabel("ID Grupo:");
        lbIDGrupo.setFont(fuente);
        lbIDGrupo.setForeground(Color.WHITE);
        gbc.gridy = 2;
        add(lbIDGrupo, gbc);

        JTextField txtIDGrupo = new JTextField(10);
        txtIDGrupo.setEditable(false);
        gbc.gridy = 2;
        gbc.gridx = 1;
        add(txtIDGrupo, gbc);
        
        // lbHuesped
        JLabel lbHuepseds = new JLabel("Huespedes");
        lbHuepseds.setFont(fuente);
        lbHuepseds.setForeground(Color.WHITE);
        gbc.gridy = 3;
        add(lbHuepseds, gbc);
        
        // Lista
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Elemento 1");
        listModel.addElement("Elemento 2");
        listModel.addElement("Elemento 3");
        listModel.addElement("Elemento 4");
        listModel.addElement("Elemento 5");

        JList<String> lista = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(lista);
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);

    }
}
