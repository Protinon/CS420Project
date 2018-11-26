package UML;

import java.awt.Graphics;
import java.awt.Point;

public class Aggregation implements Relationship {
	private Class parent;
	private Class child;

	private Point relationshipStartPoint;
	private Point relationshipEndPoint;

	private AggregationArrow arrow;

	private int a, b, c, d;
	private int arrowLength = 16;

	public Aggregation(Class parent1, Class child2) {
		this.parent = parent1;
		this.child = child2;
		setLocation();
	}

	public AggregationArrow getArrow() {
		return arrow;
	}

	public void update() {
		int x1 = parent.getLocation().x, x2 = child.getLocation().x, y1 = parent.getLocation().y,
				y2 = child.getLocation().y;
		int width = parent.getWidth();
		int height = parent.getHeight();

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
		arrow = new AggregationArrow(parent, child, a, c, b, d);
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

	public void paintAggregation(Graphics g) {
		Connector cl = new Connector(parent, child, 16);
		cl.paintConnector(g);
		update();
		arrow.paintAggregationArrow(g);
	}
}
