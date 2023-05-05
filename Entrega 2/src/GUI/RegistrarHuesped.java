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

public class RegistrarHuesped extends JDialog implements ActionListener{

    private JLabel lbTitulo;
    private JLabel lbNombre;
    private JLabel lbDocumento;
    private JLabel lbIDGrupo;
    
    private JTextField txtNombre;
    private JTextField txtDocumento;
    private JTextField txtIDGrupo;
    
    private JButton btnRegistrar;

    private Color rojo;
	private Color azul;
	private Color verde;
    public RegistrarHuesped() {
    	
    	rojo = new Color(118, 54, 38);
		verde = new Color(44, 120, 115);
		azul = new Color(2, 28, 30);
		
        setTitle("Registrar Huésped");
        setPreferredSize(new Dimension(400, 300));
        getContentPane().setBackground(new Color(44, 120, 115));
        setResizable(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título
        lbTitulo = new JLabel("Registrar Huésped");
        Font fuente = lbTitulo.getFont();
        fuente = fuente.deriveFont(25f);
        lbTitulo.setFont(fuente);
        lbTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lbTitulo, gbc);
        
        fuente = fuente.deriveFont(15f);
        // Campo de texto y etiqueta para Nombre
        lbNombre = new JLabel("Nombre:");
        lbNombre.setFont(fuente);
        lbNombre.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(lbNombre, gbc);

        txtNombre = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtNombre, gbc);

        // Campo de texto y etiqueta para Documento
        lbDocumento = new JLabel("Documento:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        lbDocumento.setFont(fuente);
        lbDocumento.setForeground(Color.WHITE);
        add(lbDocumento, gbc);

        txtDocumento = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtDocumento, gbc);

        // Campo de texto y etiqueta para ID del Grupo
        lbIDGrupo = new JLabel("ID del Grupo:");
        lbIDGrupo.setFont(fuente);
        lbIDGrupo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lbIDGrupo, gbc);

        txtIDGrupo = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(txtIDGrupo, gbc);

        // Botón Registrar
        btnRegistrar = new JButton("     Registrar     ");
        btnRegistrar.setBackground(rojo);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(fuente);
        btnRegistrar.setActionCommand("REGISTRAR");
        btnRegistrar.addActionListener(this);
        gbc.insets = new Insets(15, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnRegistrar, gbc);
        
        pack();
        setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
