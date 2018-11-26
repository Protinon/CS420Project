package UML;

import java.awt.Graphics;
import java.awt.Point;

public class Generalization implements Relationship {
	private Class parent;
	private Class child;
	
	private Point relationshipStartPoint;
	private Point relationshipEndPoint;
	
	private GeneralizationArrow generalizationArrow;
	
	private int a, b, c, d;
	private int generalizationArrowLength = 16;

	public Generalization(Class parent, Class child) {
		this.parent = parent;
		this.child = child;
		setLocation();
	}

	public GeneralizationArrow getArrow() {
		return generalizationArrow;
	}

	public void update() {
		int x1 = parent.getLocation().x, x2 = child.getLocation().x, y1 = parent.getLocation().y,
				y2 = child.getLocation().y;
		int width = parent.getWidth();
		int height = parent.getHeight();

		if (x1 < x2) {
			if (x1 + width + generalizationArrowLength <= x2) {
				a = x2 - generalizationArrowLength;
				c = y2 + height / 2;
				b = x2;
				d = y2 + height / 2;
			} else {
				if (y1 >= y2 + height + generalizationArrowLength) {
					a = x2 + width / 2;
					c = y2 + height + generalizationArrowLength;
					b = x2 + width / 2;
					d = y2 + height;
				} else if (y1 + height + generalizationArrowLength <= y2) {
					a = x2 + width / 2;
					c = y2 - generalizationArrowLength;
					b = x2 + width / 2;
					d = y2;
				}
			}
		} else {
			if (x1 >= x2 + width + generalizationArrowLength) {
				a = x2 + width + generalizationArrowLength;
				c = y2 + height / 2;
				b = x2 + width;
				d = y2 + height / 2;
			} else {
				if (y1 >= y2 + height + generalizationArrowLength) {
					a = x2 + width / 2;
					c = y2 + height + generalizationArrowLength;
					b = x2 + width / 2;
					d = y2 + height;
				} else if (y1 + height + generalizationArrowLength <= y2) {
					a = x2 + width / 2;
					c = y2 - generalizationArrowLength;
					b = x2 + width / 2;
					d = y2;
				}
			}
		}
		generalizationArrow = new GeneralizationArrow(parent, child, a, c, b, d);
	}

	public void setClass1(Class parent) {
		this.parent = parent;
		update();
	}

	public void setClass2(Class child) {
		this.child = child;
		update();
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
			if (x1 + width + generalizationArrowLength <= x2) {
				relationshipStartPoint = new Point(x1 + width, y1 + height / 2);
				relationshipEndPoint = new Point(x2 - generalizationArrowLength, y2 + height / 2);
			} else {
				if (y1 >= y2 + height + generalizationArrowLength) {
					relationshipStartPoint = new Point(x1 + width / 2, y1);
					relationshipEndPoint = new Point(x2 + width / 2, y2 + height + generalizationArrowLength);
				} else if (y1 + height + generalizationArrowLength <= y2) {
					relationshipStartPoint = new Point(x1 + width / 2, y1 + height);
					relationshipEndPoint = new Point(x2 + width / 2, y2 - generalizationArrowLength);
				}
			}
		} else {
			if (x1 >= x2 + width + generalizationArrowLength) {
				relationshipStartPoint = new Point(x1, y1 + height / 2);
				relationshipEndPoint = new Point(x2 + width + generalizationArrowLength, y2 + height / 2);
			} else {
				if (y1 >= y2 + height + generalizationArrowLength) {
					relationshipStartPoint = new Point(x1 + width, y1);
					relationshipEndPoint = new Point(x2 + width / 2, y2 + height + generalizationArrowLength);
				} else if (y1 + height + generalizationArrowLength <= y2) {
					relationshipStartPoint = new Point(x1 + width / 2, y1 + height);
					relationshipEndPoint = new Point(x2 + width / 2, y2 - generalizationArrowLength);
				}
			}
		}
		update();
	}

	public Point getLocation1() {
		return relationshipStartPoint;
	}

	public Point getLocation2() {
		return relationshipEndPoint;
	}

	public void paintGeneralization(Graphics g) {
		Connector cl = new Connector(parent, child, generalizationArrowLength);
		cl.paintConnector(g);
		update();
		generalizationArrow.paintGeneralizationArrow(g);
	}
}
