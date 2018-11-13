package UML;

import java.awt.Graphics;

public class Relationship {
	private Class c1, c2;
	private String relationship;

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
		int a = 0, c = 0, b = 0, d = 0, arrowlength = 16;
		int x1 = c1.getLocation().x, x2 = c2.getLocation().x, y1 = c1.getLocation().y, y2 = c2.getLocation().y;
		int width = c1.getWidth();
		int height = c1.getHeight();

		if (relationship == "generalization" || relationship == "dependency" || relationship == "aggregation"
				|| relationship == "composition") {
			arrowlength = 16;
		} else if (relationship == "association") {
			arrowlength = 0;
		}

		if (x1 < x2) {
			if (x1 + width + arrowlength <= x2) {
				g.drawLine(x1 + width, y1 + height / 2, x2 - arrowlength, y2 + height / 2);
				if (relationship != "dependency") {
					a = x2 - arrowlength;
					c = y2 + height / 2;
					b = x2;
					d = y2 + height / 2;
				} else {
					a = x1 + width;
					c = y1 + height / 2;
					b = x2 - arrowlength;
					d = y2 + height / 2;
				}
			} else {
				if (y1 >= y2 + height + arrowlength) {
					g.drawLine(x1 + width / 2, y1, x2 + width / 2, y2 + height + arrowlength);
					if (relationship != "dependency") {
						a = x2 + width / 2;
						c = y2 + height + arrowlength;
						b = x2 + width / 2;
						d = y2 + height;
					} else {
						a = x1 + width / 2;
						c = y1;
						b = x2 + width / 2;
						d = y2 + height + arrowlength;
					}
				} else if (y1 + height + arrowlength <= y2) {
					g.drawLine(x1 + width / 2, y1 + height, x2 + width / 2, y2 - arrowlength);
					if (relationship != "dependency") {
						a = x2 + width / 2;
						c = y2 - arrowlength;
						b = x2 + width / 2;
						d = y2;
					} else {
						a = x1 + width / 2;
						c = y1 + height;
						b = x2 + width / 2;
						d = y2 - arrowlength;
					}
				}
			}
		} else {
			if (x1 >= x2 + width + arrowlength) {
				g.drawLine(x1, y1 + height / 2, x2 + width + arrowlength, y2 + height / 2);
				if (relationship != "dependency") {
					a = x2 + width + arrowlength;
					c = y2 + height / 2;
					b = x2 + width;
					d = y2 + height / 2;
				} else {
					a = x1;
					c = y1 + height / 2;
					b = x2 + width + arrowlength;
					d = y2 + height / 2;
				}
			} else {
				if (y1 >= y2 + height + arrowlength) {
					g.drawLine(x1 + width / 2, y1, x2 + width / 2, y2 + height + arrowlength);
					if (relationship != "dependency") {
						a = x2 + width / 2;
						c = y2 + height + arrowlength;
						b = x2 + width / 2;
						d = y2 + height;
					} else {
						a = x1 + width / 2;
						c = y1;
						b = x2 + width / 2;
						d = y2 + height + arrowlength;
					}
				} else if (y1 + height + arrowlength <= y2) {
					g.drawLine(x1 + width / 2, y1 + height, x2 + width / 2, y2 - arrowlength);
					if (relationship != "dependency") {
						a = x2 + width / 2;
						c = y2 - arrowlength;
						b = x2 + width / 2;
						d = y2;
					} else {
						a = x1 + width / 2;
						c = y1 + height;
						b = x2 + width / 2;
						d = y2 - arrowlength;
					}
				}
			}
		}

		if (relationship == "generalization") {
			GeneralizationArrow generalization = new GeneralizationArrow(c1, c2, a, c, b, d);
			generalization.paintGeneralizationArrow(g);
		}
		if (relationship == "aggregation") {
			AggregationArrow aggregation = new AggregationArrow(c1, c2, a, c, b, d);
			aggregation.paintAggregationArrow(g);
		}
		if (relationship == "dependency") {
			DependencyArrow dependency = new DependencyArrow(c1, c2, a, c, b, d);
			dependency.paintDependencyArrow(g);
		}
		if (relationship == "composition") {
			CompositionArrow composition = new CompositionArrow(c1, c2, a, c, b, d);
			composition.paintCompositionArrow(g);
		}
	}
}