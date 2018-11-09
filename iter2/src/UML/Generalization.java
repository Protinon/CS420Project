package UML;

import java.awt.Graphics;

public class Generalization {
	int x1, y1, x2, y2, x3, y3, arrowlength = 16;

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
	public Generalization(Class c1, Class c2, int x0, int y0, int x4, int y4) {
		if (((c1.x < c2.x) && ((c1.x + c1.width) > c2.x - arrowlength))
				|| ((c1.x >= c2.x) && ((c2.x + c1.width) >= c1.x - arrowlength))) {
			x1 = x0 - arrowlength / 2;
			x2 = x0 + arrowlength / 2;
			x3 = x4;
			y1 = y0;
			y2 = y0;
			y3 = y4;
		}

		if (((c1.x >= c2.x) && ((c2.x + c1.width) <= c1.x - arrowlength))
				|| ((c1.x < c2.x) && (c1.x + c1.width <= c2.x - arrowlength))) {
			x1 = x0;
			x2 = x0;
			x3 = x4;
			y1 = y0 + arrowlength / 2;
			y2 = y0 - arrowlength / 2;
			y3 = y4;
		}
	}

	public void paintGeneralization(Graphics g) {
		int[] pointsX = { x1, x2, x3 };
		int[] pointsY = { y1, y2, y3 };
		g.drawPolygon(pointsX, pointsY, 3);
	}
}
