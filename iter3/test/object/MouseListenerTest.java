package object;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class MouseListenerTest {
	@Test
	public void testMousePressed() {
		Controller c = new Controller();

		ArgumentCaptor<ActionEvent> captor = forClass(ActionEvent.class);
		ActionListener selectButtonClicked = mock(ActionListener.class);
		ActionListener deleteButtonClicked1 = mock(ActionListener.class);
		ActionListener deleteButtonClicked2 = mock(ActionListener.class);
		ActionListener deleteButtonClicked3 = mock(ActionListener.class);
		ActionListener deleteButtonClicked4 = mock(ActionListener.class);
		ActionListener classButtonClicked = mock(ActionListener.class);
		ActionListener commentButtonClicked = mock(ActionListener.class);
		ActionListener associationButtonClicked = mock(ActionListener.class);
		ActionListener aggregationButtonClicked = mock(ActionListener.class);
		ActionListener compositionButtonClicked = mock(ActionListener.class);
		ActionListener dependencyButtonClicked = mock(ActionListener.class);
		ActionListener generalizationButtonClicked = mock(ActionListener.class);

		MouseEvent captor1 = new MouseEvent(c.getCanvas(), MouseEvent.MOUSE_PRESSED, 0, 0, 25, 25, 1, false);
		MouseEvent captor2 = new MouseEvent(c.getCanvas(), MouseEvent.MOUSE_PRESSED, 0, 0, 200, 200, 1, false);
		MouseEvent captor3 = new MouseEvent(c.getCanvas(), MouseEvent.MOUSE_PRESSED, 0, 0, 198, 232, 1, false);

		c.getView().classButton.addActionListener(classButtonClicked);
		c.getView().classButton.doClick();
		verify(classButtonClicked).actionPerformed(captor.capture());

		assertEquals(0, c.getClasses().size());
		c.getCanvas().dispatchEvent(captor1);
		c.getCanvas().dispatchEvent(captor2);

		assertEquals(2, c.getClasses().size());

		c.getView().selectButton.addActionListener(selectButtonClicked);
		c.getView().selectButton.doClick();
		verify(selectButtonClicked).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor1);
		assertEquals(true, c.classSelected());

		c.getView().commentButton.addActionListener(commentButtonClicked);
		c.getView().commentButton.doClick();
		verify(commentButtonClicked).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor1);
		assertEquals(1, c.getComments().size());

		c.getCanvas().dispatchEvent(captor3);
		assertEquals(0, c.getAssociations().size());

		c.getView().aggregationButton.addActionListener(aggregationButtonClicked);
		c.getView().aggregationButton.doClick();
		verify(aggregationButtonClicked).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor1);
		c.getCanvas().dispatchEvent(captor2);
		assertEquals(1, c.getAggregations().size());

		c.getView().deleteButton.addActionListener(deleteButtonClicked1);
		c.getView().deleteButton.doClick();
		verify(deleteButtonClicked1).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor3);
		assertEquals(0, c.getAggregations().size());

		c.getView().compositionButton.addActionListener(compositionButtonClicked);
		c.getView().compositionButton.doClick();
		verify(compositionButtonClicked).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor1);
		c.getCanvas().dispatchEvent(captor2);
		assertEquals(1, c.getCompositions().size());

		c.getView().deleteButton.addActionListener(deleteButtonClicked2);
		c.getView().deleteButton.doClick();
		verify(deleteButtonClicked2).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor3);
		assertEquals(0, c.getCompositions().size());

		c.getView().dependencyButton.addActionListener(dependencyButtonClicked);
		c.getView().dependencyButton.doClick();
		verify(dependencyButtonClicked).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor1);
		c.getCanvas().dispatchEvent(captor2);
		assertEquals(1, c.getDependencies().size());

		c.getView().deleteButton.addActionListener(deleteButtonClicked3);
		c.getView().deleteButton.doClick();
		verify(deleteButtonClicked3).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor3);
		assertEquals(0, c.getDependencies().size());

		c.getView().generalizationButton.addActionListener(generalizationButtonClicked);
		c.getView().generalizationButton.doClick();
		verify(generalizationButtonClicked).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor1);
		c.getCanvas().dispatchEvent(captor2);
		assertEquals(1, c.getGeneralizations().size());

		c.getView().deleteButton.addActionListener(deleteButtonClicked4);
		c.getView().deleteButton.doClick();
		verify(deleteButtonClicked4).actionPerformed(captor.capture());
		
		c.getCanvas().dispatchEvent(captor3);
		assertEquals(0, c.getGeneralizations().size());

		c.getView().associationButton.addActionListener(associationButtonClicked);
		c.getView().associationButton.doClick();
		verify(associationButtonClicked).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor1);
		c.getCanvas().dispatchEvent(captor2);
		assertEquals(1, c.getAssociations().size());
	}
	
	@Test
	public void testMouseDragged() {
		Controller c = new Controller();

		ArgumentCaptor<ActionEvent> captor = forClass(ActionEvent.class);

		ActionListener classButtonClicked = mock(ActionListener.class);
		ActionListener selectButtonClicked1 = mock(ActionListener.class);
		ActionListener selectButtonClicked2 = mock(ActionListener.class);
		ActionListener commentButtonClicked = mock(ActionListener.class);
		
		MouseEvent captor1 = new MouseEvent(c.getCanvas(), MouseEvent.MOUSE_PRESSED, 0, 0, 50, 50, 1, false);
		MouseEvent captor2 = new MouseEvent(c.getCanvas(), MouseEvent.MOUSE_PRESSED, 0, 0, 70, 70, 1, false);
		MouseEvent captor3 = new MouseEvent(c.getCanvas(), MouseEvent.MOUSE_DRAGGED, 0, 0, 75,50, 1, false);

		c.getView().classButton.addActionListener(classButtonClicked);
		c.getView().classButton.doClick();
		verify(classButtonClicked).actionPerformed(captor.capture());

		assertEquals(0, c.getClasses().size());
		c.getCanvas().dispatchEvent(captor1);
		c.getCanvas().dispatchEvent(captor2);

		

		c.getView().selectButton.addActionListener(selectButtonClicked1);
		c.getView().selectButton.doClick();
		verify(selectButtonClicked1).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor1);
		assertEquals(true, c.classSelected());
		
		c.getCanvas().dispatchEvent(captor3);
		
		c.getView().commentButton.addActionListener(commentButtonClicked);
		c.getView().commentButton.doClick();
		verify(commentButtonClicked).actionPerformed(captor.capture());
		
		assertEquals(0, c.getComments().size());
		c.getCanvas().dispatchEvent(captor1);

		assertEquals(1, c.getComments().size());

		c.getView().selectButton.addActionListener(selectButtonClicked2);
		c.getView().selectButton.doClick();
		verify(selectButtonClicked2).actionPerformed(captor.capture());

		c.getCanvas().dispatchEvent(captor1);
		assertEquals(true, c.commentSelected());
		
		c.getCanvas().dispatchEvent(captor3);
	}
}
