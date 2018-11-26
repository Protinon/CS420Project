package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddGeneralizationAction implements Action {
	private Point p1;
	private Point p2;

	private ArrayList<Generalization> generalizations;
	private ArrayList<Class> classes;

	private Class parent;
	private Class child;

	public AddGeneralizationAction(Point p1, Point p2, ArrayList<Generalization> generalizations,
			ArrayList<Class> classes) {
		this.generalizations = generalizations;
		this.p1 = p1;
		this.p2 = p2;
		this.classes = classes;
	}

	public void doAction() {
		for (Class c : classes) {
			if (c.contains(p1)) {
				parent = c;
			} else if (c.contains(p2)) {
				child = c;
			}
		}
		
		if (parent != null && child != null) {
			generalizations.add(new Generalization(parent, child));
			parent.setParentRelated(true);
			parent.setChild(child);
			child.setChildRelated(true);
			child.setParent(parent);
		}
	}

	public void undoAction() {
		generalizations.remove(parent);
		generalizations.remove(child);
	}
}
