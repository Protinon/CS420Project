package UML;

import java.awt.Graphics;

public class Relationship {
	Class c1, c2;
	String relationship;

	public Relationship(String relationship1, Class c0, Class c3) {
		c1 = c0;
		c2 = c3;
		relationship = relationship1;
	}

	public void paintRelationship(Graphics g) {
		// will be coordinates for arrow part of relationship
		int x0, y0, x1, y1;

		if ((c1.x < c2.x)) {
			if (c1.x + c1.width > c2.x) {
				if (c1.y > c2.y) {
					g.drawLine(c1.x + c1.width / 2, c1.y, c2.x + c2.width / 2, c2.y + c2.height + 20);
					x0 = c2.x + c2.width / 2;
					y0 = c2.y + c2.height + 20;
					x1 = c2.x + c2.width / 2;
					y1 = c2.y + c2.height;
				} else {
					g.drawLine(c1.x + c1.width / 2, c1.y + c1.height, c2.x + c2.width / 2, c2.y - 20);
					x0 = c2.x + c2.width / 2;
					y0 = c2.y - 20;
					x1 = c2.x + c2.width / 2;
					y1 = c2.y;
				}
			} else {
				g.drawLine(c1.x + c1.width, c1.y + c1.height / 2, c2.x - 20, c2.y + c2.height / 2);
				x0 = c2.x - 20;
				y0 = c2.y + c2.height / 2;
				x1 = c2.x;
				y1 = c2.y + c2.height / 2;
			}
		} else {
			if (c2.x + c2.width < c1.x) {
				g.drawLine(c1.x, c1.y + c1.height / 2, c2.x + c2.width + 20, c2.y + c2.height / 2);
				x0 = c2.x + c2.width + 20;
				y0 = c2.y + c2.height / 2;
				x1 = c2.x + c2.width;
				y1 = c2.y + c2.height / 2;
			} else {
				if (c1.y > c2.y) {
					g.drawLine(c1.x + c1.width / 2, c1.y, c2.x + c2.width / 2, c2.y + c2.height + 20);
					x0 = c2.x + c2.width / 2;
					y0 = c2.y + c2.height + 20;
					x1 = c2.x + c2.width / 2;
					y1 = c2.y + c2.height;
				} else {
					g.drawLine(c1.x + c1.width / 2, c1.y + c1.height, c2.x + c2.width / 2, c2.y - 20);
					x0 = c2.x + c2.width / 2;
					y0 = c2.y - 20;
					x1 = c2.x + c2.width / 2;
					y1 = c2.y;
				}
			}
		}
	}
}
