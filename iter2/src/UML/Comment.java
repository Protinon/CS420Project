package UML;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Comment {
	int x, y, width = 125, height = 50;

	// set comment's x/y coordinate with passed mouse click coordinate
	public Comment(int x1, int y1) {
		x = x1;
		y = y1;
	}

	// check to see if this object contains the passes coordinate
	public boolean contains(int x2, int y2) {
		Rectangle r = new Rectangle(x, y, 125, 50);
		if (r.contains(x2, y2)) {
			return true;
		}
		return false;
	}

	public void paintComment(Graphics g) {
		g.drawLine(x, y, x, y + height);
		g.drawLine(x, y, x + (width - (height - 25)), y);
		g.drawLine(x, y + height, x + width, y + height);
		g.drawLine(x + width, y + height, x + width, y + (height - 25));
		g.drawLine(x + (width - (height - 25)), y, x + width, y + (height - 25));
		g.drawLine(x + (width - (height - 25)), y + (height - 25), x + (width - (height - 25)), y);
		g.drawLine(x + width, y + (height - 25), x + (width - (height - 25)), y + (height - 25));
	}

	// update this object's location to passed coordinate
	public void setLocation(int i, int j) {
		x = i;
		y = j;
	}
}

