package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddClassAction implements Action {
	Point p;
	Class c;
	ArrayList<Class> classes;
	public AddClassAction(Point p, ArrayList<Class> classes) {
		this.p = p;
		this.classes = classes;
	}
	
	public void doAction() { 
		c = new Class(p.x, p.y);
		classes.add(c);
	}
	
	public void undoAction() {
		classes.remove(c);
	}
}
