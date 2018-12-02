package object;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;
//65.2% Coverage 

class CommentTest {

	Comment comment = new Comment(50,50);

	@Test
	void testContains() {
		Point upperLeftCorner = new Point(50, 50), insideObject = new Point(54, 60), aboveObject = new Point(49, 50),
				notNearObject = new Point(200, 300);

		assertEquals(true, comment.contains(upperLeftCorner));
		assertEquals(true, comment.contains(insideObject));
		assertEquals(false, comment.contains(aboveObject));
		assertEquals(false, comment.contains(notNearObject));

	}

	@Test
	void testSetGetLocation() {
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

	@Test
	public void testGetHeight() {
		assertEquals(50, comment.getHeight());
	}
	
	@Test
	public void testGetWidth() {
		assertEquals(125, comment.getWidth());
	}
}
