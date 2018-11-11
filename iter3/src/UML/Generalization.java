package UML;

import java.awt.Graphics;

public class Generalization {
	private int x1, y1, x2, y2, x3, y3, arrowlength = 16;

	public Generalization(Class c1, Class c2, int x0, int y0, int x4, int y4) {
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

	public void paintGeneralization(Graphics g) {
		int[] pointsX = { x1, x2, x3 };
		int[] pointsY = { y1, y2, y3 };
		g.drawPolygon(pointsX, pointsY, 3);
	}
}
