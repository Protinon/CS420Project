package Relationship;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;

import UML.UMLClass;

public class Relationship extends JComponent{
	
	private final UMLClass uClass1;
	private final UMLClass uClass2;
	Point offset1;
	Point offset2;
	Point direction;

	public Relationship(UMLClass uClass1, UMLClass uClass2) {
		this.uClass1 = uClass1;
		this.uClass2 = uClass2;
		uClass1.addComponentListener(new Updater(this));
		uClass2.addComponentListener(new Updater(this));
		this.updatePosition(uClass1);
		setB();
	}
	
	public void updatePosition(UMLClass uClass) {
		UMLClass updatedClass = uClass1;
		UMLClass staticClass = uClass2;
		if (uClass == uClass2) {
			updatedClass = uClass2;
			staticClass = uClass1;
		}
		
		Point corner1 = staticClass.getLocation();
		Point corner2 = new Point(corner1.x, corner1.y + staticClass.getHeight());
		Point center = getCenter(staticClass);
		
		int y = updatedClass.getY();
		int y1 = evaluate(center, corner1, updatedClass.getLocation());
		int y2 = evaluate(center, corner2, updatedClass.getLocation());
		/*System.out.println("Class1 y: " + y);
		System.out.println("updatedClass: " + updatedClass.getBounds());
		System.out.println("StaticClass:" + staticClass.getBounds());
		System.out.println("Corner 1: " + corner1);
		System.out.println("Corner 2: " + corner2);
		System.out.println("Center: " + center);
		System.out.println("Line 1: " + y1);
		System.out.println("Line 2: " + y2);
		*/
		if (updatedClass.getBounds().intersects(staticClass.getBounds())) {
			direction = new Point(0, 0);
		}
		else if (y < y1 && y > y2) {
			direction = new Point(1, 0);
		}
		else if (y < y1 && y < y2) {
			direction = new Point(0, 1);
		}
		else if (y > y1 && y < y2) {
			direction = new Point(-1, 0);
		}
		else if (y > y1 && y > y2) {
			direction = new Point(0, -1);
		}
		else {
			direction = new Point(0, 0);
		}
		setB();
	}
	
	public void setB() {
		Point c1 = getCenter(uClass1);
		Point p1 = new Point(c1.x + (c1.x - uClass1.getX()) * direction.x, c1.y + (c1.y - uClass1.getY()) * direction.y);
		Point c2 = getCenter(uClass2);
		Point p2 = new Point(c2.x + (c2.x - uClass2.getX()) * direction.x * -1, c2.y + (c2.y - uClass2.getY()) * direction.y * -1);
		Rectangle rect = new Rectangle(p1.x, p1.y, p2.x, p2.y);
		System.out.println("Direction: " + direction);
		setBounds(rect);
		//System.out.println("Bounds: " + rect);
		super.setBounds(rect);
	}
	
	private Point getCenter(UMLClass uClass) {
		int x = uClass.getX() + uClass.getWidth() / 2;
		int y = uClass.getY() + uClass.getHeight() / 2;
		return new Point(x, y);
	}
	
	private int evaluate(Point center, Point corner, Point p) {
		float slope = ((float)corner.y - (float)center.y) / ((float)corner.x - (float)center.x);
		//System.out.println("Slope: " + slope);
		float diff =  (float)corner.y - ((float)corner.x - (float)p.x) * slope;
		return p.y - (int)diff;
	}
}
