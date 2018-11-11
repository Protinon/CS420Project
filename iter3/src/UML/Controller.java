package UML;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Controller extends JPanel {
	private static final long serialVersionUID = 1L;

	private ArrayList<Comment> commentBoxes = new ArrayList<Comment>();

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
	private Controller c;

	/**
	 * Constructor for this controller
	 * 
	 * @author Bri Long
	 * @param v1 View object that will be the window that this controller interacts
	 *           with
	 **/
	public Controller(View v1) {
		v = v1;
		c = this;
		MouseListener m = new MouseListener(this);
		this.addMouseListener(m);
		this.addMouseMotionListener(m);

		setBackground(Color.WHITE);

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
						View v2 = new View();
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
			public void actionPerformed(ActionEvent e) {
				PrinterJob pjob = pageSetUp(preformat, postformat);

				if (preformat != postformat) {
					pjob.setPrintable(new Printer(c), postformat);
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
					selectedClass.setName(v.title.getText());
					selectedClass.setAttributes(v.atts.getText());
					selectedClass.setOperations(v.ops.getText());
					repaint();
				}
			}
		});
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
				Relationship ir = new Relationship("association", c1, c2);
				ir.paintRelationship(g);
			}
		}

		// if there are at least 2 classes in generalizedClasses,
		// paint generalization between 1st and 2nd classes, 3rd and 4th etc
		if (generalizedClasses.size() > 1) {
			for (int i = 0; i < generalizedClasses.size() - 1; i += 2) {
				Class c1 = generalizedClasses.get(i);
				Class c2 = generalizedClasses.get(i + 1);
				Relationship ir = new Relationship("generalization", c1, c2);
				ir.paintRelationship(g);
			}
		}

		// if there are at least 2 classes in dependedClasses,
		// paint dependency between 1st and 2nd classes, 3rd and 4th etc
		if (dependedClasses.size() > 1) {
			for (int i = 0; i < dependedClasses.size() - 1; i += 2) {
				Class c1 = dependedClasses.get(i);
				Class c2 = dependedClasses.get(i + 1);
				Relationship ir = new Relationship("dependency", c1, c2);
				ir.paintRelationship(g);
			}
		}

		// if there are at least 2 classes in aggregatedClasses,
		// paint aggregation between 1st and 2nd classes, 3rd and 4th etc
		if (aggregatedClasses.size() > 1) {
			for (int i = 0; i < aggregatedClasses.size() - 1; i += 2) {
				Class c1 = aggregatedClasses.get(i);
				Class c2 = aggregatedClasses.get(i + 1);
				Relationship ir = new Relationship("aggregation", c1, c2);
				ir.paintRelationship(g);
			}
		}

		// if there are at least 2 classes in compositedClasses,
		// paint composition between 1st and 2nd classes, 3rd and 4th etc
		if (compositedClasses.size() > 1) {
			for (int i = 0; i < compositedClasses.size() - 1; i += 2) {
				Class c1 = compositedClasses.get(i);
				Class c2 = compositedClasses.get(i + 1);
				Relationship ir = new Relationship("composition", c1, c2);
				ir.paintRelationship(g);
			}
		}

	}

	public void overriddenPaintComponent(Graphics g) {
		super.paintComponent(g);
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
			classBoxes.add(new Class(p1.x, p1.y));
			repaint();
		}
	}

	public void addComment(Point p1) {
		int commentBoxLimit = 20;
		if (commentBoxes.size() < commentBoxLimit) {
			commentBoxes.add(new Comment(p1.x, p1.y));
			repaint();
		}
	}

	public void addAssociation(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				associatedClasses.add(classBox);
				repaint();
			}
		}
	}

	public void addGeneralization(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				generalizedClasses.add(classBox);
				repaint();
			}
		}
	}

	public void addDependency(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				dependedClasses.add(classBox);
				repaint();
			}
		}

	}

	public void addAggregation(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				aggregatedClasses.add(classBox);
				repaint();
			}
		}
	}

	public void addComposition(Point p1) {
		for (Class classBox : classBoxes) {
			if (classBox.contains(p1.x, p1.y)) {
				compositedClasses.add(classBox);
				repaint();
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

		classBoxes.remove(classToRemove);
		commentBoxes.remove(commentToRemove);
		repaint();
	}

	public void selectObject(Point p1) {

		for (Class classBox : classBoxes) {
			if (classBox.contains(p1)) {
				selectedClass = classBox;
				aClassIsSelected = true;
				v.okayButton.setVisible(true);
				v.titleLabel.setVisible(true);
				v.title.setText(selectedClass.getName());
				v.title.setVisible(true);
				v.attsLabel.setVisible(true);
				v.atts.setText(selectedClass.getAttributes());
				v.atts.setVisible(true);
				v.opsLabel.setVisible(true);
				v.ops.setText(selectedClass.getOperations());
				v.ops.setVisible(true);
				break;
			} else {
				selectedClass = null;
				aClassIsSelected = false;
				v.okayButton.setVisible(false);
				v.titleLabel.setVisible(false);
				v.title.setVisible(false);
				v.attsLabel.setVisible(false);
				v.atts.setVisible(false);
				v.opsLabel.setVisible(false);
				v.ops.setVisible(false);
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
}
