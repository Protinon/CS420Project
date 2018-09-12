package UML;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UMLView {

public UMLView()
{
UMLController controller = new UMLController();
 
JFrame frame = new JFrame("UMLEditor");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
//Display the window.
        frame.pack();
        frame.setVisible(true);
        
        //Create Menu Bar
JMenuBar menuBar;
menuBar = new JMenuBar();
 
frame.setJMenuBar(menuBar);
 
//Create menu tab/submenu: file
JMenu file;
file = new JMenu("File");
 
//Add file submenu info
JMenuItem fileNew;
fileNew = new JMenuItem("New");
fileNew.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
fileNew.addActionListener((ActionEvent event ) -> {
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
fileClose.addActionListener((ActionEvent event) -> {
System.exit(0);
});
 
 
//add submenu info to file
 
file.add(fileNew);
file.add(fileOpen);
file.add(fileSave);
file.add(fileSaveAs);
file.addSeparator();
file.add(filePageSetup);
file.add(filePrint);
file.addSeparator();
file.add(fileClose);
 
//add file to menu
menuBar.add(file);
 
//Create menu tab: edit
JMenu edit;
edit = new JMenu("Edit");
 
//Add file submenu info
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
//add submenu info to file
 
edit.add(editUndo);
edit.add(editRedo);
edit.addSeparator();
edit.add(editCut);
edit.add(editCopy);
edit.add(editPaste);
edit.add(editDelete);
edit.addSeparator();
edit.add(editSelectAll);
 
//add file to menu
menuBar.add(edit);
 
JMenu view;
view = new JMenu("View");
 
JCheckBoxMenuItem toolbar;
toolbar = new JCheckBoxMenuItem("Show Toolbar");
 
view.add(toolbar);
 
menuBar.add(view);
 
}
}
