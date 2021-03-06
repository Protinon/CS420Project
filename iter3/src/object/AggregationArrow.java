package object;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class AggregationArrow implements Arrow {
	private int x1, y1, x2, y2, x3, y3, x4, y4;
	private int arrowlength = 16;

	public AggregationArrow(Class c1, Class c2, int x0, int y0, int x5, int y5) {

		if (c1.getLocation().x < c2.getLocation().x) {
			if (c1.getLocation().x + c1.getWidth() + arrowlength <= c2.getLocation().x) {
				x1 = x0;
				y1 = y0;
				x2 = x0 + arrowlength / 2;
				y2 = y0 + arrowlength / 2;
				x3 = x5;
				y3 = y5;
				x4 = x0 + arrowlength / 2;
				y4 = y0 - arrowlength / 2;
			} else {
				if (c1.getLocation().y >= c2.getLocation().y + c2.getHeight() + arrowlength) {
					x1 = x0;
					y1 = y0;
					x2 = x0 - arrowlength / 2;
					y2 = y0 - arrowlength / 2;
					x3 = x5;
					y3 = y5;
					x4 = x0 + arrowlength / 2;
					y4 = y0 - arrowlength / 2;
				} else if (c1.getLocation().y + c1.getHeight() + arrowlength <= c2.getLocation().y) {
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
			if (c1.getLocation().x >= c2.getLocation().x + c2.getWidth() + arrowlength) {
				x1 = x0;
				y1 = y0;
				x2 = x0 - arrowlength / 2;
				y2 = y0 + arrowlength / 2;
				x3 = x5;
				y3 = y5;
				x4 = x0 - arrowlength / 2;
				y4 = y0 - arrowlength / 2;
			} else {
				if (c1.getLocation().y >= c2.getLocation().y + c2.getHeight() + arrowlength) {
					x1 = x0;
					y1 = y0;
					x2 = x0 - arrowlength / 2;
					y2 = y0 - arrowlength / 2;
					x3 = x5;
					y3 = y5;
					x4 = x0 + arrowlength / 2;
					y4 = y0 - arrowlength / 2;
				} else if (c1.getLocation().y + c1.getHeight() + arrowlength <= c2.getLocation().y) {
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

	public boolean contains(Point x5) {
		int[] pointsX = { x1, x2, x3, x4 };
		int[] pointsY = { y1, y2, y3, y4 };
		Polygon r = new Polygon(pointsX, pointsY, 4);
		if (r.contains(x5.x, x5.y)) {
			return true;
		}
		return false;
	}

	public void paintAggregationArrow(Graphics g) {
		int[] pointsX = { x1, x2, x3, x4 };
		int[] pointsY = { y1, y2, y3, y4 };
		g.drawPolygon(pointsX, pointsY, 4);
	}
}