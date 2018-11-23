package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddAssociationAction implements Action {
	private Point p1, p2;
	private ArrayList<Association> associations;
	private ArrayList<Class> classes;
	private Class class1, class2;

	public AddAssociationAction(Point p1, Point p2, ArrayList<Association> associations, ArrayList<Class> classes) {
		this.associations = associations;
		this.p1 = p1;
		this.p2 = p2;
		this.classes = classes;
	}

	public void doAction() {
		for (Class c : classes) {
				if (c.contains(p1)) {
					class1 = c;
				} else if (c.contains(p2)) {
					class2 = c;
				}
			}
		associations.add(new Association(class1,class2));
		class1.setParentRelated(true);
		class1.setChild(class2);
		class2.setChildRelated(true);
		class2.setParent(class1);
	}

	public void undoAction() {
		associations.remove(class1);
		associations.remove(class2);
	}
}
