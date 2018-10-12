package Relationship;

import java.awt.Rectangle;
import javax.swing.JComponent;
import UML.UMLMouseListener;

public class Relationship extends JComponent {
	
	public Relationship() {
		this(0, 0, 100, 100);
	}
	
	public Relationship(int x, int y) {
		this(x, y, 100, 100);
	}

	public Relationship(int x, int y, int width, int height) {
		super.setBounds(new Rectangle(x, y, width, height));
		super.setLocation(x, y);

		UMLMouseListener listener = new UMLMouseListener();
		super.addMouseListener(listener);
		super.addMouseMotionListener(listener);
	}
}
