package object;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//100% Coverage 

public class CommentTest {

	public Comment comment;
	Canvas r;
	Controller c;

	@BeforeEach
	public void setup() {
		c = new Controller();
		r = new Canvas(c);
		comment = new Comment(50, 50, r);
	}
	@Test
	public void testContains() {
		Point upperLeftCorner = new Point(50, 50), insideObject = new Point(54, 60), aboveObject = new Point(49, 50),
				notNearObject = new Point(200, 300);

		assertEquals(true, comment.contains(upperLeftCorner));
		assertEquals(true, comment.contains(insideObject));
		assertEquals(false, comment.contains(aboveObject));
		assertEquals(false, comment.contains(notNearObject));

	}

	@Test
	public void testSetGetLocation() {
		Point defaultLocation = new Point(50, 50), negativeLocation = new Point(-10, -10),
				normalLocation = new Point(100, 100), outsideScreen = new Point(-100, -100);

		assertEquals(defaultLocation, comment.getLocation());

		comment.setLocation(negativeLocation.x, negativeLocation.y);
		assertEquals(negativeLocation, comment.getLocation());

		comment.setLocation(normalLocation.x, normalLocation.y);
		assertEquals(normalLocation, comment.getLocation());

		comment.setLocation(outsideScreen.x, outsideScreen.y);
		assertEquals(outsideScreen, comment.getLocation());

	}
	
	// Set data formality-unused function
		@Test
		public void testSetGetData() {
			String defaultData = "Comment", normalData = "Comment Test", emptyData = "";

			assertEquals(defaultData, comment.getData());
		
			comment.setData(normalData);
			assertEquals(normalData, comment.getData());
			
			comment.setData(emptyData);
			assertEquals(emptyData, comment.getData());
		}
			
	@Test
	public void testPaintComponent() {
		Controller c = new Controller();
		c.addComment(new Point(0,0));
	}

	@Test
	public void testGetHeight() {
		assertEquals(25, comment.getHeight());
	}
	
	@Test
	public void testGetWidth() {
		assertEquals(150, comment.getWidth());
	}
	
	@Test
	public void testDelete() {
		comment.delete();
		assertEquals(null, comment.getDataTextBox());
	}
}
