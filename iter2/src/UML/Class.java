/*
 * This will become a class node in the UML design
 * Inheriting from JComponent gives extra useful features and better organization
*/
package UML;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Class extends JComponent {
	private static final long serialVersionUID = -16435718797097829L;

	int x, y, width = 126, height = 72, boxSize = 24;
	String name = "Title", attributes = "Attributes", operations = "Operations";

	// set classes x/y coordinate with passed mouse click coordinate
	public Class(int x1, int y1) {
		x = x1;
		y = y1;
	}

	// check to see if this object contains the passes coordinate
	public boolean contains(int x2, int y2) {
		Rectangle r = new Rectangle(x, y, width, height);
		if (r.contains(x2, y2)) {
			return true;
		}
		return false;
	}

	// update this object's location to passed coordinate
	public void setLocation(int i, int j) {
		x = i;
		y = j;
	}

	protected void paintClass(Graphics g) {
		super.paintComponent(g);

		// draw title box
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, boxSize);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, boxSize);
		g.drawString(name, x + 2, y + 18);

		// draw attributes box
		g.setColor(Color.WHITE);
		g.fillRect(x, y + boxSize, width, height - (boxSize * 2));
		g.setColor(Color.BLACK);
		g.drawRect(x, y + boxSize, width, height - (boxSize * 2));
		g.drawString(attributes, x + 2, y + 42);

		// draw operations box
		g.setColor(Color.WHITE);
		g.fillRect(x, y + (boxSize * 2), width, height - (boxSize * 2));
		g.setColor(Color.BLACK);
		g.drawRect(x, y + (boxSize * 2), width, height - (boxSize * 2));
		g.drawString(operations, x + 2, y + 68);

		// draw box around 3 subboxes ^^
		g.drawRect(x, y, width, height);

	}

	// update classbox title
	public void setName(String newName) {
		name = newName;
		repaint();
	}

	// update classbox attributes
	public void setAttributes(String newAtts) {
		attributes = newAtts;
		repaint();
	}

	// update classbox operations
	public void setOperations(String newOps) {
		operations = newOps;
		repaint();
	}

}
