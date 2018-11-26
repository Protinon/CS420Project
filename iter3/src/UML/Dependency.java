package UML;

import java.awt.Graphics;
import java.awt.Point;

public class Dependency implements Relationship {
	private Class parent;
	private Class child;
	
	private Point relationshipStartPoint;
	private Point relationshipEndPoint;
	
	private GeneralizationArrow dependencyArrow;
	
	private int a, b, c, d;
	private int dependencyArrowLength = 16;

	public Dependency(Class parent, Class child) {
		this.parent = parent;
		this.child = child;
		setLocation();
	}

	public GeneralizationArrow getArrow() {
		return dependencyArrow;
	}

	public void update() {
		int x1 = parent.getLocation().x, x2 = child.getLocation().x, y1 = parent.getLocation().y,
				y2 = child.getLocation().y;
		int width = parent.getWidth();
		int height = parent.getHeight();

		if (x1 < x2) {
			if (x1 + width + dependencyArrowLength <= x2) {
				a = x2 - dependencyArrowLength;
				c = y2 + height / 2;
				b = x2;
				d = y2 + height / 2;
			} else {
				if (y1 >= y2 + height + dependencyArrowLength) {
					a = x2 + width / 2;
					c = y2 + height + dependencyArrowLength;
					b = x2 + width / 2;
					d = y2 + height;
				} else if (y1 + height + dependencyArrowLength <= y2) {
					a = x2 + width / 2;
					c = y2 - dependencyArrowLength;
					b = x2 + width / 2;
					d = y2;
				}
			}
		} else {
			if (x1 >= x2 + width + dependencyArrowLength) {
				a = x2 + width + dependencyArrowLength;
				c = y2 + height / 2;
				b = x2 + width;
				d = y2 + height / 2;
			} else {
				if (y1 >= y2 + height + dependencyArrowLength) {
					a = x2 + width / 2;
					c = y2 + height + dependencyArrowLength;
					b = x2 + width / 2;
					d = y2 + height;
				} else if (y1 + height + dependencyArrowLength <= y2) {
					a = x2 + width / 2;
					c = y2 - dependencyArrowLength;
					b = x2 + width / 2;
					d = y2;
				}
			}
		}
		dependencyArrow = new GeneralizationArrow(parent, child, a, c, b, d);
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
		int dependencyArrowlength = 16;
		int x1 = parent.getLocation().x, x2 = child.getLocation().x, y1 = parent.getLocation().y,
				y2 = child.getLocation().y;
		int width = parent.getWidth();
		int height = parent.getHeight();
		if (x1 < x2) {
			if (x1 + width + dependencyArrowlength <= x2) {
				relationshipStartPoint = new Point(x1 + width, y1 + height / 2);
				relationshipEndPoint = new Point(x2 - dependencyArrowlength, y2 + height / 2);
			} else {
				if (y1 >= y2 + height + dependencyArrowlength) {
					relationshipStartPoint = new Point(x1 + width / 2, y1);
					relationshipEndPoint = new Point(x2 + width / 2, y2 + height + dependencyArrowlength);
				} else if (y1 + height + dependencyArrowlength <= y2) {
					relationshipStartPoint = new Point(x1 + width / 2, y1 + height);
					relationshipEndPoint = new Point(x2 + width / 2, y2 - dependencyArrowlength);
				}
			}
		} else {
			if (x1 >= x2 + width + dependencyArrowlength) {
				relationshipStartPoint = new Point(x1, y1 + height / 2);
				relationshipEndPoint = new Point(x2 + width + dependencyArrowlength, y2 + height / 2);
			} else {
				if (y1 >= y2 + height + dependencyArrowlength) {
					relationshipStartPoint = new Point(x1 + width, y1);
					relationshipEndPoint = new Point(x2 + width / 2, y2 + height + dependencyArrowlength);
				} else if (y1 + height + dependencyArrowlength <= y2) {
					relationshipStartPoint = new Point(x1 + width / 2, y1 + height);
					relationshipEndPoint = new Point(x2 + width / 2, y2 - dependencyArrowlength);
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

	public void paintDependency(Graphics g) {
		Connector cl = new Connector(parent, child, dependencyArrowLength);
		cl.paintConnector(g);
		update();
		dependencyArrow.paintGeneralizationArrow(g);
	}
}
