package UML;

import java.awt.Graphics;
import java.awt.Point;

public class Composition implements Relationship {
	private Class c1;
	private Class c2;
	
	private Point relationshipStartPoint;
	private Point relationshipEndPoint;
	
	private CompositionArrow arrow;
	
	private int a, b, c, d;
	private int arrowLength = 16;

	public Composition(Class c1, Class c2) {
		this.c1 = c1;
		this.c2 = c2;
		setLocation();
	}

	public CompositionArrow getArrow() {
		return arrow;
	}

	public void update() {
		int x1 = c1.getLocation().x, x2 = c2.getLocation().x, y1 = c1.getLocation().y, y2 = c2.getLocation().y;
		int width = c1.getWidth();
		int height = c1.getHeight();

		if (x1 < x2) {
			if (x1 + width + arrowLength <= x2) {
				a = x2 - arrowLength;
				c = y2 + height / 2;
				b = x2;
				d = y2 + height / 2;
			} else {
				if (y1 >= y2 + height + arrowLength) {
					a = x2 + width / 2;
					c = y2 + height + arrowLength;
					b = x2 + width / 2;
					d = y2 + height;
				} else if (y1 + height + arrowLength <= y2) {
					a = x2 + width / 2;
					c = y2 - arrowLength;
					b = x2 + width / 2;
					d = y2;
				}
			}
		} else {
			if (x1 >= x2 + width + arrowLength) {
				a = x2 + width + arrowLength;
				c = y2 + height / 2;
				b = x2 + width;
				d = y2 + height / 2;
			} else {
				if (y1 >= y2 + height + arrowLength) {
					a = x2 + width / 2;
					c = y2 + height + arrowLength;
					b = x2 + width / 2;
					d = y2 + height;
				} else if (y1 + height + arrowLength <= y2) {
					a = x2 + width / 2;
					c = y2 - arrowLength;
					b = x2 + width / 2;
					d = y2;
				}
			}
		}
		arrow = new CompositionArrow(c1, c2, a, c, b, d);
	}

	public void setClass1(Class c1) {
		this.c1 = c1;
		update();
	}

	public void setClass2(Class c2) {
		this.c2 = c2;
		update();
	}

	public Class getClass1() {
		return c1;
	}

	public Class getClass2() {
		return c2;
	}

	public void setLocation() {
		int x1 = c1.getLocation().x, x2 = c2.getLocation().x, y1 = c1.getLocation().y, y2 = c2.getLocation().y;
		int width = c1.getWidth();
		int height = c1.getHeight();
		if (x1 < x2) {
			if (x1 + width + arrowLength <= x2) {
				relationshipStartPoint = new Point(x1 + width, y1 + height / 2);
				relationshipEndPoint = new Point(x2 - arrowLength, y2 + height / 2);
			} else {
				if (y1 >= y2 + height + arrowLength) {
					relationshipStartPoint = new Point(x1 + width / 2, y1);
					relationshipEndPoint = new Point(x2 + width / 2, y2 + height + arrowLength);
				} else if (y1 + height + arrowLength <= y2) {
					relationshipStartPoint = new Point(x1 + width / 2, y1 + height);
					relationshipEndPoint = new Point(x2 + width / 2, y2 - arrowLength);
				}
			}
		} else {
			if (x1 >= x2 + width + arrowLength) {
				relationshipStartPoint = new Point(x1, y1 + height / 2);
				relationshipEndPoint = new Point(x2 + width + arrowLength, y2 + height / 2);
			} else {
				if (y1 >= y2 + height + arrowLength) {
					relationshipStartPoint = new Point(x1 + width, y1);
					relationshipEndPoint = new Point(x2 + width / 2, y2 + height + arrowLength);
				} else if (y1 + height + arrowLength <= y2) {
					relationshipStartPoint = new Point(x1 + width / 2, y1 + height);
					relationshipEndPoint = new Point(x2 + width / 2, y2 - arrowLength);
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

	public void paintComposition(Graphics g) {
		Connector cl = new Connector(c1, c2, 16);
		cl.paintConnector(g);
		update();
		arrow.paintCompositionArrow(g);
	}
}
