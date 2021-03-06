package UML;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class UMLGeneralization extends JComponent {

	public UMLGeneralization(int x, int y) {
		super.setBounds(new Rectangle(x, y, 110, 10));
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
		g2.drawLine(100, 0, 100, 10);
		g2.drawLine(100, 0, 105, 5);
		g2.drawLine(105, 5, 100, 10);
	}
}
