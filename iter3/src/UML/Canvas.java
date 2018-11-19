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
		
		for (Association a : c.getAssociations()) {
			if (a.getClass1()!= null && a.getClass2()!=null) {
				a.paintAssociation(g);
			}
		}
		
		for(Generalization gl : c.getGeneralizations()) {
			if(gl.getClass1() != null && gl.getClass2() != null) {
					gl.paintGeneralization(g);		
				}
		}

		for(Dependency d : c.getDependencies()) {
			if(d.getClass1() != null && d.getClass2() != null) {
				d.paintDependency(g);
			}
		}
		
		for(Aggregation a : c.getAggregations()) {
			if(a.getClass1() != null && a.getClass2() != null) {
				a.paintAggregation(g);
				}
		}
		
		for(Composition c : c.getCompositions()) {
			
			if(c.getClass1() != null && c.getClass2() != null) {
				c.paintComposition(g);
			}
		}
	}

	public void overriddenPaintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
