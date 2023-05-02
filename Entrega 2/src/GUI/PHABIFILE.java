package GUI;
import javax.swing.JPanel;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.*;

public class PHABIFILE extends JPanel{
	public PHABIFILE() {
		this.setSize(1060,950);
        Color BColor=new Color(0x763626);

		this.setBackground(BColor);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//realizo graficos pedidos
		Rectangle2D.Double rect1=new Rectangle2D.Double(30, 100, 984, 182);
        Rectangle2D.Double rect2=new Rectangle2D.Double(30, 295, 984, 554);
		Color OColor=new Color(0x021C1E);
		g2d.setColor(OColor);
		g2d.fill(rect1);
        g2d.fill(rect2);
		
	}

}

