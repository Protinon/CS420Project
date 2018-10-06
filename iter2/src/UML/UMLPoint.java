package UML;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class UMLPoint extends JComponent {

	public UMLPoint(int x, int y) {
		super.setBounds(new Rectangle(x, y, 5, 5));
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
		g2.fillOval(0, 0, getWidth(), getHeight());
		g2.drawOval(0, 0, getWidth(), getHeight());

	}
}

