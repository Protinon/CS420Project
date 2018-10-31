package UML;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommentTest {

	@Test
	void testSetLocation() {
		int x = 3;
		int y = 5;
		Comment stuff = new Comment(0, 0);
		
		stuff.setLocation(x,  y);
		
		
		
		assertEquals(x,stuff.x);
		
		assertEquals(y,stuff.y);
		
	}

}
