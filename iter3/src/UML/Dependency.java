package UML;

import java.awt.Color;
import java.awt.Graphics;

public class Dependency {
	int x1, y1, x2, y2, x3, y3, arrowlength = 16;
	Class c1, c2;
	double slope;

	/**
	 * Paint method for this class box, overwrites paintComponent.
	 * 
	 * @author Bri Long
	 * @param c1X
	 * @param c1Y
	 * @param c2X
	 * @param c2Y
	 * @param x0
	 * @param y0
	 * @param x4
	 * @param y4
	 **/
	public Dependency(Class c1, Class c2, int x0, int y0, int x4, int y4) {
		x1 = x0;
		y1 = y0;
		x2 = x4;
		y2 = y4;
		x3 = x0;
		y3 = y0;
	}

	public void paintDependency(Graphics g) {
		g.setColor(Color.BLACK);
		if (y2 == y1) {
			if (x1 < x2) {
				for (int i = x1; i <= x2; i += 32) {
					g.drawLine(i, y1, i + 16, y2);
				}
			} else {
				for (int i = x1; i >= x2; i -= 32) {
					g.drawLine(i, y1, i - 16, y2);
				}
			}
		} else if (x1 == x2) {
			if (y1 < y2) {
				for (int i = y1; i <= y2; i += 32) {
					g.drawLine(x1, i, x2, i + 16);
				}
			} else {
				for (int i = y1; i >= y2; i -= 32) {
					g.drawLine(x1, i, x2, i - 16);
				}
			}
		}
	}

}
