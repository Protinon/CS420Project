package UML;

import java.awt.Graphics;
import java.awt.Point;

public class Association implements Relationship {
	private Class parent;
	private Class child;

	private Point connectorStartPoint;
	private Point connectorEndPoint;

	public Association(Class parent, Class child) {
		this.parent = parent;
		this.child = child;
	}

	public Arrow getArrow() {
		return null;

	}

	public Class getClass1() {
		return parent;
	}

	public Class getClass2() {
		return child;
	}

	public void setLocation() {
		int x1 = parent.getLocation().x, x2 = child.getLocation().x, y1 = parent.getLocation().y,
				y2 = child.getLocation().y;
		int width = parent.getWidth();
		int height = parent.getHeight();
		if (x1 < x2) {
			if (x1 + width <= x2) {
				connectorStartPoint = new Point(x1 + width, y1 + height);
				connectorEndPoint = new Point(x2, y2 + height / 2);
			} else {
				if (y1 >= y2 + height) {
					connectorStartPoint = new Point(x1 + width / 2, y1);
					connectorEndPoint = new Point(x2 + width / 2, y2 + height);
				} else if (y1 + height <= y2) {
					connectorStartPoint = new Point(x1 + width / 2, y1 + height);
					connectorEndPoint = new Point(x2 + width / 2, y2);
				}
			}
		} else {
			if (x1 >= x2 + width) {
				connectorStartPoint = new Point(x1, y1 + height / 2);
				connectorEndPoint = new Point(x2 + width, y2 + height / 2);
			} else {
				if (y1 >= y2 + height) {
					connectorStartPoint = new Point(x1 + width / 2, y1);
					connectorEndPoint = new Point(x2 + width / 2, y2 + height);
				} else if (y1 + height <= y2) {
					connectorStartPoint = new Point(x1 + width / 2, y1 + height);
					connectorEndPoint = new Point(x2 + width / 2, y2);
				}
			}
		}
	}

	public void setClass1(Class parent) {
		this.parent = parent;
		update();
	}

	public void setClass2(Class child) {
		this.child = child;
		update();
	}

	public void update() {
	}

	public Point getLocation1() {
		return connectorStartPoint;
	}

	public Point getLocation2() {
		return connectorEndPoint;
	}
	
	public Point getArrowEndLocation() {
		return connectorEndPoint;
	}

	public void paintAssociation(Graphics g) {
		Connector c = new Connector(parent, child, 0);
		c.paintConnector(g);
	}
}
