package UML;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Canvas extends JPanel {
	Controller c;

	public Canvas(Controller c) {
		this.c = c;
		this.setBackground(Color.WHITE);
	}

	/**
	 * Paint method that calls all specific paint methods, overwrites
	 * paintComponent.
	 * 
	 * @author Bri Long
	 * @param g Graphics object
	 * @return void
	 **/
	@Override
	public void paintComponent(Graphics g) {
		overriddenPaintComponent(g);

		// paint all classes user has created
		for (Class classBox : c.getClasses()) {
			classBox.paintClass(g);
		}

		// paint all comments user has created
		for (Comment commentBox : c.getComments()) {
			commentBox.paintComment(g);
		}

		// if there are at least 2 classes in associatedClasses,
		// paint association between 1st and 2nd classes, 3rd and 4th etc
		if (c.getAssociations().size() > 1) {
			for (int i = 0; i < c.getAssociations().size() - 1; i += 2) {
				Class c1 = c.getAssociations().get(i);
				Class c2 = c.getAssociations().get(i + 1);
				Relationship ir = new Relationship("association", c1, c2);
				ir.paintRelationship(g);
			}
		}

		// if there are at least 2 classes in generalizedClasses,
		// paint generalization between 1st and 2nd classes, 3rd and 4th etc
		if (c.getGeneralizations().size() > 1) {
			for (int i = 0; i < c.getGeneralizations().size() - 1; i += 2) {
				Class c1 = c.getGeneralizations().get(i);
				Class c2 = c.getGeneralizations().get(i + 1);
				Relationship ir = new Relationship("generalization", c1, c2);
				ir.paintRelationship(g);
			}
		}

		// if there are at least 2 classes in dependedClasses,
		// paint dependency between 1st and 2nd classes, 3rd and 4th etc
		if (c.getDependencies().size() > 1) {
			for (int i = 0; i < c.getDependencies().size() - 1; i += 2) {
				Class c1 = c.getDependencies().get(i);
				Class c2 = c.getDependencies().get(i + 1);
				Relationship ir = new Relationship("dependency", c1, c2);
				ir.paintRelationship(g);
			}
		}

		// if there are at least 2 classes in aggregatedClasses,
		// paint aggregation between 1st and 2nd classes, 3rd and 4th etc
		if (c.getAggregations().size() > 1) {
			for (int i = 0; i < c.getAggregations().size() - 1; i += 2) {
				Class c1 = c.getAggregations().get(i);
				Class c2 = c.getAggregations().get(i + 1);
				Relationship ir = new Relationship("aggregation", c1, c2);
				ir.paintRelationship(g);
			}
		}

		// if there are at least 2 classes in compositedClasses,
		// paint composition between 1st and 2nd classes, 3rd and 4th etc
		if (c.getCompositions().size() > 1) {
			for (int i = 0; i < c.getCompositions().size() - 1; i += 2) {
				Class c1 = c.getCompositions().get(i);
				Class c2 = c.getCompositions().get(i + 1);
				Relationship ir = new Relationship("composition", c1, c2);
				ir.paintRelationship(g);
			}
		}

	}

	public void overriddenPaintComponent(Graphics g) {
		super.paintComponent(g);
	}

}

