package UML;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
	Class classToRemove;
	Comment commentToRemove;
	Controller c;
	Point p1;
	boolean aClassIsSelected = false;
	boolean aCommentIsSelected = false;
	int classBoxLimit = 20;
	int commentBoxLimit = 20;

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

		if (aClassIsSelected == true) {
			/*
			 * if user has clicked on a class box, obtain its coordinates, update them from
			 * the user's mouse's position, and repaint
			 */
			if (c.selectedClass.contains(e.getX(), e.getY())) {
				int dx = e.getX() - p1.x;
				int dy = e.getY() - p1.y;
				c.selectedClass.setLocation(c.selectedClass.x + dx, c.selectedClass.y + dy);
				p1 = e.getPoint();
				c.repaint();
			}

			/*
			 * if user has clicked on a comment box, obtain its coordinates, update them
			 * from the user's mouse's position, and repaint
			 */
			if (aCommentIsSelected == true) {
				if (c.selectedComment.contains(e.getX(), e.getY())) {
					int dx = e.getX() - p1.x;
					int dy = e.getY() - p1.y;
					c.selectedComment.setLocation(c.selectedComment.x + dx, c.selectedComment.y + dy);
					p1 = e.getPoint();
					c.repaint();
				}
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
		// store coordinates of user's mouse click
		p1 = new Point(e.getX(), e.getY());

		if (c.deleteMode == true) {
			// if user is in delete mode and the mouse clicked inside a class box,
			// note that we are going to remove that class box
			for (Class classBox : c.classBoxes) {
				if (classBox.contains(p1.x, p1.y)) {
					classToRemove = classBox;
				}
			}

			// if user is in delete mode and the mouse clicked inside a comment box,
			// note that we are going to remove that comment box
			for (Comment commentBox : c.commentBoxes) {
				if (commentBox.contains(p1.x, p1.y)) {
					commentToRemove = commentBox;
				}
			}

			// remove classes and comments that we have clicked on while in delete mode
			c.classBoxes.remove(classToRemove);
			c.commentBoxes.remove(commentToRemove);
			c.repaint();
		}

		if (c.classMode == true) {
			// if user is in class mode and there are less than 20 class boxes on
			// the screen, then create a new class box at the user's mouse's coordinates
			if (c.classBoxes.size() < classBoxLimit) {
				c.classBoxes.add(new Class(p1.x, p1.y));
				c.repaint();
			}
		}

		if (c.commentMode == true) {
			// if user is in comment mode and there are less than 20 comment boxes on
			// the screen, then create a new comment box at the user's mouse's coordinates
			if (c.commentBoxes.size() < commentBoxLimit) {
				c.commentBoxes.add(new Comment(p1.x, p1.y));
				c.repaint();
			}
		}

		if (c.associationMode == true) {
			// if user is in association mode, check if there is a class box
			// at the coordinate of the mouse click and store that box to have an
			// association drawn(association will be drawn between first and second
			// class boxes clicked (if an odd number of boxes clicked, the last box will
			// not have a relationship until an even number completes it)
			for (Class classBox : c.classBoxes) {
				if (classBox.contains(p1.x, p1.y)) {
					c.associatedClasses.add(classBox);
					c.repaint();
				}
			}
		}

		// if user is in generalization mode, check if there is a class box
		// at the coordinate of the mouse click and store that box to have a
		// generalization drawn(generalization will be drawn between first and second
		// class boxes clicked (if an odd number of boxes clicked, the last box will
		// not have a relationship until an even number completes it)
		if (c.generalizationMode == true) {
			for (Class classBox : c.classBoxes) {
				if (classBox.contains(p1.x, p1.y)) {
					c.generalizedClasses.add(classBox);
					c.repaint();
				}
			}
		}

		// if user is in dependency mode, check if there is a class box
		// at the coordinate of the mouse click and store that box to have a
		// dependency drawn(dependency will be drawn between first and second
		// class boxes clicked (if an odd number of boxes clicked, the last box will
		// not have a relationship until an even number completes it)
		if (c.dependencyMode == true) {
			for (Class classBox : c.classBoxes) {
				if (classBox.contains(p1.x, p1.y)) {
					c.dependedClasses.add(classBox);
					c.repaint();
				}
			}

		}

		// if user is in aggregation mode, check if there is a class box
		// at the coordinate of the mouse click and store that box to have an
		// aggregation drawn(aggregation will be drawn between first and second
		// class boxes clicked (if an odd number of boxes clicked, the last box will
		// not have a relationship until an even number completes it)
		if (c.aggregationMode == true) {
			for (Class classBox : c.classBoxes) {
				if (classBox.contains(p1.x, p1.y)) {
					c.aggregatedClasses.add(classBox);
					c.repaint();
				}
			}
		}

		// if user is in composition mode, check if there is a class box
		// at the coordinate of the mouse click and store that box to have a
		// composition drawn(composition will be drawn between first and second
		// class boxes clicked (if an odd number of boxes clicked, the last box will
		// not have a relationship until an even number completes it)
		if (c.compositionMode == true) {
			for (Class classBox : c.classBoxes) {
				if (classBox.contains(p1.x, p1.y)) {
					c.compositedClasses.add(classBox);
					c.repaint();
				}
			}
		}

		if (c.selectMode == true) {
			// if user is in select mode, and the mouse click's coordinates
			// are contained within a class box, that box will be moveable by dragging
			for (Class classBox : c.classBoxes) {
				if (classBox.contains(p1)) {
					// set the "inspector-like" functions to visible
					c.selectedClass = classBox;
					aClassIsSelected = true;
					c.v.okayButton.setVisible(true);
					c.v.titleLabel.setVisible(true);
					c.v.title.setText(c.selectedClass.name);
					c.v.title.setVisible(true);
					c.v.attsLabel.setVisible(true);
					c.v.atts.setText(c.selectedClass.attributes);
					c.v.atts.setVisible(true);
					c.v.opsLabel.setVisible(true);
					c.v.ops.setText(c.selectedClass.operations);
					c.v.ops.setVisible(true);
					break;
				} else {
					// a class is not selected so make "inspector-like" function invisible
					c.selectedClass = null;
					aClassIsSelected = false;
					c.v.okayButton.setVisible(false);
					c.v.titleLabel.setVisible(false);
					c.v.title.setVisible(false);
					c.v.attsLabel.setVisible(false);
					c.v.atts.setVisible(false);
					c.v.opsLabel.setVisible(false);
					c.v.ops.setVisible(false);
				}
			}

			// if user is in select mode, and the mouse click's coordinates
			// are contained within a comment box, that box will be moveable by dragging
			for (Comment commentBox : c.commentBoxes) {
				if (commentBox.contains(p1.x, p1.y)) {
					c.selectedComment = commentBox;
					aCommentIsSelected = true;
					break;
				} else {
					aCommentIsSelected = false;
				}
			}
		}
	}
}
