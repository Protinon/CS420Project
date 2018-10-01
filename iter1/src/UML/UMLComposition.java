package UML;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class UMLComposition extends JComponent {

	public UMLComposition(int x, int y) {
		super.setBounds(new Rectangle(x, y, 500, 500));
		super.setLocation(x, y);

		UMLMouseListener listener = new UMLMouseListener();
		super.addMouseListener(listener);
		super.addMouseMotionListener(listener);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);
		g2.drawLine(5, 5, 100, 5);
		
		int[] arg0 = {100, 105, 110, 105};
		int[] arg1 = {5, 0, 5, 10};
		g2.drawPolygon(arg0, arg1, 4);
		g2.fillPolygon(arg0, arg1, 4);
	}
}
