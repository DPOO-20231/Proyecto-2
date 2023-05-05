package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class PanelResgistrarConsumo extends JPanel{
	
	private JScrollPane menu;
	private JLabel lbDescripcion;
	private JList<String> lstProductos;
	private JButton btnAddProducto;
	private JButton btnFinalizar;
	
	private Color rojo;
	private Color azul;
	private Color verde;
	
	public PanelResgistrarConsumo() {
	
		rojo = new Color(118, 54, 38);
		verde = new Color(44, 120, 115);
		azul = new Color(2, 28, 30);
		String[] productos = {"Uno - dsds", "Dos - dsdwde", "Tres - safa"}; 
		setPreferredSize(new Dimension(640, 450));
		setBackground(verde);
		setLayout(new GridBagLayout());
		
		lbDescripcion = new JLabel();
		Font fuente = lbDescripcion.getFont();
		fuente = fuente.deriveFont(25f);
		lbDescripcion.setFont(fuente);
		lbDescripcion.setForeground(Color.WHITE);
		lbDescripcion.setBackground(azul);
		lbDescripcion.setOpaque(true);
		lbDescripcion.setPreferredSize(new Dimension(300, 150));
		
		fuente = fuente.deriveFont(15f);
		
		
		btnAddProducto = new JButton("Añadir Producto");
		btnAddProducto.setBackground(rojo);
		btnAddProducto.setFont(fuente);
		btnAddProducto.setForeground(Color.WHITE);
		btnAddProducto.setPreferredSize(new Dimension(150, 40));
		btnFinalizar = new JButton("Finalizar Pedido");
		btnFinalizar.setBackground(rojo);
		btnFinalizar.setFont(fuente);
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setPreferredSize(new Dimension(150, 40));
		
		ListCellRenderer<? super String> customRenderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index,
                        isSelected, cellHasFocus);

                // Cambiar el tamaño y el color del texto
                if (renderer instanceof JLabel) {
                    JLabel label = (JLabel) renderer;
                    Font font = label.getFont().deriveFont(15f); // Cambiar el tamaño del texto
                    Color color = Color.WHITE; // Cambiar el color del texto
                    label.setFont(font);
                    label.setForeground(color);
                }

                return renderer;
            }
        };
		
		lstProductos = new JList<String>(productos);
		lstProductos.setCellRenderer(customRenderer);
		lstProductos.setPreferredSize(new Dimension(250, 450));
		lstProductos.setBackground(azul);
		menu = new JScrollPane(lstProductos);
		menu.setBackground(azul);
		menu.setPreferredSize(new Dimension(300, 350));
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 5, 0, 5);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 3;
		add(menu, c);
		
		c.insets = new Insets(5, 5, 35, 5);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		add(lbDescripcion, c);
		
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.SOUTH;
		add(btnAddProducto, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.NORTH;
		add(btnFinalizar, c);
		
	}
}
