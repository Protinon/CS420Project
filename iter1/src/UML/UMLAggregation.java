package UML;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class UMLAggregation extends JComponent {

	public UMLAggregation(int x, int y) {
		super.setBounds(new Rectangle(x, y, 115, 15));
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
		g2.drawLine(100, 5, 105, 0);
		g2.drawLine(105, 0, 110, 5);
		g2.drawLine(110, 5, 105, 10);
		g2.drawLine(105, 10, 100, 5);
	}
}
