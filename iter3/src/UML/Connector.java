package UML;

import java.awt.Graphics;

public class Connector {
	private Class c1, c2;
	private int a = 0, c = 0, b = 0, d = 0, arrowLength = 16;

	public Connector(Class c1, Class c2, int arrowLength) {
		this.c1 = c1;
		this.c2 = c2;
		this.arrowLength = arrowLength;
	}

	public void paintConnector(Graphics g) {
		int x1 = c1.getLocation().x, x2 = c2.getLocation().x, y1 = c1.getLocation().y, y2 = c2.getLocation().y;
		int width = c1.getWidth();
		int height = c1.getHeight();

		if (x1 < x2) {
			if (x1 + width + arrowLength <= x2) {
				g.drawLine(x1 + width, y1 + height / 2, x2 - arrowLength, y2 + height / 2);
				a = x2 - arrowLength;
				c = y2 + height / 2;
				b = x2;
				d = y2 + height / 2;
			} else {
				if (y1 >= y2 + height + arrowLength) {
					g.drawLine(x1 + width / 2, y1, x2 + width / 2, y2 + height + arrowLength);
					a = x2 + width / 2;
					c = y2 + height + arrowLength;
					b = x2 + width / 2;
					d = y2 + height;

				} else if (y1 + height + arrowLength <= y2) {
					g.drawLine(x1 + width / 2, y1 + height, x2 + width / 2, y2 - arrowLength);
					a = x2 + width / 2;
					c = y2 - arrowLength;
					b = x2 + width / 2;
					d = y2;

				}
			}
		} else {
			if (x1 >= x2 + width + arrowLength) {
				g.drawLine(x1, y1 + height / 2, x2 + width + arrowLength, y2 + height / 2);

				a = x2 + width + arrowLength;
				c = y2 + height / 2;
				b = x2 + width;
				d = y2 + height / 2;

			} else {
				if (y1 >= y2 + height + arrowLength) {
					g.drawLine(x1 + width / 2, y1, x2 + width / 2, y2 + height + arrowLength);

					a = x2 + width / 2;
					c = y2 + height + arrowLength;
					b = x2 + width / 2;
					d = y2 + height;

				} else if (y1 + height + arrowLength <= y2) {
					g.drawLine(x1 + width / 2, y1 + height, x2 + width / 2, y2 - arrowLength);

					a = x2 + width / 2;
					c = y2 - arrowLength;
					b = x2 + width / 2;
					d = y2;

				}
			}
		}
	}

	public int getLoc1() {
		return a;
	}

	public int getLoc2() {
		return c;
	}

	public int getLoc3() {
		return b;
	}

	public int getLoc4() {
		return d;
	}
}
