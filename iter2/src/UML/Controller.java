package UML;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Controller extends JPanel {
	private static final long serialVersionUID = 1L;

	ArrayList<Class> generalizedClasses = new ArrayList<Class>();
	ArrayList<Class> classBoxes = new ArrayList<Class>();
	ArrayList<Comment> commentBoxes = new ArrayList<Comment>();
	ArrayList<Class> associatedClasses = new ArrayList<Class>();
	ArrayList<Class> dependedClasses = new ArrayList<Class>();
	ArrayList<Class> aggregatedClasses = new ArrayList<Class>();
	ArrayList<Class> compositedClasses = new ArrayList<Class>();

	boolean aClassIsSelected = false;
	boolean aCommentIsSelected = false;
	boolean selectMode = false;
	boolean deleteMode = false;
	boolean classMode = false;
	boolean commentMode = false;
	boolean aggregationMode = false;
	boolean dependencyMode = false;
	boolean associationMode = false;
	boolean compositionMode = false;
	boolean generalizationMode = false;

	Point p1;
	Class selectedClass;
	Comment selectedComment;

	int classBoxLimit = 20;
	int commentBoxLimit = 20;

	public Controller(View v) {

		setBackground(Color.WHITE);

		/*
		 * if user clicks select button, all modes besides select are falsified, meaning
		 * that the user can click and drag objects.
		 */
		v.selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {

				deleteMode = false;
				classMode = false;
				commentMode = false;
				aggregationMode = false;
				dependencyMode = false;
				associationMode = false;
				compositionMode = false;
				generalizationMode = false;
				selectMode = true;

			}
		});

		/*
		 * if user clicks class button, all modes besides class are falsified, meaning
		 * that the user can create class boxes by clicking the desired position in the
		 * right pane.
		 */
		v.classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deleteMode = false;
				classMode = true;
				commentMode = false;
				aggregationMode = false;
				dependencyMode = false;
				associationMode = false;
				compositionMode = false;
				generalizationMode = false;
				selectMode = false;

			}
		});

		/*
		 * if user clicks comment button, all modes besides comment are falsified,
		 * meaning that the user can create comment boxes by clicking the desired
		 * position in the right pane.
		 */
		v.commentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deleteMode = false;
				classMode = false;
				commentMode = true;
				aggregationMode = false;
				dependencyMode = false;
				associationMode = false;
				compositionMode = false;
				generalizationMode = false;
				selectMode = false;

			}
		});

		/*
		 * if user clicks aggregation button, all modes besides aggregation are
		 * falsified, meaning that the user may then click on 2 class boxes for an
		 * aggregation relationship to be drawn between them.
		 */
		v.aggregationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deleteMode = false;
				classMode = false;
				commentMode = false;
				aggregationMode = true;
				dependencyMode = false;
				associationMode = false;
				compositionMode = false;
				generalizationMode = false;
				selectMode = false;

			}
		});

		/*
		 * if user clicks generalization button, all modes besides generalization are
		 * falsified, meaning that the user may then click on 2 class boxes for a
		 * generalization relationship to be drawn between them.
		 */
		v.generalizationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deleteMode = false;
				classMode = false;
				commentMode = false;
				aggregationMode = false;
				dependencyMode = false;
				associationMode = false;
				compositionMode = false;
				generalizationMode = true;
				selectMode = false;

			}
		});

		/*
		 * if user clicks dependency button, all modes besides dependency are falsified,
		 * meaning that the user may then click on 2 class boxes for a dependency
		 * relationship to be drawn between them.
		 */
		v.dependencyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deleteMode = false;
				classMode = false;
				commentMode = false;
				aggregationMode = false;
				dependencyMode = true;
				associationMode = false;
				compositionMode = false;
				generalizationMode = false;
				selectMode = false;

			}
		});

		/*
		 * if user clicks association button, all modes besides association are
		 * falsified, meaning that the user may then click on 2 class boxes for an
		 * association relationship to be drawn between them.
		 */
		v.associationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deleteMode = false;
				classMode = false;
				commentMode = false;
				aggregationMode = false;
				dependencyMode = false;
				associationMode = true;
				compositionMode = false;
				generalizationMode = false;
				selectMode = false;

			}
		});

		/*
		 * if user clicks composition button, all modes besides composition are
		 * falsified, meaning that the user may then click on 2 class boxes for a
		 * composition relationship to be drawn between them.
		 */
		v.compositionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deleteMode = false;
				classMode = false;
				commentMode = false;
				aggregationMode = false;
				dependencyMode = false;
				associationMode = false;
				compositionMode = true;
				generalizationMode = false;
				selectMode = false;

			}
		});

		/*
		 * if user clicks delete button, all modes besides delete are falsified, meaning
		 * that the user may then click on any class boxes or comments to remove them
		 * from the pane.
		 */
		v.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {

				deleteMode = true;
				classMode = false;
				commentMode = false;
				aggregationMode = false;
				dependencyMode = false;
				associationMode = false;
				compositionMode = false;
				generalizationMode = false;
				selectMode = false;

			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				
				if (aClassIsSelected == true) {
					/*
					 * if user has clicked on a class box, obtain its coordinates, update them from
					 * the user's mouse's position, and repaint
					 */
					if (selectedClass.contains(e.getX(), e.getY())) {
						int dx = e.getX() - p1.x;
						int dy = e.getY() - p1.y;
						selectedClass.setLocation(selectedClass.x + dx, selectedClass.y + dy);
						p1 = e.getPoint();
						repaint();
					}

					/*
					 * if user has clicked on a comment box, obtain its coordinates, update them
					 * from the user's mouse's position, and repaint
					 */
					if (aCommentIsSelected == true) {
						if (selectedComment.contains(e.getX(), e.getY())) {
							int dx = e.getX() - p1.x;
							int dy = e.getY() - p1.y;
							selectedComment.setLocation(selectedComment.x + dx, selectedComment.y + dy);
							p1 = e.getPoint();
							repaint();
						}

					}
				}

			}
		});

		this.addMouseListener(new MouseAdapter() {

			Class classToRemove;
			Comment commentToRemove;

			@Override
			public void mousePressed(MouseEvent e) {
				// store coordinates of user's mouse click
				p1 = new Point(e.getX(), e.getY());

				if (deleteMode == true) {
					// if user is in delete mode and the mouse clicked inside a class box,
					// note that we are going to remove that class box
					for (Class classBox : classBoxes) {
						if (classBox.contains(p1.x, p1.y)) {
							classToRemove = classBox;
						}
					}
					// delete relationship associated with the class box we want to remove - this is
					// buggy
					for (int i = associatedClasses.size() - 1; i >= 0; --i) {
						if (associatedClasses.size() % 2 != 0) {
							associatedClasses.remove(associatedClasses.size() - 1);
						}
						if (associatedClasses.get(i).contains(p1.x, p1.y)) {
							if (i % 2 == 0) {
								associatedClasses.remove(i + 1);
								associatedClasses.remove(i);
							} else {
								associatedClasses.remove(i);
								associatedClasses.remove(i - 1);
								i--;
							}
						}
					}
					// if user is in delete mode and the mouse clicked inside a comment box,
					// note that we are going to remove that comment box
					for (Comment commentBox : commentBoxes) {
						if (commentBox.contains(p1.x, p1.y)) {
							commentToRemove = commentBox;
						}
					}

					// remove classes and comments that we have clicked on while in delete mode
					classBoxes.remove(classToRemove);
					commentBoxes.remove(commentToRemove);
					repaint();
				}

				if (classMode == true) {
					// if user is in class mode and there are less than 20 class boxes on
					// the screen, then create a new class box at the user's mouse's coordinates
					if (classBoxes.size() < classBoxLimit) {
						classBoxes.add(new Class(p1.x, p1.y));
						repaint();
					}
				}

				if (commentMode == true) {
					// if user is in comment mode and there are less than 20 comment boxes on
					// the screen, then create a new comment box at the user's mouse's coordinates
					if (commentBoxes.size() < commentBoxLimit) {
						commentBoxes.add(new Comment(p1.x, p1.y));
						repaint();
					}
				}

				if (associationMode == true) {
					// if user is in association mode, check if there is a class box
					// at the coordinate of the mouse click and store that box to have an
					// association drawn(association will be drawn between first and second
					// class boxes clicked (if an odd number of boxes clicked, the last box will
					// not have a relationship until an even number completes it)
					for (Class classBox : classBoxes) {
						if (classBox.contains(p1.x, p1.y)) {
							associatedClasses.add(classBox);
							repaint();
						}
					}
				}

				// if user is in generalization mode, check if there is a class box
				// at the coordinate of the mouse click and store that box to have a
				// generalization drawn(generalization will be drawn between first and second
				// class boxes clicked (if an odd number of boxes clicked, the last box will
				// not have a relationship until an even number completes it)
				if (generalizationMode == true) {
					for (Class classBox : classBoxes) {
						if (classBox.contains(p1.x, p1.y)) {
							generalizedClasses.add(classBox);
							repaint();
						}
					}
				}

				// if user is in dependency mode, check if there is a class box
				// at the coordinate of the mouse click and store that box to have a
				// dependency drawn(dependency will be drawn between first and second
				// class boxes clicked (if an odd number of boxes clicked, the last box will
				// not have a relationship until an even number completes it)
				if (dependencyMode == true) {
					for (Class classBox : classBoxes) {
						if (classBox.contains(p1.x, p1.y)) {
							dependedClasses.add(classBox);
							repaint();
						}
					}

				}

				// if user is in aggregation mode, check if there is a class box
				// at the coordinate of the mouse click and store that box to have an
				// aggregation drawn(aggregation will be drawn between first and second
				// class boxes clicked (if an odd number of boxes clicked, the last box will
				// not have a relationship until an even number completes it)
				if (aggregationMode == true) {
					for (Class classBox : classBoxes) {
						if (classBox.contains(p1.x, p1.y)) {
							aggregatedClasses.add(classBox);
							repaint();
						}
					}
				}

				// if user is in composition mode, check if there is a class box
				// at the coordinate of the mouse click and store that box to have a
				// composition drawn(composition will be drawn between first and second
				// class boxes clicked (if an odd number of boxes clicked, the last box will
				// not have a relationship until an even number completes it)
				if (compositionMode == true) {
					for (Class classBox : classBoxes) {
						if (classBox.contains(p1.x, p1.y)) {
							compositedClasses.add(classBox);
							repaint();
						}
					}
				}

				if (selectMode == true) {
					// if user is in select mode, and the mouse click's coordinates
					// are contained within a class box, that box will be moveable by dragging
					for (Class classBox : classBoxes) {
						if (classBox.contains(p1)) {
							selectedClass = classBox;
							aClassIsSelected = true;
						}
					}

					// if user is in select mode, and the mouse click's coordinates
					// are contained within a comment box, that box will be moveable by dragging
					for (Comment commentBox : commentBoxes) {
						if (commentBox.contains(p1.x, p1.y)) {
							selectedComment = commentBox;
							aCommentIsSelected = true;
						}
					}

				}
			}
		});

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// paint all classes user has created
		for (Class classBox : classBoxes) {
			classBox.paintClass(g);
		}

		// paint all comments user has created
		for (Comment commentBox : commentBoxes) {
			commentBox.paintComment(g);
		}

		// if there are at least 2 classes in associatedClasses,
		// paint association between 1st and 2nd classes, 3rd and 4th etc
		if (associatedClasses.size() > 1) {
			for (int i = 0; i < associatedClasses.size() - 1; i += 2) {
				Class c1 = associatedClasses.get(i);
				Class c2 = associatedClasses.get(i + 1);
				Relationship ir = new Relationship("Association", c1, c2);
				ir.paintRelationship(g);

			}
		}

		// if there are at least 2 classes in generalizedClasses,
		// paint generalization between 1st and 2nd classes, 3rd and 4th etc
		if (generalizedClasses.size() > 1) {
			for (int i = 0; i < generalizedClasses.size() - 1; i += 2) {
				Class c1 = generalizedClasses.get(i);
				Class c2 = generalizedClasses.get(i + 1);
			}
		}

		// if there are at least 2 classes in dependedClasses,
		// paint dependency between 1st and 2nd classes, 3rd and 4th etc
		if (dependedClasses.size() > 1) {
			for (int i = 0; i < dependedClasses.size() - 1; i += 2) {
				Class c1 = dependedClasses.get(i);
				Class c2 = dependedClasses.get(i + 1);
			}
		}

		// if there are at least 2 classes in aggregatedClasses,
		// paint aggregation between 1st and 2nd classes, 3rd and 4th etc
		if (aggregatedClasses.size() > 1) {
			for (int i = 0; i < aggregatedClasses.size() - 1; i += 2) {
				Class c1 = aggregatedClasses.get(i);
				Class c2 = aggregatedClasses.get(i + 1);
			}
		}

		// if there are at least 2 classes in compositedClasses,
		// paint composition between 1st and 2nd classes, 3rd and 4th etc
		if (compositedClasses.size() > 1) {
			for (int i = 0; i < compositedClasses.size() - 1; i += 2) {
				Class c1 = compositedClasses.get(i);
				Class c2 = compositedClasses.get(i + 1);
			}
		}
	}
}
