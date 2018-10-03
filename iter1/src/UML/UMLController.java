package UML;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class UMLController {
    
	public UMLController() {
		UMLView view = new UMLView();
		fileActionListeners(view);
		editActionListeners(view);
		viewActionListeners(view);
		buttonActionListeners(view);
	}

	public void fileActionListeners(UMLView view) {
		view.fileNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLView x = new UMLView();
			}
		});

		view.fileOpen.addActionListener(new ActionListener() {
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

		view.fileSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		view.fileSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea textArea = new JTextArea(24, 80);
				JFileChooser fileChooser = new JFileChooser();
				int retval = fileChooser.showSaveDialog(view.fileSaveAs);
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

		view.filePageSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		view.filePrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat preformat = pjob.defaultPage();
				preformat.setOrientation(PageFormat.LANDSCAPE);
				PageFormat postformat = pjob.pageDialog(preformat);

				if (preformat != postformat) {
					pjob.setPrintable(new Printer(view.splitPane), postformat);
					if (pjob.printDialog()) {
						try {
							pjob.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});

		view.fileClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public void editActionListeners(UMLView view) {
		view.editUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		view.editRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		view.editCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		view.editCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		view.editPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		view.editDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		view.editSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public void viewActionListeners(UMLView view) {

	}

	public void buttonActionListeners(UMLView view) {
		view.pointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLPoint p = new UMLPoint(200, 200);
				view.rightPane.add(p);
                                view.rightPane.repaint();
			}
		});

		view.classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLClass c = new UMLClass(200, 200);
				c.setInfo("Test",
						"+ move(p : Point), + resize(s : Scale), + display(), #invalidateRegion(), #suspend(), #flush(), #thread(), #eventqueue()");
				view.rightPane.add(c);
                                view.rightPane.repaint();
			}
		});

		view.commentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLComment c = new UMLComment(200, 200);
				view.rightPane.add(c);
                                view.rightPane.repaint();
			}
		});

		view.aggregationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLAggregation a = new UMLAggregation(200, 200);
				view.rightPane.add(a);
                                view.rightPane.repaint();
			}
		});

		view.generalizationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLGeneralization g = new UMLGeneralization(200, 200);
				view.rightPane.add(g);
                                view.rightPane.repaint();

			}
		});

		view.dependencyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLDependency d = new UMLDependency(200, 200);
				view.rightPane.add(d);
                                view.rightPane.repaint();
			}
		});

		view.associationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLAssociation a = new UMLAssociation(200, 200);
				view.rightPane.add(a);
                                view.rightPane.repaint();
			}
		});

		view.compositionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLComposition c = new UMLComposition(200, 200);
				view.rightPane.add(c);
                                view.rightPane.repaint();
			}
		});
	}
}


