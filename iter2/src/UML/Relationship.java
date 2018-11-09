package UML;

import java.awt.Graphics;

public class Relationship {
	Class c1, c2;
	String relationship;
	int difference;

	/**
	 * Initializes a relationship to be between 2 class objects and of a specializes
	 * type.
	 * 
	 * @author Bri Long
	 * @param relationship1 - the type of relationship that will be drawn
	 * @param c0            - the "parent" class of the relationship
	 * @param c3            - the "child" class of the relationship
	 **/
	public Relationship(String relationship1, Class c0, Class c3) {
		c1 = c0;
		c2 = c3;
		relationship = relationship1;
	}

	/**
	 * Draws a relationship between two classes, overrides paintComponent.
	 * 
	 * @author Bri Long
	 * @param g - Graphics object
	 * @return void
	 **/
	public void paintRelationship(Graphics g) {
		// will be coordinates for arrow part of relationship
		int x0 = 0, y0 = 0, x1 = 0, y1 = 0, arrowlength = 16;

		if (relationship == "generalization" || relationship == "dependency" || relationship == "aggregation"
				|| relationship == "composition") {
			arrowlength = 16;
		} else if (relationship == "association") {
			arrowlength = 0;
		}

		if (c1.x < c2.x) {
			if (c1.x + c1.width + arrowlength <= c2.x) {
				g.drawLine(c1.x + c1.width, c1.y + c1.height / 2, c2.x - arrowlength, c2.y + c2.height / 2);
				x0 = c2.x - arrowlength;
				y0 = c2.y + c2.height / 2;
				x1 = c2.x;
				y1 = c2.y + c2.height / 2;
			} else {
				if (c1.y >= c2.y + c2.height + arrowlength) {
					g.drawLine(c1.x + c1.width / 2, c1.y, c2.x + c2.width / 2, c2.y + c2.height + arrowlength);
					x0 = c2.x + c2.width / 2;
					y0 = c2.y + c2.height + arrowlength;
					x1 = c2.x + c2.width / 2;
					y1 = c2.y + c2.height;
				} else if (c1.y + c1.height + arrowlength <= c2.y) {
					g.drawLine(c1.x + c1.width / 2, c1.y + c1.height, c2.x + c2.width / 2, c2.y - arrowlength);
					x0 = c2.x + c2.width / 2;
					y0 = c2.y - arrowlength;
					x1 = c2.x + c2.width / 2;
					y1 = c2.y;
				}
			}
		} else {
			if (c1.x >= c2.x + c2.width + arrowlength) {
				g.drawLine(c1.x, c1.y + c1.height / 2, c2.x + c2.width + arrowlength, c2.y + c2.height / 2);
				x0 = c2.x + c2.width + arrowlength;
				y0 = c2.y + c2.height / 2;
				x1 = c2.x + c2.width;
				y1 = c2.y + c2.height / 2;
			} else {
				if (c1.y >= c2.y + c2.height + arrowlength) {
					g.drawLine(c1.x + c1.width / 2, c1.y, c2.x + c2.width / 2, c2.y + c2.height + arrowlength);
					x0 = c2.x + c2.width / 2;
					y0 = c2.y + c2.height + arrowlength;
					x1 = c2.x + c2.width / 2;
					y1 = c2.y + c2.height;
				} else if (c1.y + c1.height + arrowlength <= c2.y) {
					g.drawLine(c1.x + c1.width / 2, c1.y + c1.height, c2.x + c2.width / 2, c2.y - arrowlength);
					x0 = c2.x + c2.width / 2;
					y0 = c2.y - arrowlength;
					x1 = c2.x + c2.width / 2;
					y1 = c2.y;
				}
			}
		}

		if (relationship == "generalization") {
			Generalization generalization = new Generalization(c1, c2, x0, y0, x1, y1);
			generalization.paintGeneralization(g);
		}
		if (relationship == "aggregation") {
			Aggregation aggregation = new Aggregation(c1, c2, x0, y0, x1, y1);
			aggregation.paintAggregation(g);
		}
		if (relationship == "dependency") {
			Dependency dependency = new Dependency(c1, c2, x0, y0, x1, y1);
			dependency.paintDependency(g);
		}
		if (relationship == "composition") {
			Composition composition = new Composition(c1, c2, x0, y0, x1, y1);
			composition.paintComposition(g);
		}
	}
}
