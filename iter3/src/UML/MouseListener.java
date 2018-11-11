package UML;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
	Controller c;
	Point p1;

	/**
	 * Initializes this mouse listener to be associated with a controller.
	 * 
	 * @author Bri Long
	 * @param c1 controller object associated with this mouse listener
	 * @return void
	 **/
	public MouseListener(Controller c1) {
		c = c1;
	}

	/**
	 * Allows user to click a comment or class box and drag it across the right
	 * panel.
	 * 
	 * @author Bri Long
	 * @param e - MouseEvent - coordinate of cursor location as it is drug across
	 *          the right panel.
	 * @return void
	 **/
	@Override
	public void mouseDragged(MouseEvent e) {

		if (c.classSelected() == true) {
			/*
			 * if user has clicked on a class box, obtain its coordinates, update them from
			 * the user's mouse's position, and repaint
			 */
			if (c.getSelectedClass().contains(e.getX(), e.getY())) {
				int dx = e.getX() - p1.x;
				int dy = e.getY() - p1.y;
				if (c.getSelectedClass().getLocation().x + dx >= 0 && c.getSelectedClass().getLocation().y + dy >= 0
						&& (c.getSelectedClass().getLocation().x + c.getSelectedClass().getWidth() + dx) <= c.getWidth()
						&& (c.getSelectedClass().getLocation().y + c.getSelectedClass().getHeight() + dy) <= c
								.getHeight()) {
					for (Class c3 : c.getClasses()) {
						if (c3 != c.getSelectedClass()) {
							Rectangle r = new Rectangle(c3.getLocation().x - 16, c3.getLocation().y - 16,
									c3.getWidth() + 32, c3.getHeight() + 32);
							if (r.contains(c.getSelectedClass().getLocation().x + dx,
									c.getSelectedClass().getLocation().y + dy)
									|| r.contains(
											c.getSelectedClass().getLocation().x + c.getSelectedClass().getWidth() + dx,
											c.getSelectedClass().getLocation().y + dy)
									|| r.contains(
											c.getSelectedClass().getLocation().x + c.getSelectedClass().getWidth() + dx,
											c.getSelectedClass().getLocation().y + c.getSelectedClass().getHeight()
													+ dy)
									|| r.contains(c.getSelectedClass().getLocation().x + dx,
											c.getSelectedClass().getLocation().y + c.getSelectedClass().getHeight()
													+ dy)) {
								break;
							} else {
								c.getSelectedClass().setLocation(c.getSelectedClass().getLocation().x + dx,
										c.getSelectedClass().getLocation().y + dy);
							}
						}
					}
				}
				p1 = e.getPoint();
				c.repaint();
			}
		}

		/*
		 * if user has clicked on a comment box, obtain its coordinates, update them
		 * from the user's mouse's position, and repaint
		 */
		if (c.commentSelected() == true) {
			if (c.getSelectedComment().contains(e.getX(), e.getY())) {
				int dx = e.getX() - p1.x;
				int dy = e.getY() - p1.y;
				if (c.getSelectedComment().getLocation().x + dx >= 0 && c.getSelectedComment().getLocation().y + dy >= 0
						&& (c.getSelectedComment().getLocation().x + c.getSelectedComment().getWidth() + dx) <= c
								.getWidth()
						&& (c.getSelectedComment().getLocation().y + c.getSelectedComment().getHeight() + dy) <= c
								.getHeight()) {
					c.getSelectedComment().setLocation(c.getSelectedComment().getLocation().x + dx,
							c.getSelectedComment().getLocation().y + dy);
				}
				p1 = e.getPoint();
				c.repaint();
			}
		}
	}

	/**
	 * Defines different functions for a user's mouse click depending on the mode
	 * the editor is in.
	 * 
	 * @author Bri Long
	 * @param e - MouseEvent - coordinate of cursor location when it clicks in right
	 *          panel.
	 * @return void
	 **/
	@Override
	public void mousePressed(MouseEvent e) {
		p1 = new Point(e.getX(), e.getY());

		if (c.deleteMode() == true) {
			c.deleteObject(p1);
		}

		if (c.classMode() == true) {
			c.addClass(p1);
		}

		if (c.commentMode() == true) {
			c.addComment(p1);
		}

		if (c.associationMode() == true) {
			c.addAssociation(p1);
		}

		if (c.generalizationMode() == true) {
			c.addGeneralization(p1);
		}

		if (c.dependencyMode() == true) {
			c.addDependency(p1);
		}

		if (c.aggregationMode() == true) {
			c.addAggregation(p1);
		}

		if (c.compositionMode() == true) {
			c.addComposition(p1);
		}

		if (c.selectMode() == true) {
			c.selectObject(p1);
		}
	}
}
