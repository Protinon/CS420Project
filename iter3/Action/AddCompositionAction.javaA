package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddCompositionAction implements Action {
	private Point p;
	private ArrayList<Class> associations;
	private Class c;

	public AddCompositionAction(Class c, Point p, ArrayList<Class> associations) {
		this.associations = associations;
		this.p = p;
		this.c = c;

	}

	public void doAction() {
		associations.add(c);
	}

	public void undoAction() {
		associations.remove(c);
	}
}
