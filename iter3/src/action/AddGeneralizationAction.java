package action;

import java.util.ArrayList;
import object.Generalization;
import object.Class;

public class AddGeneralizationAction implements Action {
	private ArrayList<Generalization> generalizations;

	private Class parent;
	private Class child;

	private String childM;
	private String parentM;

	public AddGeneralizationAction(Class c1, Class c2, ArrayList<Generalization> generalizations, String childM,
			String parentM) {
		this.generalizations = generalizations;
		this.parent = c1;
		this.child = c2;
		this.childM = childM;
		this.parentM = parentM;
	}

	public void doAction() {
		if (parent != null && child != null) {
			Generalization cl = new Generalization(parent, child);
			generalizations.add(cl);
			cl.setChildMultiplicity(childM);
			cl.setParentMultiplicity(parentM);
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
