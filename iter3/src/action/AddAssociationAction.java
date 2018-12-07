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
	
	private Association assoc;

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
			assoc = new Association(parent, child);
			associations.add(assoc);
			
			assoc.setChildMultiplicity(childM);
			assoc.setParentMultiplicity(parentM);
	
			parent.setChild(child);
			child.setParent(parent);
			
			parent.setParentRelated();
			child.setChildRelated();
		}
	}

	public void undoAction() {
		associations.remove(assoc);
		assoc.setChildMultiplicity("");
		assoc.setParentMultiplicity("");
		parent.removeChild(child);
		child.removeParent(parent);
	}
}