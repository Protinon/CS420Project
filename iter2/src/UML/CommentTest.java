package UML;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class CommentTest {

	Comment comment1 = new Comment(50, 50);
	Comment comment2 = new Comment(50, 50);
	Comment comment3 = new Comment(50, 50);
	Comment comment4 = new Comment(50, 50);

	@Test
	void testContains() {
		Point upperLeftCorner = new Point(50, 50), insideObject = new Point(54, 60), aboveObject = new Point(49, 50),
				notNearObject = new Point(200, 300);

		assertEquals(true, comment1.contains(upperLeftCorner.x, upperLeftCorner.y));
		assertEquals(true, comment2.contains(insideObject.x, insideObject.y));
		assertEquals(false, comment3.contains(aboveObject.x, aboveObject.y));
		assertEquals(false, comment4.contains(notNearObject.x, notNearObject.y));

	}

	@Test
	void testSetGetLocation() {
		Point defaultLocation = new Point(50, 50), negativeLocation = new Point(-10, -10),
				normalLocation = new Point(100, 100), outsideScreen = new Point(-100, -100);

		comment2.setLocation(negativeLocation.x, negativeLocation.y);
		comment3.setLocation(normalLocation.x, normalLocation.y);
		comment4.setLocation(outsideScreen.x, outsideScreen.y);

		assertEquals(defaultLocation, comment1.getLocation());
		assertEquals(negativeLocation, comment2.getLocation());
		assertEquals(normalLocation, comment3.getLocation());
		assertEquals(outsideScreen, comment4.getLocation());

	}

}
