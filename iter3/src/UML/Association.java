package UML;

import java.awt.Graphics;
import java.awt.Point;

public class Association implements Relationship{
	private Class c1, c2;
	private Point p1, p2;
	public Association(Class c1, Class c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
public Arrow getArrow() {
	return null;
	
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
			if (x1 + width <= x2) {
				p1 = new Point(x1 + width, y1 + height);
				p2 = new Point(x2, y2 + height/2);
			} else {
				if (y1 >= y2 + height) {
					p1 = new Point(x1 + width/2, y1);
					p2 = new Point(x2 + width/2, y2 + height);
				} else if (y1 + height <= y2) {
					p1 = new Point(x1 + width/2, y1 + height);
					p2 = new Point(x2 + width/2, y2);
				}
			}
		} else {
			if (x1 >= x2 + width) {
				p1 = new Point(x1, y1 + height/2);
				p2 = new Point(x2 + width, y2 + height/2);
			} else {
				if (y1 >= y2 + height) {
					p1 = new Point(x1 + width/2, y1);
					p2 = new Point(x2 + width/2, y2 + height);
				} else if (y1 + height <= y2) {
					p1 = new Point(x1 + width/2, y1 + height);
					p2 = new Point(x2 + width/2, y2);
				}
			}
		}
	}
	
	public void setClass1(Class c1) {
		this.c1 = c1;
		update();
	}	

	public void setClass2(Class c2) {
		this.c2 = c2;
		update();
	}
	
	public void update() {}
	
	public Point getLocation1() {
		return p1;
	}
	
	public Point getLocation2() {
		return p2;
	}
	
	public void paintAssociation(Graphics g) {
		Connector c = new Connector(c1, c2, 0);
		c.paintConnector(g);
	}
	
}
