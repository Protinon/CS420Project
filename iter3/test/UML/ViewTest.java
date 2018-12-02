package object;

import org.junit.jupiter.api.Test;
//100% Coverage

class ViewTest {
  
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testConstructor() {
		Controller c = new Controller();
		Canvas cl = new Canvas(c);
		View view = new View(cl);
		equals(view instanceof View);
	}

}
