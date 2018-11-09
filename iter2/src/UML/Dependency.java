package UML;

import java.awt.Graphics;

public class Dependency {
	int x1, y1, x2, y2, x3, y3, arrowlength = 16;
	Class c1, c2;

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
		this.c1 = c1;
		this.c2 = c2;
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

	public void paintDependency(Graphics g) {
		int[] pointsX = { x1, x2, x3 };
		int[] pointsY = { y1, y2, y3 };
		g.drawPolygon(pointsX, pointsY, 3);

		if (c1.x < c2.x) {
			if (c1.x + c1.width + arrowlength <= c2.x) {
				g.drawLine(c1.x + c1.width, c1.y + c1.height / 2, c2.x - arrowlength, c2.y + c2.height / 2);
			} else {
				if (c1.y >= c2.y + c2.height + arrowlength) {
					g.drawLine(c1.x + c1.width / 2, c1.y, c2.x + c2.width / 2, c2.y + c2.height + arrowlength);
				} else if (c1.y + c1.height + arrowlength <= c2.y) {
					g.drawLine(c1.x + c1.width / 2, c1.y + c1.height, c2.x + c2.width / 2, c2.y - arrowlength);
				}
			}
		} else {
			if (c1.x >= c2.x + c2.width + arrowlength) {
				g.drawLine(c1.x, c1.y + c1.height / 2, c2.x + c2.width + arrowlength, c2.y + c2.height / 2);
			} else {
				if (c1.y >= c2.y + c2.height + arrowlength) {
					g.drawLine(c1.x + c1.width / 2, c1.y, c2.x + c2.width / 2, c2.y + c2.height + arrowlength);
				} else if (c1.y + c1.height + arrowlength <= c2.y) {
					g.drawLine(c1.x + c1.width / 2, c1.y + c1.height, c2.x + c2.width / 2, c2.y - arrowlength);
				}
			}
		}
	}
}
