package UML;

import java.util.ArrayList;

public class AddCompositionAction implements Action {
	private ArrayList<Composition> compositions;

	private Class parent;
	private Class child;

	public AddCompositionAction (Class c1, Class c2, ArrayList<Composition> compositions) {
		this.compositions = compositions;
		this.parent = c1;
		this.child = c2;
	}

	public void doAction() {
		if (parent != null && child != null) {
			compositions.add(new Composition(parent, child));
			parent.setParentRelated(true);
			parent.setChild(child);
			child.setChildRelated(true);
			child.setParent(parent);
		}
	}

	public void undoAction() {
		compositions.remove(parent);
		compositions.remove(child);
	}
}
