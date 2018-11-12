package UML;

import org.junit.jupiter.api.Test;

class ViewTest {
  
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testConstructor() {
		View view = new View();
		equals(view instanceof View);
	}

}
