package UML;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ControllerTest {
	View v = new View();
	Controller c = new Controller(v);

	@Test
	void testFalsifyAllBut() {
		String[] s = { "deleteMode", "classMode", "commentMode", "aggregationMode", "dependencyMode", "associationMode",
				"compositionMode", "generalizationMode", "selectMode", "" };
		for (String s1 : s) {
			c.falsifyAllBut(s1);
			if (s1 == "deleteMode") {
				assertEquals(true, c.deleteMode);
				assertEquals(false, c.classMode);
				assertEquals(false, c.commentMode);
				assertEquals(false, c.aggregationMode);
				assertEquals(false, c.dependencyMode);
				assertEquals(false, c.associationMode);
				assertEquals(false, c.compositionMode);
				assertEquals(false, c.generalizationMode);
				assertEquals(false, c.selectMode);
			} else if (s1 == "classMode") {
				assertEquals(false, c.deleteMode);
				assertEquals(true, c.classMode);
				assertEquals(false, c.commentMode);
				assertEquals(false, c.aggregationMode);
				assertEquals(false, c.dependencyMode);
				assertEquals(false, c.associationMode);
				assertEquals(false, c.compositionMode);
				assertEquals(false, c.generalizationMode);
				assertEquals(false, c.selectMode);
			} else if (s1 == "commentMode") {
				assertEquals(false, c.deleteMode);
				assertEquals(false, c.classMode);
				assertEquals(true, c.commentMode);
				assertEquals(false, c.aggregationMode);
				assertEquals(false, c.dependencyMode);
				assertEquals(false, c.associationMode);
				assertEquals(false, c.compositionMode);
				assertEquals(false, c.generalizationMode);
				assertEquals(false, c.selectMode);
			} else if (s1 == "aggregationMode") {
				assertEquals(false, c.deleteMode);
				assertEquals(false, c.classMode);
				assertEquals(false, c.commentMode);
				assertEquals(true, c.aggregationMode);
				assertEquals(false, c.dependencyMode);
				assertEquals(false, c.associationMode);
				assertEquals(false, c.compositionMode);
				assertEquals(false, c.generalizationMode);
				assertEquals(false, c.selectMode);
			} else if (s1 == "dependencyMode") {
				assertEquals(false, c.deleteMode);
				assertEquals(false, c.classMode);
				assertEquals(false, c.commentMode);
				assertEquals(false, c.aggregationMode);
				assertEquals(true, c.dependencyMode);
				assertEquals(false, c.associationMode);
				assertEquals(false, c.compositionMode);
				assertEquals(false, c.generalizationMode);
				assertEquals(false, c.selectMode);
			} else if (s1 == "associationMode") {
				assertEquals(false, c.deleteMode);
				assertEquals(false, c.classMode);
				assertEquals(false, c.commentMode);
				assertEquals(false, c.aggregationMode);
				assertEquals(false, c.dependencyMode);
				assertEquals(true, c.associationMode);
				assertEquals(false, c.compositionMode);
				assertEquals(false, c.generalizationMode);
				assertEquals(false, c.selectMode);
			} else if (s1 == "compositionMode") {
				assertEquals(false, c.deleteMode);
				assertEquals(false, c.classMode);
				assertEquals(false, c.commentMode);
				assertEquals(false, c.aggregationMode);
				assertEquals(false, c.dependencyMode);
				assertEquals(false, c.associationMode);
				assertEquals(true, c.compositionMode);
				assertEquals(false, c.generalizationMode);
				assertEquals(false, c.selectMode);
			} else if (s1 == "generalizationMode") {
				assertEquals(false, c.deleteMode);
				assertEquals(false, c.classMode);
				assertEquals(false, c.commentMode);
				assertEquals(false, c.aggregationMode);
				assertEquals(false, c.dependencyMode);
				assertEquals(false, c.associationMode);
				assertEquals(false, c.compositionMode);
				assertEquals(true, c.generalizationMode);
				assertEquals(false, c.selectMode);
			} else if (s1 == "selectMode") {
				assertEquals(false, c.deleteMode);
				assertEquals(false, c.classMode);
				assertEquals(false, c.commentMode);
				assertEquals(false, c.aggregationMode);
				assertEquals(false, c.dependencyMode);
				assertEquals(false, c.associationMode);
				assertEquals(false, c.compositionMode);
				assertEquals(false, c.generalizationMode);
				assertEquals(true, c.selectMode);
			}
		}
	}

	@Test
	void fileActions() {

		ArgumentCaptor<ActionEvent> captor = forClass(ActionEvent.class);

		ActionListener fileNewClicked = mock(ActionListener.class);
		ActionListener fileOpenClicked = mock(ActionListener.class);
		ActionListener fileSaveClicked = mock(ActionListener.class);
		ActionListener fileSaveAsClicked = mock(ActionListener.class);
		ActionListener filePageSetupClicked = mock(ActionListener.class);
		ActionListener filePrintClicked = mock(ActionListener.class);
		ActionListener fileCloseClicked = mock(ActionListener.class);

		c.v.fileNew.addActionListener(fileNewClicked);
		c.v.fileNew.doClick();
		verify(fileNewClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.fileNew.getComponent());

		c.v.fileOpen.addActionListener(fileOpenClicked);
		c.v.fileOpen.doClick();
		verify(fileOpenClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.fileOpen.getComponent());

		c.v.fileSave.addActionListener(fileSaveClicked);
		c.v.fileSave.doClick();
		verify(fileSaveClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.fileSave.getComponent());

		c.v.fileSaveAs.addActionListener(fileSaveAsClicked);
		c.v.fileSaveAs.doClick();
		verify(fileSaveAsClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.fileSaveAs.getComponent());

		c.v.filePageSetup.addActionListener(filePageSetupClicked);
		c.v.filePageSetup.doClick();
		verify(filePageSetupClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.filePageSetup.getComponent());

		c.v.filePrint.addActionListener(filePrintClicked);
		c.v.filePrint.doClick();
		verify(filePrintClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.filePrint.getComponent());

		c.v.fileClose.addActionListener(fileCloseClicked);
		c.v.fileClose.doClick();
		verify(fileCloseClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.fileClose.getComponent());

	}

	@Test
	void editActions() {

		ArgumentCaptor<ActionEvent> captor = forClass(ActionEvent.class);

		ActionListener editUndoClicked = mock(ActionListener.class);
		ActionListener editRedoClicked = mock(ActionListener.class);
		ActionListener editCutClicked = mock(ActionListener.class);
		ActionListener editCopyClicked = mock(ActionListener.class);
		ActionListener editPasteClicked = mock(ActionListener.class);
		ActionListener editDeleteClicked = mock(ActionListener.class);
		ActionListener editSelectAllClicked = mock(ActionListener.class);

		c.v.editUndo.addActionListener(editUndoClicked);
		c.v.editUndo.doClick();
		verify(editUndoClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.editUndo.getComponent());

		c.v.editRedo.addActionListener(editRedoClicked);
		c.v.editRedo.doClick();
		verify(editRedoClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.editRedo.getComponent());

		c.v.editCut.addActionListener(editCutClicked);
		c.v.editCut.doClick();
		verify(editCutClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.editCut.getComponent());

		c.v.editCopy.addActionListener(editCopyClicked);
		c.v.editCopy.doClick();
		verify(editCopyClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.editCopy.getComponent());

		c.v.editPaste.addActionListener(editPasteClicked);
		c.v.editPaste.doClick();
		verify(editPasteClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.editPaste.getComponent());

		c.v.editDelete.addActionListener(editDeleteClicked);
		c.v.editDelete.doClick();
		verify(editDeleteClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.editDelete.getComponent());

		c.v.editSelectAll.addActionListener(editSelectAllClicked);
		c.v.editSelectAll.doClick();
		verify(editSelectAllClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.v.editSelectAll.getComponent());
	}

	@Test
	void buttonActions() {

		ArgumentCaptor<ActionEvent> captor1 = forClass(ActionEvent.class);
		ArgumentCaptor<ActionEvent> captor2 = forClass(ActionEvent.class);
		ArgumentCaptor<ActionEvent> captor3 = forClass(ActionEvent.class);
		ArgumentCaptor<ActionEvent> captor4 = forClass(ActionEvent.class);
		ArgumentCaptor<ActionEvent> captor5 = forClass(ActionEvent.class);
		ArgumentCaptor<ActionEvent> captor6 = forClass(ActionEvent.class);
		ArgumentCaptor<ActionEvent> captor7 = forClass(ActionEvent.class);
		ArgumentCaptor<ActionEvent> captor8 = forClass(ActionEvent.class);
		ArgumentCaptor<ActionEvent> captor9 = forClass(ActionEvent.class);
		ArgumentCaptor<ActionEvent> captor10 = forClass(ActionEvent.class);

		ActionListener selectButtonClicked = mock(ActionListener.class);
		ActionListener classButtonClicked = mock(ActionListener.class);
		ActionListener commentButtonClicked = mock(ActionListener.class);
		ActionListener aggregationButtonClicked = mock(ActionListener.class);
		ActionListener generalizationButtonClicked = mock(ActionListener.class);
		ActionListener dependencyButtonClicked = mock(ActionListener.class);
		ActionListener associationButtonClicked = mock(ActionListener.class);
		ActionListener compositionButtonClicked = mock(ActionListener.class);
		ActionListener deleteButtonClicked = mock(ActionListener.class);
		ActionListener okayButtonClicked = mock(ActionListener.class);

		c.v.selectButton.addActionListener(selectButtonClicked);
		c.v.selectButton.doClick();
		verify(selectButtonClicked).actionPerformed(captor1.capture());
		assertEquals(true, c.selectMode);

		c.v.classButton.addActionListener(classButtonClicked);
		c.v.classButton.doClick();
		verify(classButtonClicked).actionPerformed(captor2.capture());
		assertEquals(true, c.classMode);
		c.v.commentButton.addActionListener(commentButtonClicked);
		c.v.commentButton.doClick();
		verify(classButtonClicked).actionPerformed(captor3.capture());
		assertEquals(true, c.commentMode);

		c.v.aggregationButton.addActionListener(aggregationButtonClicked);
		c.v.aggregationButton.doClick();
		verify(aggregationButtonClicked).actionPerformed(captor4.capture());
		assertEquals(true, c.aggregationMode);

		c.v.generalizationButton.addActionListener(generalizationButtonClicked);
		c.v.generalizationButton.doClick();
		verify(generalizationButtonClicked).actionPerformed(captor5.capture());
		assertEquals(true, c.generalizationMode);

		c.v.dependencyButton.addActionListener(dependencyButtonClicked);
		c.v.dependencyButton.doClick();
		verify(dependencyButtonClicked).actionPerformed(captor6.capture());
		assertEquals(true, c.dependencyMode);

		c.v.associationButton.addActionListener(associationButtonClicked);
		c.v.associationButton.doClick();
		verify(associationButtonClicked).actionPerformed(captor7.capture());
		assertEquals(true, c.associationMode);

		c.v.compositionButton.addActionListener(compositionButtonClicked);
		c.v.compositionButton.doClick();
		verify(compositionButtonClicked).actionPerformed(captor8.capture());
		assertEquals(true, c.compositionMode);

		c.v.deleteButton.addActionListener(deleteButtonClicked);
		c.v.deleteButton.doClick();
		verify(deleteButtonClicked).actionPerformed(captor9.capture());
		assertEquals(true, c.deleteMode);

		if (c.selectedClass != null) {
			assertEquals(true, c.v.title.isVisible());
			assertEquals(true, c.v.atts.isVisible());
			assertEquals(true, c.v.ops.isVisible());
			assertEquals(true, c.v.okayButton.isVisible());

			c.v.title.setText("Hello");
			c.v.atts.setText("Example");
			c.v.ops.setText("Test");

			assertEquals(c.selectedClass.getName(), c.v.title);
			assertEquals(c.selectedClass.getAttributes(), c.v.atts);
			assertEquals(c.selectedClass.getOperations(), c.v.ops);

			c.v.okayButton.addActionListener(okayButtonClicked);
			c.v.okayButton.doClick();
			verify(okayButtonClicked).actionPerformed(captor10.capture());
		} else {
			assertEquals(false, c.v.title.isVisible());
			assertEquals(false, c.v.atts.isVisible());
			assertEquals(false, c.v.ops.isVisible());
			assertEquals(false, c.v.okayButton.isVisible());
		}

	}
}
