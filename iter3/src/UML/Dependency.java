package UML;

import java.awt.Graphics;
import java.awt.Point;

public class Dependency implements Relationship{
	private Class c1, c2;
	private Point p1, p2;
	private GeneralizationArrow arrow;
	private int a,b,c,d,arrowLength =16;
	public Dependency(Class c1, Class c2) {
		this.c1 = c1;
		this.c2 = c2;
		setLocation();
	}
	
	public GeneralizationArrow getArrow() {
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
		arrow = new GeneralizationArrow(c1, c2, a,c,b,d);
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
		int arrowlength = 16;
		int x1 = c1.getLocation().x, x2 = c2.getLocation().x, y1 = c1.getLocation().y, y2 = c2.getLocation().y;
		int width = c1.getWidth();
		int height = c1.getHeight();
		if (x1 < x2) {
			if (x1 + width + arrowlength <= x2) {
				p1 = new Point(x1 + width, y1 + height/2);
				p2 = new Point(x2 - arrowlength, y2 + height/2);
			} else {
				if (y1 >= y2 + height + arrowlength) {
					p1 = new Point(x1 + width/2, y1);
					p2 = new Point(x2 + width/2, y2 + height + arrowlength);
				} else if (y1 + height + arrowlength <= y2) {
					p1 = new Point(x1 + width/2, y1 + height);
					p2 = new Point(x2 + width/2, y2 - arrowlength);
				}
			}
		} else {
			if (x1 >= x2 + width + arrowlength) {
				p1 = new Point(x1, y1 + height/2);
				p2 = new Point(x2 + width + arrowlength, y2 + height/2);
			} else {
				if (y1 >= y2 + height + arrowlength) {
					p1 = new Point(x1 + width, y1);
					p2 = new Point(x2 + width/2, y2 + height + arrowlength);
				} else if (y1 + height + arrowlength <= y2) {
					p1 = new Point(x1 + width/2, y1 + height);
					p2 = new Point(x2 + width/2, y2 - arrowlength);
				}
			}
		}
		update();
	}
	
	public Point getLocation1() {
		return p1;
	}
	
	public Point getLocation2() {
		return p2;
	}
	
	public void paintDependency(Graphics g) {
		Connector cl = new Connector(c1, c2, 16);
		cl.paintConnector(g);
		update();
		arrow.paintGeneralizationArrow(g);
	}	
}
