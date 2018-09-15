package UML;

import javax.swing.*;
import java.awt.EventQueue;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.awt.Color;
import java.awt.Dimension;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
 
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class UMLView extends JFrame{

public UMLView()
{
//FRAME INITIALIZATION------------------------------------------------------------
JFrame frame = new JFrame("UMLEditor");
frame.pack();
frame.setVisible(true);
frame.setSize(800, 600);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//--------------------------------------------------------------------------------

//PANEL INITIALIZATION------------------------------------------------------------
JPanel panel = new JPanel();
panel.setLayout(null);
frame.add(panel);
//--------------------------------------------------------------------------------

//MENU BAR INITIALIZATION---------------------------------------------------------
JMenuBar menuBar;
menuBar = new JMenuBar();
frame.setJMenuBar(menuBar);
	//TABS INITIALIZATION
		JMenu file;
		file = new JMenu("File");
		menuBar.add(file);
				//FILE SUB-MENU-------------------------------------------
				JMenuItem fileNew;
				fileNew = new JMenuItem("New");
				fileNew.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_N, ActionEvent.CTRL_MASK));
				fileNew.addActionListener((ActionEvent event ) -> 
				{
					UMLView x = new UMLView();
				});
		 
				JMenuItem fileOpen;
				fileOpen = new JMenuItem("Open...");
				fileOpen.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		 
				JMenuItem fileSave;
				fileSave = new JMenuItem("Save");
				fileSave.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		 
				JMenuItem fileSaveAs;
				fileSaveAs = new JMenuItem("Save As...");
		 
				JMenuItem filePageSetup;
				filePageSetup = new JMenuItem("Page Setup...");
		 
				JMenuItem filePrint;
				filePrint = new JMenuItem("Print...");
				filePrint.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		 
				JMenuItem fileClose;
				fileClose = new JMenuItem("Close");
				fileClose.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_W, ActionEvent.CTRL_MASK));
				fileClose.addActionListener((ActionEvent event) -> 
				{
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
				//------------------------------------------------------------	
		
		JMenu edit;
		edit = new JMenu("Edit");
		menuBar.add(edit);
				//EDIT SUB-MENU-----------------------------------------------
				JMenuItem editUndo;
				editUndo = new JMenuItem("Undo");
				editUndo.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		 
				JMenuItem editRedo;
				editRedo = new JMenuItem("Redo");
				editRedo.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		 
				JMenuItem editCut;
				editCut = new JMenuItem("Cut");
				editCut.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		 
				JMenuItem editCopy;
				editCopy = new JMenuItem("Copy");
				editCopy.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		 
				JMenuItem editPaste;
				editPaste = new JMenuItem("Paste");
				editPaste.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		 
				JMenuItem editDelete;
				editDelete = new JMenuItem("Delete");
				editDelete.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		 
				JMenuItem editSelectAll;
				editSelectAll = new JMenuItem("Select All");
				editSelectAll.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_A, ActionEvent.CTRL_MASK));
				
				edit.add(editUndo);
				edit.add(editRedo);
				edit.addSeparator();
				edit.add(editCut);
				edit.add(editCopy);
				edit.add(editPaste);
				edit.add(editDelete);
				edit.addSeparator();
				edit.add(editSelectAll);
				//------------------------------------------------------------
		
	
		
//--------------------------------------------------------------------------------
				
//BUTTON INITIALIZATION-----------------------------------------------------------
	//POINT BUTTON
	JButton pointButton = new JButton("Point");
	pointButton.setBounds(0, 0, 75, 25);
	panel.add(pointButton);
	
	//LINE BUTTON
	JButton lineButton = new JButton("Line");
	lineButton.setBounds(0, 25, 75, 25);
	panel.add(lineButton);
//--------------------------------------------------------------------------------
	}



}
