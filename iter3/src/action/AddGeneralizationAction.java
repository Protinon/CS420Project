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
	
	private Generalization gen;

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
			gen = new Generalization(parent, child);
			generalizations.add(gen);
			
			gen.setChildMultiplicity(childM);
			gen.setParentMultiplicity(parentM);
	
			parent.setChild(child);
			child.setParent(parent);
			
			parent.setParentRelated();
			child.setChildRelated();
		}
	}

	public void undoAction() {
		generalizations.remove(gen);
		gen.setChildMultiplicity("");
		gen.setParentMultiplicity("");
		parent.removeChild(child);
		child.removeParent(parent);
	}
}