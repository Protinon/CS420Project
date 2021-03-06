package object;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ControllerTest {

	Controller c;
	Canvas r;
	Class clazz;

	@BeforeEach
	public void setup() {
		c = new Controller();
		r = new Canvas(c);
		clazz = new Class(0,0,r);
	}

	@Test
	void testFalsifyAllBut() {
		String[] s = { "deleteMode", "classMode", "commentMode", "aggregationMode", "dependencyMode", "associationMode",
				"compositionMode", "generalizationMode", "selectMode", "" };
		for (String s1 : s) {
			c.falsifyAllBut(s1);
			if (s1 == "deleteMode") {
				assertEquals(true, c.deleteMode());
				assertEquals(false, c.classMode());
				assertEquals(false, c.commentMode());
				assertEquals(false, c.aggregationMode());
				assertEquals(false, c.dependencyMode());
				assertEquals(false, c.associationMode());
				assertEquals(false, c.compositionMode());
				assertEquals(false, c.generalizationMode());
				assertEquals(false, c.selectMode());
			} else if (s1 == "classMode") {
				assertEquals(false, c.deleteMode());
				assertEquals(true, c.classMode());
				assertEquals(false, c.commentMode());
				assertEquals(false, c.aggregationMode());
				assertEquals(false, c.dependencyMode());
				assertEquals(false, c.associationMode());
				assertEquals(false, c.compositionMode());
				assertEquals(false, c.generalizationMode());
				assertEquals(false, c.selectMode());
			} else if (s1 == "commentMode") {
				assertEquals(false, c.deleteMode());
				assertEquals(false, c.classMode());
				assertEquals(true, c.commentMode());
				assertEquals(false, c.aggregationMode());
				assertEquals(false, c.dependencyMode());
				assertEquals(false, c.associationMode());
				assertEquals(false, c.compositionMode());
				assertEquals(false, c.generalizationMode());
				assertEquals(false, c.selectMode());
			} else if (s1 == "aggregationMode") {
				assertEquals(false, c.deleteMode());
				assertEquals(false, c.classMode());
				assertEquals(false, c.commentMode());
				assertEquals(true, c.aggregationMode());
				assertEquals(false, c.dependencyMode());
				assertEquals(false, c.associationMode());
				assertEquals(false, c.compositionMode());
				assertEquals(false, c.generalizationMode());
				assertEquals(false, c.selectMode());
			} else if (s1 == "dependencyMode") {
				assertEquals(false, c.deleteMode());
				assertEquals(false, c.classMode());
				assertEquals(false, c.commentMode());
				assertEquals(false, c.aggregationMode());
				assertEquals(true, c.dependencyMode());
				assertEquals(false, c.associationMode());
				assertEquals(false, c.compositionMode());
				assertEquals(false, c.generalizationMode());
				assertEquals(false, c.selectMode());
			} else if (s1 == "associationMode") {
				assertEquals(false, c.deleteMode());
				assertEquals(false, c.classMode());
				assertEquals(false, c.commentMode());
				assertEquals(false, c.aggregationMode());
				assertEquals(false, c.dependencyMode());
				assertEquals(true, c.associationMode());
				assertEquals(false, c.compositionMode());
				assertEquals(false, c.generalizationMode());
				assertEquals(false, c.selectMode());
			} else if (s1 == "compositionMode") {
				assertEquals(false, c.deleteMode());
				assertEquals(false, c.classMode());
				assertEquals(false, c.commentMode());
				assertEquals(false, c.aggregationMode());
				assertEquals(false, c.dependencyMode());
				assertEquals(false, c.associationMode());
				assertEquals(true, c.compositionMode());
				assertEquals(false, c.generalizationMode());
				assertEquals(false, c.selectMode());
			} else if (s1 == "generalizationMode") {
				assertEquals(false, c.deleteMode());
				assertEquals(false, c.classMode());
				assertEquals(false, c.commentMode());
				assertEquals(false, c.aggregationMode());
				assertEquals(false, c.dependencyMode());
				assertEquals(false, c.associationMode());
				assertEquals(false, c.compositionMode());
				assertEquals(true, c.generalizationMode());
				assertEquals(false, c.selectMode());
			} else if (s1 == "selectMode") {
				assertEquals(false, c.deleteMode());
				assertEquals(false, c.classMode());
				assertEquals(false, c.commentMode());
				assertEquals(false, c.aggregationMode());
				assertEquals(false, c.dependencyMode());
				assertEquals(false, c.associationMode());
				assertEquals(false, c.compositionMode());
				assertEquals(false, c.generalizationMode());
				assertEquals(true, c.selectMode());
			}
		}
	}

	@Test
	void fileActions() {

		ArgumentCaptor<ActionEvent> captor = forClass(ActionEvent.class);

		ActionListener fileMock = mock(ActionListener.class);

		c.getView().fileNew.addActionListener(fileMock);
		c.getView().fileNew.doClick();
		verify(fileMock, times(1)).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().fileNew.getComponent());

		c.getView().fileOpen.addActionListener(fileMock);
		c.getView().fileOpen.doClick();
		verify(fileMock, times(2)).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().fileOpen.getComponent());

		c.getView().fileSave.addActionListener(fileMock);
		c.getView().fileSave.doClick();
		verify(fileMock, times(3)).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().fileSave.getComponent());

		c.getView().fileSaveAs.addActionListener(fileMock);
		c.getView().fileSaveAs.doClick();
		verify(fileMock, times(4)).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().fileSaveAs.getComponent());

		c.getView().filePageSetup.addActionListener(fileMock);
		c.getView().filePageSetup.doClick();
		verify(fileMock, times(5)).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().filePageSetup.getComponent());

		c.getView().filePrint.addActionListener(fileMock);
		c.getView().filePrint.doClick();
		verify(fileMock, times(6)).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().filePrint.getComponent());

		c.getView().fileClose.addActionListener(fileMock);
		c.getView().fileClose.doClick();
		verify(fileMock, times(7)).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().fileClose.getComponent());

	}

	@Test
	void editActions() {

		ArgumentCaptor<ActionEvent> captor = forClass(ActionEvent.class);

		ActionListener editUndoClicked = mock(ActionListener.class);
		ActionListener editRedoClicked = mock(ActionListener.class);
		ActionListener editCutClicked1 = mock(ActionListener.class);
		ActionListener editCutClicked2 = mock(ActionListener.class);
		ActionListener editCutClicked3 = mock(ActionListener.class);
		ActionListener editCopyClicked1 = mock(ActionListener.class);
		ActionListener editCopyClicked2 = mock(ActionListener.class);
		ActionListener editCopyClicked3 = mock(ActionListener.class);
		ActionListener editPasteClicked1 = mock(ActionListener.class);
		ActionListener editPasteClicked2 = mock(ActionListener.class);
		ActionListener editPasteClicked3 = mock(ActionListener.class);
		ActionListener editDeleteClicked1 = mock(ActionListener.class);
		ActionListener editDeleteClicked2 = mock(ActionListener.class);
		ActionListener editDeleteClicked3 = mock(ActionListener.class);

		c.addAggregation(new Class(50, 50, r), new Class(300, 300, r), "", "");

		c.getView().editUndo.addActionListener(editUndoClicked);
		c.getView().editUndo.doClick();
		verify(editUndoClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editUndo.getComponent());

		c.getView().editRedo.addActionListener(editRedoClicked);
		c.getView().editRedo.doClick();
		verify(editRedoClicked).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editRedo.getComponent());

		c.addClass(new Point(500, 500));
		c.selectObject(new Point(505, 505));
		
		c.getView().editCut.addActionListener(editCutClicked1);
		c.getView().editCut.doClick();
		verify(editCutClicked1).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editCut.getComponent());
		
		c.getView().editCopy.addActionListener(editCopyClicked1);
		c.getView().editCopy.doClick();
		verify(editCopyClicked1).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editCopy.getComponent());
		
		c.getView().editPaste.addActionListener(editPasteClicked1);
		c.getView().editPaste.doClick();
		verify(editPasteClicked1).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editPaste.getComponent());
		
		c.getView().editDelete.addActionListener(editDeleteClicked1);
		c.getView().editDelete.doClick();
		verify(editDeleteClicked1).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editDelete.getComponent());

		
		c.addComment(new Point(650, 650));
		c.selectObject(new Point(655, 655));
		
		c.getView().editCut.addActionListener(editCutClicked2);
		c.getView().editCut.doClick();
		verify(editCutClicked2).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editCut.getComponent());
		
		c.getView().editCopy.addActionListener(editCopyClicked2);
		c.getView().editCopy.doClick();
		verify(editCopyClicked2).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editCopy.getComponent());
		
		c.getView().editPaste.addActionListener(editPasteClicked2);
		c.getView().editPaste.doClick();
		verify(editPasteClicked2).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editPaste.getComponent());

		c.getView().editDelete.addActionListener(editDeleteClicked2);
		c.getView().editDelete.doClick();
		verify(editDeleteClicked2).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editDelete.getComponent());
		

		c.selectObject(new Point(295, 300 + clazz.getHeight() / 2));
		
		c.getView().editCut.addActionListener(editCutClicked3);
		c.getView().editCut.doClick();
		verify(editCutClicked3).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editCut.getComponent());

		c.getView().editCopy.addActionListener(editCopyClicked3);
		c.getView().editCopy.doClick();
		verify(editCopyClicked3).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editCopy.getComponent());
		
		c.getView().editPaste.addActionListener(editPasteClicked3);
		c.getView().editPaste.doClick();
		verify(editPasteClicked3).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editPaste.getComponent());

		c.getView().editDelete.addActionListener(editDeleteClicked3);
		c.getView().editDelete.doClick();
		verify(editDeleteClicked3).actionPerformed(captor.capture());
		assertEquals(captor.getValue().getSource(), c.getView().editDelete.getComponent());
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

		c.getView().selectButton.addActionListener(selectButtonClicked);
		c.getView().selectButton.doClick();
		verify(selectButtonClicked).actionPerformed(captor1.capture());
		assertEquals(true, c.selectMode());

		c.getView().classButton.addActionListener(classButtonClicked);
		c.getView().classButton.doClick();
		verify(classButtonClicked).actionPerformed(captor2.capture());
		assertEquals(true, c.classMode());
		c.getView().commentButton.addActionListener(commentButtonClicked);
		c.getView().commentButton.doClick();
		verify(classButtonClicked).actionPerformed(captor3.capture());
		assertEquals(true, c.commentMode());

		c.getView().aggregationButton.addActionListener(aggregationButtonClicked);
		c.getView().aggregationButton.doClick();
		verify(aggregationButtonClicked).actionPerformed(captor4.capture());
		assertEquals(true, c.aggregationMode());

		c.getView().generalizationButton.addActionListener(generalizationButtonClicked);
		c.getView().generalizationButton.doClick();
		verify(generalizationButtonClicked).actionPerformed(captor5.capture());
		assertEquals(true, c.generalizationMode());

		c.getView().dependencyButton.addActionListener(dependencyButtonClicked);
		c.getView().dependencyButton.doClick();
		verify(dependencyButtonClicked).actionPerformed(captor6.capture());
		assertEquals(true, c.dependencyMode());

		c.getView().associationButton.addActionListener(associationButtonClicked);
		c.getView().associationButton.doClick();
		verify(associationButtonClicked).actionPerformed(captor7.capture());
		assertEquals(true, c.associationMode());

		c.getView().compositionButton.addActionListener(compositionButtonClicked);
		c.getView().compositionButton.doClick();
		verify(compositionButtonClicked).actionPerformed(captor8.capture());
		assertEquals(true, c.compositionMode());

		c.getView().deleteButton.addActionListener(deleteButtonClicked);
		c.getView().deleteButton.doClick();
		verify(deleteButtonClicked).actionPerformed(captor9.capture());
		assertEquals(true, c.deleteMode());

	}

	@Test
	public void testLeftOverGetters() {
		Canvas cc = c.getCanvas();
		assertEquals(c.getCanvas(), cc);

		c.addClass(new Point(0, 60));
		Class x = c.getClasses().get(0);
		c.selectObject(new Point(5, 63));
		assertEquals(x, c.getSelectedClass());

		c.addComment(new Point(30, 30));
		Comment y = c.getComments().get(0);
		c.selectObject(new Point(35, 35));
		assertEquals(y, c.getSelectedComment());

	}

	@Test
	public void testSelectObject() {
		Class x = new Class(800, 800, r);

		c.addDependency(new Class(200, 50, r), new Class(400, 50, r), "", "");
		c.selectObject(new Point(395, 50 + x.getHeight() / 2));
		assertEquals(c.getDependencies().get(0), c.getSelectedRelationship());

		c.selectObject(new Point(800, 800));
		assertEquals(null, c.getSelectedRelationship());

		c.addGeneralization(new Class(0, 300, r), new Class(200, 300, r), "", "");
		c.selectObject(new Point(195, 300 + x.getHeight() / 2));
		assertEquals(c.getGeneralizations().get(0), c.getSelectedRelationship());

		c.selectObject(new Point(800, 800));
		assertEquals(null, c.getSelectedRelationship());

		c.addAggregation(new Class(0, 0, r), new Class(200, 0, r), "", "");
		c.selectObject(new Point(195, 0 + x.getHeight() / 2));
		assertEquals(c.getAggregations().get(0), c.getSelectedRelationship());

		c.selectObject(new Point(800, 800));
		assertEquals(null, c.getSelectedRelationship());

		c.addAssociation(new Class(200, 0, r), new Class(400, 0, r), "", "");
		c.selectObject(new Point(395, 0 + x.getHeight() / 2));
		assertEquals(c.getAssociations().get(0), c.getSelectedRelationship());

		c.selectObject(new Point(800, 800));
		assertEquals(null, c.getSelectedRelationship());

		c.addComposition(new Class(0, 500, r), new Class(200, 500, r), "", "");
		c.selectObject(new Point(195, 500 + x.getHeight() / 2));
		assertEquals(c.getCompositions().get(0), c.getSelectedRelationship());

		c.selectObject(new Point(800, 800));
		assertEquals(null, c.getSelectedRelationship());

	}

	@Test
	public void testDeleteObject() {
		c.addClass(new Point(0, 0));
		Class z = c.getClasses().get(0);
		c.deleteObject(new Point(5, 5));
		assertEquals(0, c.getClasses().size());

		c.addComment(new Point(200, 0));
		Comment x = c.getComments().get(0);
		c.deleteObject(new Point(205, 5));
		assertEquals(0, c.getComments().size());

		c.addAggregation(new Class(100, 100, r), new Class(300, 100, r), "", "");
		c.deleteObject(new Point(260, 100 + z.getHeight() / 2));
		assertEquals(0, c.getAggregations().size());

		c.addAssociation(new Class(100, 300, r), new Class(300, 300, r), "", "");
		c.deleteObject(new Point(260, 300 + z.getHeight() / 2));
		assertEquals(0, c.getAssociations().size());

		c.addDependency(new Class(300, 300, r), new Class(600, 300, r), "", "");
		c.deleteObject(new Point(560, 300 + z.getHeight() / 2));
		assertEquals(0, c.getDependencies().size());

		c.addComposition(new Class(0, 500, r), new Class(300, 500, r), "", "");
		c.deleteObject(new Point(260, 500 + z.getHeight() / 2));
		assertEquals(0, c.getCompositions().size());

		c.addGeneralization(new Class(600, 700, r), new Class(800, 700, r), "", "");
		c.deleteObject(new Point(760, 700 + z.getHeight() / 2));
		assertEquals(0, c.getGeneralizations().size());
	}

	@Test
	public void testAddAggregationByPoint() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 0));
		c.addAggregation(new Point(0, 0));
		c.addAggregation(new Point(200, 0));

		assertEquals(1, c.getAggregations().size());
	}

	@Test
	public void testAddAssociationByPoint() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 0));
		c.addAssociation(new Point(0, 0));
		c.addAssociation(new Point(200, 0));

		assertEquals(1, c.getAssociations().size());
	}

	@Test
	public void testAddCompositionByPoint() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 0));
		c.addComposition(new Point(0, 0));
		c.addComposition(new Point(200, 0));

		assertEquals(1, c.getCompositions().size());
	}

	@Test
	public void testAddGeneralizationByPoint() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 0));
		c.addGeneralization(new Point(0, 0));
		c.addGeneralization(new Point(200, 0));

		assertEquals(1, c.getGeneralizations().size());
	}

	@Test
	public void testAddDependencyByPoint() {
		c.addClass(new Point(0, 0));
		c.addClass(new Point(200, 0));
		c.addDependency(new Point(0, 0));
		c.addDependency(new Point(200, 0));

		assertEquals(1, c.getDependencies().size());
	}

	@Test
	public void testReplicateClass() {
		c.addClass(new Point(0, 0));
		Class x = c.getClasses().get(0);
		x.setName("HELLO");
		c.addClass(x, new Point(100, 100));
		assertEquals(x.getName(), c.getClasses().get(1).getName());
	}

	@Test
	public void testBooleans() {
		c.addClass(new Point(0, 0));
		c.selectObject(new Point(5, 5));
		assertEquals(true, c.classSelected());

		c.addComment(new Point(100, 100));
		c.selectObject(new Point(105, 105));
		assertEquals(true, c.commentSelected());

		c.addClass(new Point(300, 0));
		c.addAggregation(c.getClasses().get(0), c.getClasses().get(1), "", "");
		c.selectObject(new Point(280, 0 + c.getClasses().get(0).getHeight() / 2));
		assertEquals(true, c.relationshipSelected());
	}

	@Test
	public void testHasARelationship() {
		c.addClass(new Point(200, 0));
		c.addClass(new Point(0, 0));

		c.addAggregation(new Point(5, 5));
		c.addAggregation(new Point(205, 5));

		c.addClass(new Point(400, 0));

		c.addAssociation(new Point(205, 5));
		c.addAssociation(new Point(405, 5));

		c.addAssociation(new Point(205, 5));
		c.addAssociation(new Point(5, 5));

		c.addAssociation(new Point(5, 5));
		c.addAssociation(new Point(205, 5));

		c.addDependency(new Point(405, 5));
		c.addDependency(new Point(205, 5));
	}
	
	@Test
	public void testRelationshipInspectorUpdateButton() {
		ArgumentCaptor<ActionEvent> captor = forClass(ActionEvent.class);

		ActionListener okayButtonClicked1 = mock(ActionListener.class);
		ActionListener okayButtonClicked2 = mock(ActionListener.class);
		ActionListener okayButtonClicked3 = mock(ActionListener.class);

		c.getClasses().removeAll(c.getClasses());
		c.getAggregations().removeAll(c.getAggregations());
		
		c.addClass(new Point(0,0));
		c.addClass(new Point(200,200));
		Class z = c.getClasses().get(0);
		Class y = c.getClasses().get(1);
		
		c.addAggregation(new Point(5,5));
		c.addAggregation(new Point(205,205));
		c.selectObject(new Point(195, 200 + clazz.getHeight()/2));
		
		c.getView().cMultiplicity.setText("5");
		c.getView().pMultiplicity.setText("1");
		
		c.getView().okayButton.addActionListener(okayButtonClicked1);
		c.getView().okayButton.doClick();
		verify(okayButtonClicked1).actionPerformed(captor.capture());
		
		assertEquals("5", c.getSelectedRelationship().getChildMultiplicity());
		assertEquals("1", c.getSelectedRelationship().getParentMultiplicity());
		
		assertEquals(z, c.getAggregations().get(0).getClass1());
		assertEquals(y, c.getAggregations().get(0).getClass2());
		
		c.getView().directionChange.setSelected(true);
		
		c.getView().okayButton.addActionListener(okayButtonClicked2);
		c.getView().okayButton.doClick();
		verify(okayButtonClicked2).actionPerformed(captor.capture());
		
		assertEquals(y, c.getAggregations().get(0).getClass1());
		assertEquals(z, c.getAggregations().get(0).getClass2());
		
		assertEquals(0, c.getCompositions().size());
		assertEquals(1, c.getAggregations().size());
		c.getView().relationshipTypes.setSelectedIndex(2);
		
		c.getView().okayButton.addActionListener(okayButtonClicked3);
		c.getView().okayButton.doClick();
		verify(okayButtonClicked3).actionPerformed(captor.capture());		
		
		assertEquals(0, c.getAggregations().size());
		assertEquals(1, c.getCompositions().size());
		}
}
