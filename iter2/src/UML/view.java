package UML;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

public class view {
	public view() {
		JFrame frame = new JFrame("UMLEditor");
		JPanel leftPane = new JPanel();
		JSplitPane splitPane;

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

// FRAME INITIALIZATION-------------------------------------------------------------
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
// ---------------------------------------------------------------------------------

//SPLIT-PANE INITIALIZATION--------------------------------------------------------
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftPane, new Controllerish(leftPane));
		leftPane.setLayout(null);
		splitPane.setDividerSize(3);
		splitPane.setResizeWeight(.197);
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

// -------------------------------------------------------------------------------
	}
}
