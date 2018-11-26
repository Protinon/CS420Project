package UML;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Stack;

public class Controller {
	private Stack<Action> actions = new Stack<Action>();
	private Stack<Action> undoActions = new Stack<Action>();
	private Stack<Action> redoActions = new Stack<Action>();

	private ArrayList<Class> classBoxes = new ArrayList<Class>();
	private ArrayList<Comment> commentBoxes = new ArrayList<Comment>();
	private ArrayList<Association> associations = new ArrayList<Association>();
	private ArrayList<Generalization> generalizations = new ArrayList<Generalization>();
	private ArrayList<Aggregation> aggregations = new ArrayList<Aggregation>();
	private ArrayList<Composition> compositions = new ArrayList<Composition>();
	private ArrayList<Dependency> dependencies = new ArrayList<Dependency>();

	private Relationship selectedRelationship;
	private Class selectedClass;
	private Comment selectedComment;

	private Class copiedClass;
	private Comment copiedComment;

	private boolean aClassIsSelected = false;
	private boolean aCommentIsSelected = false;
	private boolean aRelationshipIsSelected = false;

	private boolean selectMode = false;
	private boolean deleteMode = false;
	private boolean classMode = false;
	private boolean commentMode = false;
	private boolean aggregationMode = false;
	private boolean dependencyMode = false;
	private boolean associationMode = false;
	private boolean compositionMode = false;
	private boolean generalizationMode = false;

	private Point associationPoint1;
	private Point associationPoint2;
	private Point generalizationPoint1;
	private Point generalizationPoint2;
	private Point dependencyPoint1;
	private Point dependencyPoint2;
	private Point compositionPoint1;
	private Point compositionPoint2;
	private Point aggregationPoint1;
	private Point aggregationPoint2;

	private View v;

	private Controller c;

	private Canvas rightPane;

	/**
	 * Constructor for this controller
	 * 
	 * @author Bri Long
	 * @param v1 View object that will be the window that this controller interacts
	 *           with
	 **/
	public Controller() {
		c = this;
		rightPane = new Canvas(this);
		v = new View(rightPane);

		MouseListener m = new MouseListener(this);
		rightPane.addMouseListener(m);
		rightPane.addMouseMotionListener(m);

		fileActionListeners();
		editActionListeners();
		buttonActionListeners();
	}

	/**
	 * Action listeners for v's file tab's functions
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return void
	 **/
	public void fileActionListeners() {
		PageFormat postformat = null;
		PageFormat preformat = null;

		v.fileNew.addActionListener(new ActionListener() {
			/**
			 * Creates a new instance of this UML Editor by creating a new View object.
			 * 
			 * @author Bri Long
			 * @param e ActionEvent - fileNew menu item was clicked by user
			 * @return void
			 **/
			public void actionPerformed(ActionEvent e) {
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Controller c2 = new Controller();
					}
				});
			}
		});

		/**
		 * Opens a file explorer dialog box to open files in their default editors.
		 * 
		 * @author Bri Long
		 * @param e ActionEvent - fileOpen menu item was clicked by user
		 * @return void
		 **/
		v.fileOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		/**
		 * Skeleton for save functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - fileSave menu item was clicked by user
		 * @return void
		 **/
		v.fileSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		/**
		 * Skeleton for Save As functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - fileSaveAs menu item was clicked by user
		 * @return void
		 **/
		v.fileSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		/**
		 * Creates a page setup dialog box to format printing.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - filePageSetup menu item was clicked by user
		 * @return void
		 **/
		v.filePageSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageSetUp(preformat, postformat);
			}
		});

		/**
		 * Creates a page setup dialog box to format printing, and creates a print
		 * dialog box with print functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - filePrint menu item was clicked by user
		 * @return void
		 **/
		v.filePrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob pjob = pageSetUp(preformat, postformat);

				if (preformat != postformat) {
					pjob.setPrintable(new Printer(v.rightPane), postformat);
					if (pjob.printDialog()) {
						try {
							pjob.print();
						} catch (PrinterException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});

		/**
		 * Closes the window from v.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - fileClose menu item was clicked by user
		 * @return void
		 **/
		v.fileClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.frame.dispose();
			}
		});
	}

	/**
	 * Action listeners for v's edit tab's functions
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return void
	 **/
	public void editActionListeners() {
		/**
		 * Skeleton for undo functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - editUndo menu item was clicked by user
		 * @return void
		 **/
		v.editUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Action actionToUndo = actions.pop();
				undoActions.add(actionToUndo);
				actionToUndo.undoAction();
				v.editRedo.setEnabled(true);
				if (actions.isEmpty())
					v.editUndo.setEnabled(false);
				rightPane.repaint();
			}
		});

		/**
		 * Skeleton for redo functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - editRedo menu item was clicked by user
		 * @return void
		 **/
		v.editRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Action actionToRedo = undoActions.pop();
				redoActions.add(actionToRedo);
				actions.add(actionToRedo);
				actionToRedo.doAction();
				if (undoActions.isEmpty()) {
					v.editRedo.setEnabled(false);
				}
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		});

		/**
		 * Skeleton for cut functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - editCut menu item was clicked by user
		 * @return void
		 **/
		v.editCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (classSelected()) {
					copiedClass = getSelectedClass();
					copiedComment = null;
					InspectorAction i = new InspectorAction(getSelectedClass(), v);
					i.undoAction();
					deleteObject(new Point(0, 0));
					rightPane.repaint();
				} else if (commentSelected()) {
					copiedComment = getSelectedComment();
					copiedClass = null;
					deleteObject(new Point(0, 0));
					rightPane.repaint();
				}
			}
		});

		/**
		 * Skeleton for copy functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - editCopy menu item was clicked by user
		 * @return void
		 **/
		v.editCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (classSelected()) {
					copiedClass = getSelectedClass();
					copiedComment = null;
				} else if (commentSelected()) {
					copiedComment = getSelectedComment();
					copiedClass = null;
				}
			}
		});

		/**
		 * Skeleton for paste functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - editPaste menu item was clicked by user
		 * @return void
		 **/
		v.editPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (copiedClass != null) {
					addClass(copiedClass, new Point(copiedClass.getLocation().x + copiedClass.getWidth(),
							copiedClass.getLocation().y + copiedClass.getHeight()));
				}
			}
		});

		/**
		 * Skeleton for delete functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - editDelete menu item was clicked by user
		 * @return void
		 **/
		v.editDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (classSelected()) {
					InspectorAction inspector = new InspectorAction(getSelectedClass(), v);
					inspector.undoAction();
					deleteObject(new Point(0, 0));
					rightPane.repaint();
				}
			}
		});

		/**
		 * Skeleton for selectAll functionality.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - editSelectAll menu item was clicked by user
		 * @return void
		 **/
		v.editSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	/**
	 * Action listeners for v's left panel's button functions
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return void
	 **/
	public void buttonActionListeners() {
		/**
		 * Sets the editor to be in select mode, so objects can be clicked and dragged.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - select button was clicked by user
		 * @return void
		 **/
		v.selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				falsifyAllBut("selectMode");
			}
		});

		/**
		 * Sets the editor to be in class mode, so class box's can be created and
		 * painted.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - class box button was clicked by user
		 * @return void
		 **/
		v.classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("classMode");
			}
		});

		/**
		 * Sets the editor to be in comment mode, so comment objects can be created and
		 * painted.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - comment button was clicked by user
		 * @return void
		 **/
		v.commentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("commentMode");
			}
		});

		/**
		 * Sets the editor to be in aggregation mode, so aggregation relationships can
		 * be drawn between class boxes.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - aggregation button was clicked by user
		 * @return void
		 **/
		v.aggregationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("aggregationMode");
			}
		});

		/**
		 * Sets the editor to be in generalization mode, so generalization relationships
		 * can be drawn between class boxes.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - generalization button was clicked by user
		 * @return void
		 **/
		v.generalizationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("generalizationMode");
			}
		});

		/**
		 * Sets the editor to be in dependency mode, so dependency relationships can be
		 * drawn between class boxes.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - dependency button was clicked by user
		 * @return void
		 **/
		v.dependencyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("dependencyMode");
			}
		});

		/**
		 * Sets the editor to be in association mode, so association relationships can
		 * be drawn between class boxes.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - association button was clicked by user
		 * @return void
		 **/
		v.associationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("associationMode");
			}
		});

		/**
		 * Sets the editor to be in composition mode, so composition relationships can
		 * be drawn between class boxes.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - composition button was clicked by user
		 * @return void
		 **/
		v.compositionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("compositionMode");
			}
		});

		/**
		 * Sets the editor to be in delete mode, so class boxes and comments can be
		 * undrawn.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - delete button was clicked by user
		 * @return void
		 **/
		v.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				falsifyAllBut("deleteMode");
			}
		});

		/**
		 * The selected class box's name, attributes, and operations are updated.
		 * 
		 * @author Bri Long
		 * @param e - ActionEvent - aggregation button was clicked by user
		 * @return void
		 **/
		v.classOkayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				if (selectedClass != null) {
					SetClassNameAction setName = new SetClassNameAction(selectedClass, v.title.getText());
					setName.doAction();
					actions.push(setName);

					SetClassAttributesAction setAtts = new SetClassAttributesAction(selectedClass, v.atts.getText());
					selectedClass.setAttributes(v.atts.getText());
					setAtts.doAction();
					actions.push(setAtts);

					SetClassOperationsAction setOps = new SetClassOperationsAction(selectedClass, v.ops.getText());
					selectedClass.setOperations(v.ops.getText());
					setOps.doAction();
					actions.push(setOps);

					v.editUndo.setEnabled(true);
					rightPane.repaint();
				}
			}
		});

		v.rOkayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				if (selectedRelationship != null) {
					if (v.directionChange.isSelected()) {
						SwitchRelationshipDirectionAction switchDirection = new SwitchRelationshipDirectionAction(c, v,
								selectedRelationship);
						switchDirection.doAction();
						actions.push(switchDirection);
						v.directionChange.setSelected(false);
					}

					ChangeRelationshipTypeAction change = new ChangeRelationshipTypeAction(c, v);
					change.doAction();
					actions.push(change);

					AddParentMultiplicityAction addPM = new AddParentMultiplicityAction(v.pMultiplicity.getText(),
							selectedRelationship);
					addPM.doAction();
					actions.push(addPM);

					AddChildMultiplicityAction addCM = new AddChildMultiplicityAction(v.cMultiplicity.getText(),
							selectedRelationship);
					addCM.doAction();
					actions.push(addCM);

					RemoveRelationshipInspectorAction a = new RemoveRelationshipInspectorAction(
							selectedRelationship.getClass1(), selectedRelationship.getClass2(), selectedRelationship,
							v);
					a.doAction();

					v.editUndo.setEnabled(true);
					rightPane.repaint();
				}
			}
		});
	}

	/**
	 * Sets editor to be in the mode denoted by the string parameter, by falsifying
	 * all other modes.
	 * 
	 * @author Bri Long
	 * @param mode a string that determines the mode the editor will be in
	 * @return void
	 **/
	public void falsifyAllBut(String mode) {
		boolean result;
		result = ("deleteMode" != mode) ? (deleteMode = false) : (deleteMode = true);
		result = ("classMode" != mode) ? (classMode = false) : (classMode = true);
		result = ("commentMode" != mode) ? (commentMode = false) : (commentMode = true);
		result = ("aggregationMode" != mode) ? (aggregationMode = false) : (aggregationMode = true);
		result = ("dependencyMode" != mode) ? (dependencyMode = false) : (dependencyMode = true);
		result = ("associationMode" != mode) ? (associationMode = false) : (associationMode = true);
		result = ("compositionMode" != mode) ? (compositionMode = false) : (compositionMode = true);
		result = ("generalizationMode" != mode) ? (generalizationMode = false) : (generalizationMode = true);
		result = ("selectMode" != mode) ? (selectMode = false) : (selectMode = true);
	}

	/**
	 * Creates a pop-up window for user to update format of the print-version of the
	 * right pane of the editor.
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return PrinterJob
	 **/
	public PrinterJob pageSetUp(PageFormat preformat, PageFormat postformat) {
		PrinterJob pjob = PrinterJob.getPrinterJob();
		if (preformat == null) {
			preformat = pjob.defaultPage();
			preformat.setOrientation(PageFormat.LANDSCAPE);
		} else {
			preformat = postformat;
		}
		postformat = pjob.pageDialog(preformat);
		return pjob;
	}

	public void addClass(Point p1) {
		int classBoxLimit = 20;
		if (classBoxes.size() < classBoxLimit) {
			AddClassAction addClassAction = new AddClassAction(p1, classBoxes);
			addClassAction.doAction();
			actions.push(addClassAction);
			v.editUndo.setEnabled(true);
			rightPane.repaint();
		}
	}

	public void addClass(Class c, Point p1) {
		int classBoxLimit = 20;
		if (classBoxes.size() < classBoxLimit) {
			AddClassAction addClassAction = new AddClassAction(p1, classBoxes);
			addClassAction.doAction();
			addClassAction.getObject().setName(c.getName());
			addClassAction.getObject().setAttributes(c.getAttributes());
			addClassAction.getObject().setOperations(c.getOperations());
			actions.push(addClassAction);
			v.editUndo.setEnabled(true);
			rightPane.repaint();
		}
	}

	public void addComment(Point p1) {
		int commentBoxLimit = 20;
		if (commentBoxes.size() < commentBoxLimit) {
			AddCommentAction addCommentAction = new AddCommentAction(p1, commentBoxes);
			addCommentAction.doAction();
			actions.push(addCommentAction);
			v.editUndo.setEnabled(true);
			rightPane.repaint();
		}
	}
	
	public void addAggregation(Point p1) {
		Class parent = null , child = null;
		if (aggregationPoint1 == null) {
			aggregationPoint1 = p1;
		} else if (aggregationPoint2 == null) {
			aggregationPoint2 = p1;
			boolean available = hasARelationship(aggregationPoint1, aggregationPoint2);
			if (available == false) {
				for (Class clazz : classBoxes) {
					if (clazz.contains(aggregationPoint1) ) {
						parent = clazz;
					} else if(clazz.contains(aggregationPoint2)) {
						child = clazz;
					}
				}
				AddAggregationAction a = new AddAggregationAction(parent, child, selectedRelationship, aggregations, rightPane);
				a.doAction();
				actions.push(a);
				v.editUndo.setEnabled(true);
			}
			aggregationPoint1 = null;
			aggregationPoint2 = null;
		}
		rightPane.repaint();
	}
	
	public void addAggregation(Class c1, Class c2) {
		AddAggregationAction a = new AddAggregationAction(c1, c2, selectedRelationship, aggregations,rightPane);
		a.doAction();
		actions.push(a);
		v.editUndo.setEnabled(true);
	rightPane.repaint();
}
	
	public void addAssociation(Point p1) {
		Class parent = null , child = null;
		if (associationPoint1 == null) {
			associationPoint1 = p1;
		} else if (associationPoint2 == null) {
			associationPoint2 = p1;
			boolean available = hasARelationship(associationPoint1, associationPoint2);
			if (available == false) {
				for (Class clazz : classBoxes) {
					if (clazz.contains(associationPoint1) ) {
						parent = clazz;
					} else if(clazz.contains(associationPoint2)) {
						child = clazz;
					}
				}
				AddAssociationAction a = new AddAssociationAction(parent, child, associations);
				a.doAction();
				actions.push(a);
				v.editUndo.setEnabled(true);
			}
			associationPoint1 = null;
			associationPoint2 = null;
		}
		rightPane.repaint();
	}
	
	public void addAssociation(Class c1, Class c2) {
		AddAssociationAction a = new AddAssociationAction(c1, c2, associations);
		a.doAction();
		actions.push(a);
		v.editUndo.setEnabled(true);
	rightPane.repaint();
}

	public void addGeneralization(Point p1) {
		Class parent = null , child = null;
		if (generalizationPoint1 == null) {
			generalizationPoint1 = p1;
		} else if (generalizationPoint2 == null) {
			generalizationPoint2 = p1;
			boolean available = hasARelationship(generalizationPoint1, generalizationPoint2);
			if (available == false) {
				for (Class clazz : classBoxes) {
					if (clazz.contains(generalizationPoint1) ) {
						parent = clazz;
					} else if(clazz.contains(generalizationPoint2)) {
						child = clazz;
					}
				}
				AddGeneralizationAction a = new AddGeneralizationAction(parent, child, generalizations);
				a.doAction();
				actions.push(a);
				v.editUndo.setEnabled(true);
			}
			generalizationPoint1 = null;
			generalizationPoint2 = null;
		}
		rightPane.repaint();
	}

	public void addGeneralization(Class c1, Class c2) {
		AddGeneralizationAction a = new AddGeneralizationAction(c1, c2, generalizations);
		a.doAction();
		actions.push(a);
		v.editUndo.setEnabled(true);
	rightPane.repaint();
}

	public void addDependency(Point p1) {
		Class parent = null , child = null;
		if (dependencyPoint1 == null) {
			dependencyPoint1 = p1;
		} else if (dependencyPoint2 == null) {
			dependencyPoint2 = p1;
			boolean available = hasARelationship(dependencyPoint1, dependencyPoint2);
			if (available == false) {
				for (Class clazz : classBoxes) {
					if (clazz.contains(dependencyPoint1) ) {
						parent = clazz;
					} else if(clazz.contains(dependencyPoint2)) {
						child = clazz;
					}
				}
				AddDependencyAction a = new AddDependencyAction(parent, child, dependencies);
				a.doAction();
				actions.push(a);
				v.editUndo.setEnabled(true);
			}
			dependencyPoint1 = null;
			dependencyPoint2 = null;
		}
		rightPane.repaint();
	}
	
	public void addDependency(Class c1, Class c2) {
		AddDependencyAction a = new AddDependencyAction(c1, c2, dependencies);
		a.doAction();
		actions.push(a);
		v.editUndo.setEnabled(true);
	rightPane.repaint();
}

	public void addComposition(Point p1) {
		Class parent = null , child = null;
		if (compositionPoint1 == null) {
			compositionPoint1 = p1;
		} else if (compositionPoint2 == null) {
			compositionPoint2 = p1;
			boolean available = hasARelationship(compositionPoint1, compositionPoint2);
			if (available == false) {
				for (Class clazz : classBoxes) {
					if (clazz.contains(compositionPoint1) ) {
						parent = clazz;
					} else if(clazz.contains(compositionPoint2)) {
						child = clazz;
					}
				}
				AddCompositionAction a = new AddCompositionAction(parent, child, compositions);
				a.doAction();
				actions.push(a);
				v.editUndo.setEnabled(true);
			}
			compositionPoint1 = null;
			compositionPoint2 = null;
		}
		rightPane.repaint();
	}
	
	public void addComposition(Class c1, Class c2) {
		AddCompositionAction a = new AddCompositionAction(c1, c2, compositions);
		a.doAction();
		actions.push(a);
		v.editUndo.setEnabled(true);
	rightPane.repaint();
}
	
	public void deleteObject(Point p1) {
		Class classToRemove = null;
		Comment commentToRemove = null;

		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				classToRemove = classBox;
			}
		}

		for (Comment commentBox : commentBoxes) {
			if (commentBox.contains(p1.x, p1.y)) {
				commentToRemove = commentBox;
			}
		}
		if (classToRemove != null) {
			DeleteClassBoxAction deleteClassBoxAction = new DeleteClassBoxAction(classToRemove, classBoxes);
			deleteClassBoxAction.doAction();
			actions.push(deleteClassBoxAction);
			v.editUndo.setEnabled(true);
			classToRemove = null;
		}

		if (commentToRemove != null) {
			DeleteCommentBoxAction deleteCommentBoxAction = new DeleteCommentBoxAction(commentToRemove, commentBoxes);
			deleteCommentBoxAction.doAction();
			actions.push(deleteCommentBoxAction);
			v.editUndo.setEnabled(true);
			commentToRemove = null;
		}
		rightPane.repaint();
	}

	public void selectObject(Point p1) {

		for (Class classBox : classBoxes) {
			if (classBox.contains(p1)) {
				selectedClass = classBox;
				aClassIsSelected = true;
				InspectorAction inspectorAction = new InspectorAction(selectedClass, v);
				inspectorAction.doAction();
				actions.add(inspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
				break;
			} else {
				selectedClass = null;
				aClassIsSelected = false;
				RemoveInspectorAction removeInspectorAction = new RemoveInspectorAction(null, v);
				removeInspectorAction.doAction();
				actions.add(removeInspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}

		for (Comment commentBox : commentBoxes) {
			if (commentBox.contains(p1.x, p1.y)) {
				selectedComment = commentBox;
				aCommentIsSelected = true;
				rightPane.repaint();
				return;
			} else {
				aCommentIsSelected = false;
				rightPane.repaint();
			}
		}

		for (Composition co : compositions) {
			if (co.getArrow().contains(p1.x, p1.y)) {
				selectedRelationship = co;
				aRelationshipIsSelected = true;
				RelationshipInspectorAction relationshipInspectorAction = new RelationshipInspectorAction(
						co.getClass1(), co.getClass2(), co, v);
				relationshipInspectorAction.doAction();
				actions.add(relationshipInspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
				return;
			} else {
				aRelationshipIsSelected = false;
				selectedRelationship = null;
				RemoveRelationshipInspectorAction relationshipInspectorAction = new RemoveRelationshipInspectorAction(
						co.getClass1(), co.getClass2(), co, v);
				relationshipInspectorAction.doAction();
				actions.add(relationshipInspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}
		for (Aggregation agg : aggregations) {
			if (agg.getArrow().contains(p1.x, p1.y)) {
				selectedRelationship = agg;
				aRelationshipIsSelected = true;
				RelationshipInspectorAction relationshipInspectorAction = new RelationshipInspectorAction(
						agg.getClass1(), agg.getClass2(), agg, v);
				relationshipInspectorAction.doAction();
				actions.add(relationshipInspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
				return;
			} else {
				aRelationshipIsSelected = false;
				selectedRelationship = null;
				RemoveRelationshipInspectorAction relationshipInspectorAction = new RemoveRelationshipInspectorAction(
						agg.getClass1(), agg.getClass2(), agg, v);
				relationshipInspectorAction.doAction();
				actions.add(relationshipInspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}

		for (Generalization d : generalizations) {
			if (d.getArrow().contains(p1.x, p1.y)) {
				selectedRelationship = d;
				aRelationshipIsSelected = true;
				RelationshipInspectorAction relationshipInspectorAction = new RelationshipInspectorAction(d.getClass1(),
						d.getClass2(), d, v);
				relationshipInspectorAction.doAction();
				actions.add(relationshipInspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
				return;
			} else {
				aRelationshipIsSelected = false;
				selectedRelationship = null;
				RemoveRelationshipInspectorAction relationshipInspectorAction = new RemoveRelationshipInspectorAction(
						d.getClass1(), d.getClass2(), d, v);
				relationshipInspectorAction.doAction();
				actions.add(relationshipInspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}

		for (Dependency d : dependencies) {
			if (d.getArrow().contains(p1.x, p1.y)) {
				selectedRelationship = d;
				aRelationshipIsSelected = true;
				RelationshipInspectorAction relationshipInspectorAction = new RelationshipInspectorAction(d.getClass1(),
						d.getClass2(), d, v);
				relationshipInspectorAction.doAction();
				actions.add(relationshipInspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
				return;
			} else {
				aRelationshipIsSelected = false;
				selectedRelationship = null;
				RemoveRelationshipInspectorAction relationshipInspectorAction = new RemoveRelationshipInspectorAction(
						d.getClass1(), d.getClass2(), d, v);
				relationshipInspectorAction.doAction();
				actions.add(relationshipInspectorAction);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}
	}

	public boolean classSelected() {
		return aClassIsSelected;
	}

	public boolean commentSelected() {
		return aCommentIsSelected;
	}

	public boolean relationshipSelected() {
		return aRelationshipIsSelected;
	}

	public Class getSelectedClass() {
		return selectedClass;
	}

	public Comment getSelectedComment() {
		return selectedComment;
	}

	public boolean deleteMode() {
		return deleteMode;
	}

	public boolean classMode() {
		return classMode;
	}

	public boolean commentMode() {
		return commentMode;
	}

	public boolean aggregationMode() {
		return aggregationMode;
	}

	public boolean dependencyMode() {
		return dependencyMode;
	}

	public boolean associationMode() {
		return associationMode;
	}

	public boolean compositionMode() {
		return compositionMode;
	}

	public boolean generalizationMode() {
		return generalizationMode;
	}

	public boolean selectMode() {
		return selectMode;
	}

	public ArrayList<Class> getClasses() {
		return classBoxes;
	}

	public ArrayList<Comment> getComments() {
		return commentBoxes;
	}

	public ArrayList<Association> getAssociations() {
		return associations;
	}

	public ArrayList<Generalization> getGeneralizations() {
		return generalizations;
	}

	public ArrayList<Dependency> getDependencies() {
		return dependencies;
	}

	public ArrayList<Aggregation> getAggregations() {
		return aggregations;
	}

	public ArrayList<Composition> getCompositions() {
		return compositions;
	}

	public Canvas getCanvas() {
		return rightPane;
	}

	public boolean hasARelationship(Point p1, Point p2) {
		Class c1 = null, c2 = null;

		for (Class c : classBoxes) {
			if (c.contains(p1)) {
				c1 = c;
			} else if (c.contains(p2)) {
				c2 = c;
			}
		}

		if (c1 != null && c2 != null) {
			if (c1.isAParent() == true) {
				if (c2.isAChild() == true && c1.getChild() == c2) {
					return true;
				} else {
					return false;
				}
			} else if (c1.isAChild() == true) {
				if (c2.isAParent() == true && c1.getParent() == c2) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public Relationship getSelectedRelationship() {
		return selectedRelationship;
	}
}