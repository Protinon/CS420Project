package UML;

import java.util.ArrayList;

public class AddGeneralizationAction implements Action {
	private ArrayList<Generalization> generalizations;

	private Class parent;
	private Class child;

	public AddGeneralizationAction (Class c1, Class c2, ArrayList<Generalization> generalizations) {
		this.generalizations = generalizations;
		this.parent = c1;
		this.child = c2;
	}

	public void doAction() {
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
