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
	}

	public void fileActionListeners(UMLView view) {
		view.fileNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLView x = new UMLView();
			}
		});

		view.fileOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
						Desktop.getDesktop().open(file);
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
}
