package UML;

import java.util.ArrayList;

public class AddAssociationAction implements Action {
	private ArrayList<Association> associations;

	private Class parent;
	private Class child;

	public AddAssociationAction (Class c1, Class c2, ArrayList<Association> associations) {
		this.associations = associations;
		this.parent = c1;
		this.child = c2;
	}

	public void doAction() {
		if (parent != null && child != null) {
			associations.add(new Association(parent, child));
			parent.setParentRelated(true);
			parent.setChild(child);
			child.setChildRelated(true);
			child.setParent(parent);
		}
	}

	public void undoAction() {
		associations.remove(parent);
		associations.remove(child);
	}
}
