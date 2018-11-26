package UML;

import java.awt.Graphics;
import java.awt.Point;

public class Dependency implements Relationship {
	private Class parent;
	private Class child;

	private Point connectorStartPoint;
	private Point connectorEndPoint;
	private Point relationshipEndPoint;

	private Point parentMultiplicityPoint;
	private Point childMultiplicityPoint;

	private DependencyArrow arrow;

	private int a, b, c, d;
	private int arrowLength = 16;

	private String parentMultiplicity = "";
	private String childMultiplicity = "";

	public Dependency(Class parent1, Class child2) {
		this.parent = parent1;
		this.child = child2;
		setLocation();
	}

	public DependencyArrow getArrow() {
		return arrow;
	}
	
	public String toString() {
		return "Dependency";
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
		arrow = new DependencyArrow(parent, child, a, c, b, d);
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
		int offset = 10;
		if (x1 < x2) {
			if (x1 + width + arrowLength <= x2) {
				connectorStartPoint = new Point(x1 + width, y1 + height / 2);
				connectorEndPoint = new Point(x2 - arrowLength, y2 + height / 2);
				relationshipEndPoint = new Point(x2, y2 + height / 2);
				if (y1 > y2) {
					parentMultiplicityPoint = new Point(connectorStartPoint.x + offset,
							connectorStartPoint.y + offset * 2);
					childMultiplicityPoint = new Point(relationshipEndPoint.x - offset * 2,
							relationshipEndPoint.y - offset);
				} else {
					parentMultiplicityPoint = new Point(connectorStartPoint.x + offset, connectorStartPoint.y - offset);
					childMultiplicityPoint = new Point(relationshipEndPoint.x - offset * 2,
							relationshipEndPoint.y + offset * 2);
				}
			} else {
				if (y1 >= y2 + height + arrowLength) {
					connectorStartPoint = new Point(x1 + width / 2, y1);
					connectorEndPoint = new Point(x2 + width / 2, y2 + height + arrowLength);
					relationshipEndPoint = new Point(x2 + width / 2, y2 + height + arrowLength);
					parentMultiplicityPoint = new Point(connectorStartPoint.x - offset, connectorStartPoint.y - offset);
					childMultiplicityPoint = new Point(relationshipEndPoint.x + offset,
							relationshipEndPoint.y + offset);

				} else if (y1 + height + arrowLength <= y2) {
					connectorStartPoint = new Point(x1 + width / 2, y1 + height);
					connectorEndPoint = new Point(x2 + width / 2, y2 - arrowLength);
					relationshipEndPoint = new Point(x2 + width / 2, y2);
					parentMultiplicityPoint = new Point(connectorStartPoint.x - offset,
							connectorStartPoint.y + offset * 2);
					childMultiplicityPoint = new Point(relationshipEndPoint.x + offset,
							relationshipEndPoint.y - offset);
				}
			}
		} else {
			if (x1 >= x2 + width + arrowLength) {
				connectorStartPoint = new Point(x1, y1 + height / 2);
				connectorEndPoint = new Point(x2 + width + arrowLength, y2 + height / 2);
				relationshipEndPoint = new Point(x2 + width, y2 + height / 2);
				if (y1 > y2) {
					parentMultiplicityPoint = new Point(connectorStartPoint.x - offset * 2,
							connectorStartPoint.y + offset * 2);
					childMultiplicityPoint = new Point(relationshipEndPoint.x + offset,
							relationshipEndPoint.y - offset);
				} else {
					parentMultiplicityPoint = new Point(connectorStartPoint.x - offset * 2,
							connectorStartPoint.y - offset);
					childMultiplicityPoint = new Point(relationshipEndPoint.x + offset * 2,
							relationshipEndPoint.y + offset * 2);
				}
			} else {
				if (y1 >= y2 + height + arrowLength) {
					connectorStartPoint = new Point(x1 + width / 2, y1);
					connectorEndPoint = new Point(x2 + width / 2, y2 + height + arrowLength);
					relationshipEndPoint = new Point(x2 + width / 2, y2 + height);
					parentMultiplicityPoint = new Point(connectorStartPoint.x + offset, connectorStartPoint.y - offset);
					childMultiplicityPoint = new Point(relationshipEndPoint.x + -offset * 2,
							relationshipEndPoint.y + offset * 2);
				} else if (y1 + height + arrowLength <= y2) {
					connectorStartPoint = new Point(x1 + width / 2, y1 + height);
					connectorEndPoint = new Point(x2 + width / 2, y2 - arrowLength);
					relationshipEndPoint = new Point(x2 + width / 2, y2);
					parentMultiplicityPoint = new Point(connectorStartPoint.x + offset,
							connectorStartPoint.y + offset * 2);
					childMultiplicityPoint = new Point(relationshipEndPoint.x + -offset * 2,
							relationshipEndPoint.y - offset * 2);
				}
			}
		}
		update();
	}

	public Point getLocation1() {
		return connectorStartPoint;
	}

	public Point getLocation2() {
		return connectorEndPoint;
	}

	public Point getArrowEndLocation() {
		return relationshipEndPoint;
	}

	public Point getParentMultiplicityPoint() {
		return parentMultiplicityPoint;
	}

	public Point getChildMultiplicityPoint() {
		return childMultiplicityPoint;
	}

	public void paintDependency(Graphics g) {
		Connector cl = new Connector(parent, child, arrowLength);
		cl.paintConnector(g);
		arrow.paintDependencyArrow(g);
		if (getParentMultiplicity() != "") {
			g.drawString(parentMultiplicity, getParentMultiplicityPoint().x, getParentMultiplicityPoint().y);
		}

		if (getChildMultiplicity() != "") {
			g.drawString(childMultiplicity, getChildMultiplicityPoint().x, getChildMultiplicityPoint().y);
		}
		setLocation();
	}

	public String getParentMultiplicity() {
		return parentMultiplicity;
	}

	public String getChildMultiplicity() {
		return childMultiplicity;
	}

	public void setParentMultiplicity(String mult) {
		this.parentMultiplicity = mult;
	}

	public void setChildMultiplicity(String mult) {
		this.childMultiplicity = mult;
	}
}
