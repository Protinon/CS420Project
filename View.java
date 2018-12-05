package object;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
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
import javax.swing.JTextArea;
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

	public JLabel titleLabel = new JLabel("Enter Class Box Title: ");
	public JLabel attsLabel = new JLabel("Enter Class Attributes: ");
	public JLabel opsLabel = new JLabel("Enter Class Operations: ");

	public JTextArea title = new JTextArea();
	public JTextArea atts = new JTextArea();
	public JTextArea ops = new JTextArea();

	public JTextField pMultiplicity = new JTextField("");
	public JTextField cMultiplicity = new JTextField("");

	public JLabel directionLabel = new JLabel("Change Direction: ");
	public JLabel pMultiplicityLabel = new JLabel("Parent Multiplicity: ");
	public JLabel cMultiplicityLabel = new JLabel("Child Multiplicity: ");

	public JButton selectButton = new JButton("Select");
	public JButton deleteButton = new JButton("Delete");
	public JButton commentButton = new JButton("Comment");
	public JButton classButton = new JButton("Class Box");
	public JButton aggregationButton = new JButton("Aggregation");
	public JButton dependencyButton = new JButton("Dependency");
	public JButton generalizationButton = new JButton("Generalization");
	public JButton associationButton = new JButton("Association");
	public JButton compositionButton = new JButton("Composition");
	public JButton okayButton = new JButton("Okay");

	public JCheckBox directionChange = new JCheckBox("Switch Direction");
	public String[] relationships = { "Association", "Aggregation", "Composition", "Dependency", "Generalization" };

	public final JComboBox<String> relationshipTypes = new JComboBox<String>(relationships);

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

//RELATIONSHIP INSPECTOR-LIKE FUNCTIONS INITIALIZATION----------------------------	
		relationshipTypes.setBounds(0, 240, 150, 25);
		pMultiplicityLabel.setBounds(2, 265, 150, 25);
		pMultiplicity.setBounds(0, 290, 150, 25);
		cMultiplicityLabel.setBounds(2, 315, 150, 25);
		cMultiplicity.setBounds(0, 340, 150, 25);
		directionChange.setBounds(0, 365, 150, 25);
		okayButton.setBounds(0, 395, 150, 25);
		
		directionChange.setVisible(false);
		relationshipTypes.setVisible(false);
		pMultiplicityLabel.setVisible(false);
		pMultiplicity.setVisible(false);
		cMultiplicityLabel.setVisible(false);
		cMultiplicity.setVisible(false);
		okayButton.setVisible(false);

		leftPane.add(relationshipTypes);
		leftPane.add(directionChange);
		leftPane.add(pMultiplicityLabel);
		leftPane.add(cMultiplicityLabel);
		leftPane.add(cMultiplicity);
		leftPane.add(pMultiplicity);
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

		edit.add(editUndo);
		edit.add(editRedo);
		edit.addSeparator();
		edit.add(editCut);
		edit.add(editCopy);
		edit.add(editPaste);
		edit.add(editDelete);
		edit.addSeparator();

// -------------------------------------------------------------------------------

// -------------------------------------------------------------------------------    
	}
}
