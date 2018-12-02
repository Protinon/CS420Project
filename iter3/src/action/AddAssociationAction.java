package action;

import java.util.ArrayList;

import object.Association;
import object.Class;

public class AddAssociationAction implements Action {
	private ArrayList<Association> associations;

	private Class parent;
	private Class child;

	private String childM;
	private String parentM;

	public AddAssociationAction(Class c1, Class c2, ArrayList<Association> associations, String childM,
			String parentM) {
		this.associations = associations;
		this.parent = c1;
		this.child = c2;
		this.childM = childM;
		this.parentM = parentM;
	}

	public void doAction() {
		if (parent != null && child != null) {
			Association cl = new Association(parent, child);
			associations.add(cl);
			cl.setChildMultiplicity(childM);
			cl.setParentMultiplicity(parentM);
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
