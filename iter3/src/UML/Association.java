package UML;

import java.awt.Point;

public class Association {
	private Class class1, class2;
	private Point p1, p2;
	public Association() {

	}

	public void setClass1(Class c1) {
		class1 = c1;
	}	

	public void setClass2(Class c2) {
		class2 = c2;
	}

	public Class getClass1() {
		return class1;
	}

	public Class getClass2() {
		return class2;
	}
	
	public void setLocation() {
		int x1 = class1.getLocation().x, x2 = class2.getLocation().x, y1 = class1.getLocation().y, y2 = class2.getLocation().y;
		int width = class1.getWidth();
		int height = class1.getHeight();
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
	
/*	public boolean contains(Point p) {
		
	}
	*/
	public Point getLocation1() {
		return p1;
	}
	
	public Point getLocation2() {
		return p2;
	}
	
}
