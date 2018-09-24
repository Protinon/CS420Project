package UML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UMLView extends JFrame implements ActionListener {
    public JFrame frame = new JFrame("UMLEditor");
    public JPanel rightPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JPanel leftPane = new JPanel();
    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftPane, rightPane);

    public UMLView() {
//FRAME INITIALIZATION------------------------------------------------------------

	frame.pack();
	frame.setVisible(true);
	frame.setSize(800, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//--------------------------------------------------------------------------------

//SPLIT-PANE INITIALIZATION------------------------------------------------------------
	Dimension d = new Dimension(75, 600);
	leftPane.setSize(d);
	leftPane.setLayout(null);

	Color eggShell = new Color(248, 248, 255);
	rightPane.setBackground(eggShell);

	splitPane.setResizeWeight(.103);
	splitPane.setDividerSize(3);
	frame.add(splitPane);
//--------------------------------------------------------------------------------

//MENU BAR INITIALIZATION---------------------------------------------------------
	JMenuBar menuBar;
	menuBar = new JMenuBar();
	frame.setJMenuBar(menuBar);
	// TABS INITIALIZATION
	JMenu file;
	file = new JMenu("File");
	menuBar.add(file);
	// FILE SUB-MENU-------------------------------------------
	JMenuItem fileNew;
	fileNew = new JMenuItem("New");
	fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	fileNew.addActionListener((ActionEvent event) -> {
            UMLView x = new UMLView();
	});

	JMenuItem fileOpen;
	fileOpen = new JMenuItem("Open...");
	fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

	JMenuItem fileSave;
	fileSave = new JMenuItem("Save");
	fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

	JMenuItem fileSaveAs;
	fileSaveAs = new JMenuItem("Save As...");

	JMenuItem filePageSetup;
	filePageSetup = new JMenuItem("Page Setup...");

	JMenuItem filePrint;
	filePrint = new JMenuItem("Print...");
	filePrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

	filePrint.addActionListener(this);

	JMenuItem fileClose;
	fileClose = new JMenuItem("Close");
	fileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
	fileClose.addActionListener((ActionEvent event) -> {
            System.exit(0);
	});

	file.add(fileNew);
	file.add(fileOpen);
	file.add(fileSave);
	file.add(fileSaveAs);
	file.addSeparator();
	file.add(filePageSetup);
	file.add(filePrint);
	file.addSeparator();
	file.add(fileClose);
	// ------------------------------------------------------------

	JMenu edit;
	edit = new JMenu("Edit");
	menuBar.add(edit);
	// EDIT SUB-MENU-----------------------------------------------
	JMenuItem editUndo;
	editUndo = new JMenuItem("Undo");
	editUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));

	JMenuItem editRedo;
	editRedo = new JMenuItem("Redo");
	editRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));

	JMenuItem editCut;
	editCut = new JMenuItem("Cut");
	editCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

	JMenuItem editCopy;
	editCopy = new JMenuItem("Copy");
	editCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

	JMenuItem editPaste;
	editPaste = new JMenuItem("Paste");
	editPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

	JMenuItem editDelete;
	editDelete = new JMenuItem("Delete");
	editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

	JMenuItem editSelectAll;
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
	// ------------------------------------------------------------

//--------------------------------------------------------------------------------

//BUTTON INITIALIZATION-----------------------------------------------------------
	// POINT BUTTON
	JButton pointButton = new JButton("Point");
	pointButton.setBounds(0, 0, 80, 25);
	leftPane.add(pointButton);

	// LINE BUTTON
	JButton lineButton = new JButton("Line");
	lineButton.setBounds(0, 25, 80, 25);
	leftPane.add(lineButton);

	// CLASS BUTTON
	JButton classButton = new JButton("Class");
	classButton.setBounds(0, 50, 80, 25);
	leftPane.add(classButton);
                
//--------------------------------------------------------------------------------
//GRAPHICS INITIALIZATION
                
        UMLClass cl = new UMLClass(50, 50);
        cl.setInfo("Test", "+ move(p : Point), + resize(s : Scale), + display(), #invalidateRegion(), #suspend(), #flush(), #thread(), #eventqueue()");
        rightPane.add(cl);

//--------------------------------------------------------------------------------
	}

	public void actionPerformed(ActionEvent e) 
	{
            PrinterJob pjob = PrinterJob.getPrinterJob();
            PageFormat preformat = pjob.defaultPage();
            preformat.setOrientation(PageFormat.LANDSCAPE);
            PageFormat postformat = pjob.pageDialog(preformat);
		
            if (preformat != postformat) {
		pjob.setPrintable(new Printer(splitPane), postformat);
		if (pjob.printDialog()) {
                    try {
                        pjob.print();
                    } 
                    catch (PrinterException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        }
}
