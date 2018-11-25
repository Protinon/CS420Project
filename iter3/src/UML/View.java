package UML;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class View {
	JFrame frame = new JFrame("UMLEditor");
	JPanel leftPane = new JPanel();
	JPanel rightPane = new JPanel();
	JSplitPane splitPane;

	JMenu file = new JMenu("File");
	JMenuItem fileNew = new JMenuItem("New");
	JMenuItem fileOpen = new JMenuItem("Open");
	JMenuItem fileSave = new JMenuItem("Save");
	JMenuItem fileSaveAs = new JMenuItem("Save As...");
	JMenuItem filePageSetup = new JMenuItem("Page Setup...");
	JMenuItem filePrint = new JMenuItem("Print...");
	JMenuItem fileClose = new JMenuItem("Close");

	JMenu edit = new JMenu("Edit");

	JMenuItem editUndo = new JMenuItem("Undo");
	JMenuItem editRedo = new JMenuItem("Redo");
	JMenuItem editCut = new JMenuItem("Cut");
	JMenuItem editCopy = new JMenuItem("Copy");
	JMenuItem editPaste = new JMenuItem("Paste");
	JMenuItem editDelete = new JMenuItem("Delete");
	JMenuItem editSelectAll = new JMenuItem("Select All");

	JLabel titleLabel = new JLabel("Enter Class Box Title: ");
	JLabel attsLabel = new JLabel("Enter Class Attributes: ");
	JLabel opsLabel = new JLabel("Enter Class Operations: ");

	JTextField title = new JTextField();
	JTextField atts = new JTextField();
	JTextField ops = new JTextField();

	JButton selectButton = new JButton("Select");
	JButton deleteButton = new JButton("Delete");
	JButton commentButton = new JButton("Comment");
	JButton classButton = new JButton("Class Box");
	JButton aggregationButton = new JButton("Aggregation");
	JButton dependencyButton = new JButton("Dependency");
	JButton generalizationButton = new JButton("Generalization");
	JButton associationButton = new JButton("Association");
	JButton compositionButton = new JButton("Composition");
	JButton okayButton = new JButton("Okay");

	JLabel direction = new JLabel("Change Direction: ");
	JLabel parentMultiplicity = new JLabel("Parent Multiplicity: ");
	JLabel childMultiplicity = new JLabel("Child Multiplicity: ");
	
	JTextField parentM = new JTextField("");
	JTextField childM = new JTextField("");
	
	JCheckBox directionChange = new JCheckBox("Switch Direction");
	String[] choices = { "Association", "Aggregation", "Composition", "Dependency", "Generalization"};

    final JComboBox<String> cb = new JComboBox<String>(choices);
	/**
	 * Initialize window and setup.
	 * 
	 * @author Bri Long
	 * @param N/A
	 **/
	public View(Canvas rightPane) {

		JMenuBar menuBar;
		JSeparator sep = new JSeparator();

// FRAME INITIALIZATION-------------------------------------------------------------

		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

// ---------------------------------------------------------------------------------

//SPLIT-PANE INITIALIZATION--------------------------------------------------------
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftPane, rightPane);
		splitPane.setEnabled(false);
		splitPane.setDividerLocation(152);
		leftPane.setLayout(null);
		splitPane.setDividerSize(2);
		frame.add(splitPane);
		selectButton.setBounds(0, 0, 150, 25);
		leftPane.add(selectButton);
//--------------------------------------------------------------------------------

//BUTTON INITIALIZATION-----------------------------------------------------------
		selectButton.setBounds(0, 0, 150, 25);
		deleteButton.setBounds(0, 25, 150, 25);
		classButton.setBounds(0, 50, 150, 25);
		commentButton.setBounds(0, 75, 150, 25);
		associationButton.setBounds(0, 100, 150, 25);
		generalizationButton.setBounds(0, 125, 150, 25);
		dependencyButton.setBounds(0, 150, 150, 25);
		aggregationButton.setBounds(0, 175, 150, 25);
		compositionButton.setBounds(0, 200, 150, 25);
		sep.setBounds(0, 230, 152, 5);

		leftPane.add(classButton);
		leftPane.add(associationButton);
		leftPane.add(generalizationButton);
		leftPane.add(dependencyButton);
		leftPane.add(aggregationButton);
		leftPane.add(compositionButton);
		leftPane.add(commentButton);
		leftPane.add(deleteButton);
		leftPane.add(selectButton);
		leftPane.add(sep);
//--------------------------------------------------------------------------------

//INSPECTOR-LIKE FUNCTIONS INITIALIZATION-----------------------------------------
		titleLabel.setBounds(2, 235, 150, 25);
		title.setBounds(0, 260, 150, 25);
		attsLabel.setBounds(2, 285, 150, 25);
		atts.setBounds(0, 310, 150, 25);
		opsLabel.setBounds(2, 335, 150, 25);
		ops.setBounds(0, 360, 150, 25);
		okayButton.setBounds(0, 395, 150, 25);

		titleLabel.setVisible(false);
		title.setVisible(false);
		attsLabel.setVisible(false);
		atts.setVisible(false);
		opsLabel.setVisible(false);
		ops.setVisible(false);
		okayButton.setVisible(false);

		leftPane.add(titleLabel);
		leftPane.add(title);
		leftPane.add(attsLabel);
		leftPane.add(atts);
		leftPane.add(opsLabel);
		leftPane.add(ops);
		leftPane.add(okayButton);
//MENU BAR INITIALIZATION---------------------------------------------------------

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

//TABS INITIALIZATION-------------------------------------------------------------
		menuBar.add(file);

//FILE SUB-MENU-------------------------------------------------------------------

		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

		fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

		fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		filePrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

		fileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

		file.add(fileNew);
		file.add(fileOpen);
		file.add(fileSave);
		file.add(fileSaveAs);
		file.addSeparator();
		file.add(filePageSetup);
		file.add(filePrint);
		file.addSeparator();
		file.add(fileClose);

//--------------------------------------------------------------------------------
		menuBar.add(edit);

//EDIT SUB-MENU-------------------------------------------------------------------
		editUndo.setEnabled(false);
		editUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));

		editRedo.setEnabled(false);
		editRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));

		editCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		editCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

		editPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

		editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

		editSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

		edit.add(editUndo);
		edit.add(editRedo);
		edit.addSeparator();
		edit.add(editCut);
		edit.add(editCopy);
		edit.add(editPaste);
		edit.add(editDelete);
		edit.addSeparator();
		edit.add(editSelectAll);

// -------------------------------------------------------------------------------

// -------------------------------------------------------------------------------
		
	
		cb.setBounds(0, 240, 150, 25);
		parentMultiplicity.setBounds(2, 265, 150, 25);
		parentM.setBounds(0, 290, 150, 25);
		childMultiplicity.setBounds(2, 315, 150, 25);
		childM.setBounds(0, 340, 150, 25);
		directionChange.setBounds(0, 365, 150, 25);

		
		
		directionChange.setVisible(false);
	    cb.setVisible(false);
	    parentMultiplicity.setVisible(false);
	    parentM.setVisible(false);
	    childMultiplicity.setVisible(false);
	    childM.setVisible(false);

	    
	    
	    
	    
	    leftPane.add(cb);	
	    leftPane.add(directionChange);
	    leftPane.add(parentMultiplicity);
	    leftPane.add(childMultiplicity);
	    leftPane.add(childM);
	    leftPane.add(parentM);

	    
		
	}
}
