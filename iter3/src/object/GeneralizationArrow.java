package object;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class GeneralizationArrow implements Arrow{
	private int x1, y1, x2, y2, x3, y3;
	private int arrowlength = 16;

	public GeneralizationArrow(Class c1, Class c2, int x0, int y0, int x4, int y4) {
		if (((c1.getLocation().x < c2.getLocation().x)
				&& ((c1.getLocation().x + c1.getWidth()) > c2.getLocation().x - arrowlength))
				|| ((c1.getLocation().x >= c2.getLocation().x)
						&& ((c2.getLocation().x + c1.getWidth()) >= c1.getLocation().x - arrowlength))) {
			x1 = x0 - arrowlength / 2;
			x2 = x0 + arrowlength / 2;
			x3 = x4;
			y1 = y0;
			y2 = y0;
			y3 = y4;
		}

		if (((c1.getLocation().x >= c2.getLocation().x)
				&& ((c2.getLocation().x + c1.getWidth()) <= c1.getLocation().x - arrowlength))
				|| ((c1.getLocation().x < c2.getLocation().x)
						&& (c1.getLocation().x + c1.getWidth() <= c2.getLocation().x - arrowlength))) {
			x1 = x0;
			x2 = x0;
			x3 = x4;
			y1 = y0 + arrowlength / 2;
			y2 = y0 - arrowlength / 2;
			y3 = y4;
		}
	}

	public boolean contains(Point x5) {
		int[] pointsX = { x1, x2, x3 };
		int[] pointsY = { y1, y2, y3 };
		Polygon r = new Polygon(pointsX, pointsY, 3);
		if (r.contains(x5.x, x5.y)) {
			return true;
		}
		return false;
	}

	public void paintGeneralizationArrow(Graphics g) {
		int[] pointsX = { x1, x2, x3 };
		int[] pointsY = { y1, y2, y3 };
		g.drawPolygon(pointsX, pointsY, 3);
	}
}