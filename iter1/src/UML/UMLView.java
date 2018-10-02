package UML;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

public class UMLView extends JFrame {
	JFrame frame = new JFrame("UMLEditor");
	JPanel rightPane = new JPanel();
	JPanel leftPane = new JPanel();
	JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftPane, rightPane);

	JMenuBar menuBar;
	JMenu file;
	JMenuItem fileNew;
	JMenuItem fileOpen;
	JMenuItem fileSave;
	JMenuItem fileSaveAs;
	JMenuItem filePageSetup;
	JMenuItem filePrint;
	JMenuItem fileClose;
	JMenu edit;
	JMenuItem editUndo;
	JMenuItem editRedo;
	JMenuItem editCut;
	JMenuItem editCopy;
	JMenuItem editPaste;
	JMenuItem editDelete;
	JMenuItem editSelectAll;
	JMenu view;

	JButton pointButton;
	JButton commentButton;
	JButton classButton;
	JButton aggregationButton;
	JButton dependencyButton;
	JButton generalizationButton;
	JButton associationButton;
	JButton compositionButton;

	JCheckBox viewGrid;

	public UMLView() {
//FRAME INITIALIZATION-------------------------------------------------------------
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//--------------------------------------------------------------------------------- 

//SPLIT-PANE INITIALIZATION--------------------------------------------------------
		leftPane.setLayout(null);

		Color eggShell = new Color(248, 248, 255);
		rightPane.setBackground(eggShell);
		rightPane.setLayout(null);

		splitPane.setResizeWeight(.197);
		splitPane.setDividerSize(3);
		frame.add(splitPane);
//--------------------------------------------------------------------------------

//MENU BAR INITIALIZATION---------------------------------------------------------
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
//TABS INITIALIZATION-------------------------------------------------------------
		file = new JMenu("File");
		menuBar.add(file);
//FILE SUB-MENU-------------------------------------------------------------------
		fileNew = new JMenuItem("New");
		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

		fileOpen = new JMenuItem("Open...");
		fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

		fileSave = new JMenuItem("Save");
		fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		fileSaveAs = new JMenuItem("Save As...");

		filePageSetup = new JMenuItem("Page Setup...");

		filePrint = new JMenuItem("Print...");
		filePrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

		fileClose = new JMenuItem("Close");
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
		edit = new JMenu("Edit");
		menuBar.add(edit);
//EDIT SUB-MENU-------------------------------------------------------------------
		editUndo = new JMenuItem("Undo");
		editUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));

		editRedo = new JMenuItem("Redo");
		editRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));

		editCut = new JMenuItem("Cut");
		editCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		editCopy = new JMenuItem("Copy");
		editCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

		editPaste = new JMenuItem("Paste");
		editPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

		editDelete = new JMenuItem("Delete");
		editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

		editSelectAll = new JMenuItem("Select All");
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
		view = new JMenu("View");
		menuBar.add(view);
// VIEW SUB-MENU------------------------------------------------------------------
		viewGrid = new JCheckBox("Grid Lines");
		viewGrid.setMnemonic(KeyEvent.VK_G);
		viewGrid.setSelected(false);
//--------------------------------------------------------------------------------

//BUTTON INITIALIZATION-----------------------------------------------------------
//POINT BUTTON--------------------------------------------------------------------

		pointButton = new JButton("Point");
		pointButton.setBounds(0, 0, 150, 25);

//CLASS BUTTON--------------------------------------------------------------------
		classButton = new JButton("Class");
		classButton.setBounds(0, 25, 150, 25);

//ASSOCIATION BUTTON--------------------------------------------------------------
		associationButton = new JButton("Association");
		associationButton.setBounds(0, 50, 150, 25);

//GENERALIZATION BUTTON-----------------------------------------------------------
		generalizationButton = new JButton("Generalization");
		generalizationButton.setBounds(0, 75, 150, 25);

//DEPENDENCY BUTTON---------------------------------------------------------------
		dependencyButton = new JButton("Dependency");
		dependencyButton.setBounds(0, 100, 150, 25);

//AGGREGATION BUTTON--------------------------------------------------------------
		aggregationButton = new JButton("Aggregation");
		aggregationButton.setBounds(0, 125, 150, 25);

//COMPOSITION BUTTON--------------------------------------------------------------
		compositionButton = new JButton("Composition");
		compositionButton.setBounds(0, 150, 150, 25);

//COMMENT BUTTON------------------------------------------------------------------
		commentButton = new JButton("Comment");
		commentButton.setBounds(0, 175, 150, 25);

		leftPane.add(pointButton);
		leftPane.add(classButton);
		leftPane.add(associationButton);
		leftPane.add(generalizationButton);
		leftPane.add(dependencyButton);
		leftPane.add(aggregationButton);
		leftPane.add(compositionButton);
		leftPane.add(commentButton);

//--------------------------------------------------------------------------------
	}
}