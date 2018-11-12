package UML;

import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFileChooser;

public class Controller {
	private ArrayList<Comment> commentBoxes = new ArrayList<Comment>();

	private Stack<Action> actions = new Stack<Action>();
	private Stack<Action> undoActions = new Stack<Action>();
	private Stack<Action> redoActions = new Stack<Action>();
	private ArrayList<Class> classBoxes = new ArrayList<Class>(), generalizedClasses = new ArrayList<Class>(),
			associatedClasses = new ArrayList<Class>(), dependedClasses = new ArrayList<Class>(),
			aggregatedClasses = new ArrayList<Class>(), compositedClasses = new ArrayList<Class>();

	private boolean aClassIsSelected = false, aCommentIsSelected = false;
	private boolean selectMode = false, deleteMode = false, classMode = false, commentMode = false,
			aggregationMode = false, dependencyMode = false, associationMode = false, compositionMode = false,
			generalizationMode = false;

	private Class selectedClass;
	private Comment selectedComment;

	private View v;
	@SuppressWarnings("unused")
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
		viewActionListeners();
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
						@SuppressWarnings("unused")
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
				JFileChooser c = new JFileChooser();
				int rVal = c.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					File fileToOpen = c.getSelectedFile();
					try {
						Desktop.getDesktop().open(fileToOpen);
					} catch (Exception ex) {
					}
				}
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
			@SuppressWarnings("unused")
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
				Action a = actions.pop();
				undoActions.add(a);
				a.undoAction();
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
				Action a = undoActions.pop();
				redoActions.add(a);
				actions.add(a);
				a.doAction();
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
	 * Action listeners for v's view tab's functions
	 * 
	 * @author Bri Long
	 * @param N/A
	 * @return void
	 **/
	public void viewActionListeners() {
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
		v.okayButton.addActionListener(new ActionListener() {
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
		@SuppressWarnings("unused")
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
			AddClassAction newClass = new AddClassAction(p1, classBoxes);
			newClass.doAction();
			actions.add(newClass);
			v.editUndo.setEnabled(true);
			rightPane.repaint();
		}
	}

	public void addComment(Point p1) {
		int commentBoxLimit = 20;
		if (commentBoxes.size() < commentBoxLimit) {
			AddCommentAction newComment = new AddCommentAction(p1, commentBoxes);
			newComment.doAction();
			actions.push(newComment);
			v.editUndo.setEnabled(true);
			rightPane.repaint();
		}
	}

	public void addAssociation(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				AddAssociationAction addAssociations = new AddAssociationAction(classBox, p1, associatedClasses);
				addAssociations.doAction();
				actions.push(addAssociations);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}
	}

	public void addGeneralization(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				AddGeneralizationAction addGeneralizations = new AddGeneralizationAction(classBox, p1,
						generalizedClasses);
				addGeneralizations.doAction();
				actions.push(addGeneralizations);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}
	}

	public void addDependency(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				AddDependencyAction addDependencies = new AddDependencyAction(classBox, p1, dependedClasses);
				addDependencies.doAction();
				actions.push(addDependencies);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}

	}

	public void addAggregation(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				AddAggregationAction addAggregations = new AddAggregationAction(classBox, p1, aggregatedClasses);
				addAggregations.doAction();
				actions.push(addAggregations);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}
	}

	public void addComposition(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				compositedClasses.add(classBox);
				AddCompositionAction addCompositions = new AddCompositionAction(classBox, p1, compositedClasses);
				addCompositions.doAction();
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}
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
		DeleteClassBoxAction deleteClass = new DeleteClassBoxAction(classToRemove, classBoxes);
		deleteClass.doAction();
		DeleteCommentBoxAction deleteComment = new DeleteCommentBoxAction(commentToRemove, commentBoxes);
		deleteComment.doAction();
		v.editUndo.setEnabled(true);
		rightPane.repaint();
	}

	public void selectObject(Point p1) {

		for (Class classBox : classBoxes) {
			if (classBox.contains(p1)) {
				selectedClass = classBox;
				aClassIsSelected = true;
				InspectorAction inspector = new InspectorAction(selectedClass, v);
				inspector.doAction();
				actions.add(inspector);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
				break;
			} else {
				selectedClass = null;
				aClassIsSelected = false;
				RemoveInspectorAction inspector = new RemoveInspectorAction(null, v);
				inspector.doAction();
				actions.add(inspector);
				v.editUndo.setEnabled(true);
				rightPane.repaint();
			}
		}

		for (Comment commentBox : commentBoxes) {
			if (commentBox.contains(p1.x, p1.y)) {
				selectedComment = commentBox;
				aCommentIsSelected = true;
				break;
			} else {
				aCommentIsSelected = false;
			}
		}
	}

	public boolean classSelected() {
		return aClassIsSelected;
	}

	public boolean commentSelected() {
		return aCommentIsSelected;
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

	public ArrayList<Class> getAssociations() {
		return associatedClasses;
	}

	public ArrayList<Class> getGeneralizations() {
		return generalizedClasses;
	}

	public ArrayList<Class> getDependencies() {
		return dependedClasses;
	}

	public ArrayList<Class> getAggregations() {
		return aggregatedClasses;
	}

	public ArrayList<Class> getCompositions() {
		return compositedClasses;
	}

	public Canvas getCanvas() {
		return rightPane;
	}
}
