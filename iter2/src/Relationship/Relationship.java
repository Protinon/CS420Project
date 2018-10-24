package Relationship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import UML.UMLClass;

@SuppressWarnings("serial")
public class Relationship extends JComponent{
	
	protected final UMLClass uClass1;
	protected final UMLClass uClass2;

	public Relationship(UMLClass uClass1, UMLClass uClass2) {
		this.uClass1 = uClass1;
		this.uClass2 = uClass2;
		uClass1.addComponentListener(new Updater(this));
		uClass2.addComponentListener(new Updater(this));
		this.updatePosition(uClass1);
	}
	
	// Paint a line from one corner to the other
	// based on the component bounds
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Rectangle bounds = super.getBounds();
		
		Point c1 = getCenter(uClass1);
		Point c2 = getCenter(uClass2);
		g2.setColor(Color.BLACK);

		if (c1.x > c2.x && c1.y > c2.y || c1.x < c2.x && c1.y < c2.y) {
			paintLine(g2, 0, 0, bounds.width, bounds.height);
		}
		else {
			paintLine(g2, 0, bounds.height, bounds.width, 0);
		}
	}
	
	// Subclasses should overload this to paint different types of lines
	protected void paintLine(Graphics2D g2, int x1, int y1, int x2, int y2) {
		g2.drawLine(x1, y1, x2, y2);
	}
	
	
	// Find where uClass1 is relative to uClass2
	// Get the appropriate edge to put this line on
	// Call setB() with the found direction
	public void updatePosition(UMLClass uClass) {
		UMLClass updatedClass = uClass1;
		UMLClass staticClass = uClass2;
		if (uClass == uClass2) {
			updatedClass = uClass2;
			staticClass = uClass1;
		}
		
		// Get two corners to act as vectors extending from the center
		Point corner1 = staticClass.getLocation();
		Point corner2 = new Point(corner1.x, corner1.y + staticClass.getHeight());
		Point center = getCenter(staticClass);
		
		// Evaluate the updated class position at both vectors
		int y = updatedClass.getY();
		int y1 = evaluate(center, corner1, updatedClass.getLocation());
		int y2 = evaluate(center, corner2, updatedClass.getLocation());

		// Based on the evaluated y position, 
		// Figure out which quadrant the moved class is in 
		Point direction;
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
		setB(direction);
	}
	
	// Uses the outer edge of both classes to set the
	// component position and size
	private void setB(Point direction) {
		Point p1 = getEdge(uClass1, direction);
		Point p2 = getEdge(uClass2, new Point(direction.x * -1, direction.y * -1));
		int minX = Math.min(p1.x, p2.x);
		int maxX = Math.max(p1.x, p2.x);
		int minY = Math.min(p1.y, p2.y);
		int maxY = Math.max(p1.y, p2.y);
		Rectangle rect = new Rectangle(minX, minY, maxX - minX, maxY - minY);
		super.setBounds(rect);
	}
	
	// Given a uClass and direction,
	// return a point on the outer edge of the class
	protected Point getEdge(UMLClass uClass, Point direction) {
		Point center = getCenter(uClass);
		Point centerOffset = new Point(center.x - uClass.getX(), center.y - uClass.getY());
		return new Point(center.x + (centerOffset.x * direction.x), center.y + (centerOffset.y * direction.y));
	}
	
	// Get the center point of a uClass
	protected Point getCenter(UMLClass uClass) {
		int x = uClass.getX() + uClass.getWidth() / 2;
		int y = uClass.getY() + uClass.getHeight() / 2;
		return new Point(x, y);
	}
	
	// Get the slope of a line extending from the center of a class to the corner
	// Use that to evaluate at point p
	protected int evaluate(Point center, Point corner, Point p) {
		float slope = ((float)corner.y - (float)center.y) / ((float)corner.x - (float)center.x);
		//System.out.println("Slope: " + slope);
		float diff =  (float)corner.y - ((float)corner.x - (float)p.x) * slope;
		return p.y - (int)diff;
	}
}
