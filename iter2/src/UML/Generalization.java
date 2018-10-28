package UML;

import java.awt.Graphics;

public class Generalization {
	int x1, y1, x2, y2, x3, y3;

	public Generalization(int c1X, int c1Y, int c2X, int c2Y, int x0, int y0, int x4, int y4) {
		if (((c1X < c2X) && ((c1X + 126) > c2X - 16)) || ((c1X >= c2X) && ((c2X + 126) >= c1X - 16))) {
			x1 = x0 - 8;
			x2 = x0 + 8;
			x3 = x4;
			y1 = y0;
			y2 = y0;
			y3 = y4;
		}

		if (((c1X >= c2X) && ((c2X + 126) <= c1X - 16)) || ((c1X < c2X) && (c1X + 126 <= c2X - 16))) {
			x1 = x0;
			x2 = x0;
			x3 = x4;
			y1 = y0 + 8;
			y2 = y0 - 8;
			y3 = y4;
		}
	}

	public void paintGeneralization(Graphics g) {
		int[] pointsX = { x1, x2, x3 };
		int[] pointsY = { y1, y2, y3 };
		g.drawPolygon(pointsX, pointsY, 3);
	}
}
