package UML;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Controller extends JPanel {
	private static final long serialVersionUID = 1L;

	ArrayList<Class> generalizedClasses = new ArrayList<Class>();
	ArrayList<Class> classBoxes = new ArrayList<Class>();
	ArrayList<Comment> commentBoxes = new ArrayList<Comment>();
	ArrayList<Class> associatedClasses = new ArrayList<Class>();
	ArrayList<Class> dependedClasses = new ArrayList<Class>();
	ArrayList<Class> aggregatedClasses = new ArrayList<Class>();
	ArrayList<Class> compositedClasses = new ArrayList<Class>();

	boolean selectMode = false;
	boolean deleteMode = false;
	boolean classMode = false;
	boolean commentMode = false;
	boolean aggregationMode = false;
	boolean dependencyMode = false;
	boolean associationMode = false;
	boolean compositionMode = false;
	boolean generalizationMode = false;

	Class selectedClass;
	Comment selectedComment;

	View v;

	public Controller(View v1) {
		v = v1;

		MouseListener m = new MouseListener(this);
		this.addMouseListener(m);
		this.addMouseMotionListener(m);

		setBackground(Color.WHITE);

		fileActionListeners();
		editActionListeners();
		viewActionListeners();
		buttonActionListeners();
	}

	public void fileActionListeners() {
		v.fileNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						View v2 = new View();
					}
				});
			}
		});

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

		v.fileSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		v.fileSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea textArea = new JTextArea(24, 80);
				JFileChooser fileChooser = new JFileChooser();
				int retval = fileChooser.showSaveDialog(v.fileSaveAs);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					if (file == null) {
						return;
					}
					if (!file.getName().toLowerCase().endsWith(".uml")) {
						file = new File(file.getParentFile(), file.getName() + ".uml");
					}
					try {
						textArea.write(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		v.filePageSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		v.filePrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat preformat = pjob.defaultPage();
				preformat.setOrientation(PageFormat.LANDSCAPE);
				PageFormat postformat = pjob.pageDialog(preformat);

				if (preformat != postformat) {
					pjob.setPrintable(new Printer(v.splitPane), postformat);
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

		v.fileClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.frame.dispose();
			}
		});
	}

	public void editActionListeners() {
		v.editUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		v.editRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		v.editCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		v.editCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		v.editPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		v.editDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		v.editSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	public void viewActionListeners() {
	}

	public void buttonActionListeners() {
		/*
		 * if user clicks select button, all modes besides select are falsified, meaning
		 * that the user can click and drag objects.
		 */
		v.selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				falsifyAllBut("selectMode");
			}
		});

		/*
		 * if user clicks class button, all modes besides class are falsified, meaning
		 * that the user can create class boxes by clicking the desired position in the
		 * right pane.
		 */
		v.classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("classMode");
			}
		});

		/*
		 * if user clicks comment button, all modes besides comment are falsified,
		 * meaning that the user can create comment boxes by clicking the desired
		 * position in the right pane.
		 */
		v.commentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("commentMode");
			}
		});

		/*
		 * if user clicks aggregation button, all modes besides aggregation are
		 * falsified, meaning that the user may then click on 2 class boxes for an
		 * aggregation relationship to be drawn between them.
		 */
		v.aggregationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("aggregationMode");
			}
		});

		/*
		 * if user clicks generalization button, all modes besides generalization are
		 * falsified, meaning that the user may then click on 2 class boxes for a
		 * generalization relationship to be drawn between them.
		 */
		v.generalizationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("generalizationMode");
			}
		});

		/*
		 * if user clicks dependency button, all modes besides dependency are falsified,
		 * meaning that the user may then click on 2 class boxes for a dependency
		 * relationship to be drawn between them.
		 */
		v.dependencyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("dependencyMode");
			}
		});

		/*
		 * if user clicks association button, all modes besides association are
		 * falsified, meaning that the user may then click on 2 class boxes for an
		 * association relationship to be drawn between them.
		 */
		v.associationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("associationMode");
			}
		});

		/*
		 * if user clicks composition button, all modes besides composition are
		 * falsified, meaning that the user may then click on 2 class boxes for a
		 * composition relationship to be drawn between them.
		 */
		v.compositionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				falsifyAllBut("compositionMode");
			}
		});

		/*
		 * if user clicks delete button, all modes besides delete are falsified, meaning
		 * that the user may then click on any class boxes or comments to remove them
		 * from the pane.
		 */
		v.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				falsifyAllBut("deleteMode");
			}
		});

		/*
		 * if okay button is visible then the user has selected a class box if a user
		 * clicks okay, the text in the 3 text fields above okay button will update
		 * class information
		 */
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

	public void falsifyAllBut(String mode) {
		boolean result = ("deleteMode" != mode) ? (deleteMode = false) : (deleteMode = true);
		result = ("classMode" != mode) ? (classMode = false) : (classMode = true);
		result = ("commentMode" != mode) ? (commentMode = false) : (commentMode = true);
		result = ("aggregationMode" != mode) ? (aggregationMode = false) : (aggregationMode = true);
		result = ("dependencyMode" != mode) ? (dependencyMode = false) : (dependencyMode = true);
		result = ("associationMode" != mode) ? (associationMode = false) : (associationMode = true);
		result = ("compositionMode" != mode) ? (compositionMode = false) : (compositionMode = true);
		result = ("generalizationMode" != mode) ? (generalizationMode = false) : (generalizationMode = true);
		result = ("selectMode" != mode) ? (selectMode = false) : (selectMode = true);
	}
}
