package object;

import java.awt.Graphics;

public class Connector {
	private Class parent;
	private Class child;
	
	private int arrowLength;

	public Connector(Class parent, Class child, int arrowLength) {
		this.parent = parent;
		this.child = child;
		this.arrowLength = arrowLength;
	}

	public void paintConnector(Graphics g) {
		int x1 = parent.getLocation().x, x2 = child.getLocation().x, y1 = parent.getLocation().y, y2 = child.getLocation().y;
		int width = parent.getWidth();
		int height = parent.getHeight();

		if (x1 < x2) {
			if (x1 + width + arrowLength <= x2) {
				g.drawLine(x1 + width, y1 + height / 2, x2 - arrowLength, y2 + height / 2);
			} else {
				if (y1 >= y2 + height + arrowLength) {
					g.drawLine(x1 + width / 2, y1, x2 + width / 2, y2 + height + arrowLength);
				} else if (y1 + height + arrowLength <= y2) {
					g.drawLine(x1 + width / 2, y1 + height, x2 + width / 2, y2 - arrowLength);
				}
			}
		} else {
			if (x1 >= x2 + width + arrowLength) {
				g.drawLine(x1, y1 + height / 2, x2 + width + arrowLength, y2 + height / 2);
			} else {
				if (y1 >= y2 + height + arrowLength) {
					g.drawLine(x1 + width / 2, y1, x2 + width / 2, y2 + height + arrowLength);
				} else if (y1 + height + arrowLength <= y2) {
					g.drawLine(x1 + width / 2, y1 + height, x2 + width / 2, y2 - arrowLength);
				}
			}
		}
	}
}
