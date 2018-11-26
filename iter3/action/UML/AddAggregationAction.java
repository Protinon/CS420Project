package UML;

import java.util.ArrayList;

public class AddAggregationAction implements Action {
	private ArrayList<Aggregation> aggregations;

	private Class parent;
	private Class child;

	public AddAggregationAction (Class c1, Class c2, ArrayList<Aggregation> aggregations) {
		this.aggregations = aggregations;
		this.parent = c1;
		this.child = c2;
	}

	public void doAction() {
		if (parent != null && child != null) {
			aggregations.add(new Aggregation(parent, child));
			parent.setParentRelated(true);
			parent.setChild(child);
			child.setChildRelated(true);
			child.setParent(parent);
		}
	}

	public void undoAction() {
		aggregations.remove(parent);
		aggregations.remove(child);
	}
}
