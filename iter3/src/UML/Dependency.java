package UML;

import java.awt.Color;
import java.awt.Graphics;

public class Dependency {
	private int x1, y1, x2, y2;

	public Dependency(Class c1, Class c2, int x0, int y0, int x4, int y4) {
		x1 = x0;
		y1 = y0;
		x2 = x4;
		y2 = y4;
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