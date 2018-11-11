package UML;

import java.awt.Graphics;

public class Aggregation {
	int x1, y1, x2, y2, x3, y3, x4, y4, arrowlength = 16;

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
	public Aggregation(Class c1, Class c2, int x0, int y0, int x5, int y5) {

		if (c1.x < c2.x) {
			if (c1.x + c1.width + arrowlength <= c2.x) {
				x1 = x0;
				y1 = y0;
				x2 = x0 + arrowlength / 2;
				y2 = y0 + arrowlength / 2;
				x3 = x5;
				y3 = y5;
				x4 = x0 + arrowlength / 2;
				y4 = y0 - arrowlength / 2;
			} else {
				if (c1.y >= c2.y + c2.height + arrowlength) {
					x1 = x0;
					y1 = y0;
					x2 = x0 - arrowlength / 2;
					y2 = y0 - arrowlength / 2;
					x3 = x5;
					y3 = y5;
					x4 = x0 + arrowlength / 2;
					y4 = y0 - arrowlength / 2;
				} else if (c1.y + c1.height + arrowlength <= c2.y) {
					x1 = x0;
					y1 = y0;
					x2 = x0 + arrowlength / 2;
					y2 = y0 + arrowlength / 2;
					x3 = x5;
					y3 = y5;
					x4 = x0 - arrowlength / 2;
					y4 = y0 + arrowlength / 2;
				}
			}
		} else {
			if (c1.x >= c2.x + c2.width + arrowlength) {
				x1 = x0;
				y1 = y0;
				x2 = x0 - arrowlength / 2;
				y2 = y0 + arrowlength / 2;
				x3 = x5;
				y3 = y5;
				x4 = x0 - arrowlength / 2;
				y4 = y0 - arrowlength / 2;
			} else {
				if (c1.y >= c2.y + c2.height + arrowlength) {
					x1 = x0;
					y1 = y0;
					x2 = x0 - arrowlength / 2;
					y2 = y0 - arrowlength / 2;
					x3 = x5;
					y3 = y5;
					x4 = x0 + arrowlength / 2;
					y4 = y0 - arrowlength / 2;
				} else if (c1.y + c1.height + arrowlength <= c2.y) {
					x1 = x0;
					y1 = y0;
					x2 = x0 - arrowlength / 2;
					y2 = y0 + arrowlength / 2;
					x3 = x5;
					y3 = y5;
					x4 = x0 + arrowlength / 2;
					y4 = y0 + arrowlength / 2;
				}
			}
		}

	}

	public void paintAggregation(Graphics g) {
		int[] pointsX = { x1, x2, x3, x4 };
		int[] pointsY = { y1, y2, y3, y4 };
		g.drawPolygon(pointsX, pointsY, 4);
	}
}
